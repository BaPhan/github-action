package com.demo2;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    //api test
    @GetMapping("/test1")
    public ResponseEntity<String> testGet(){
        return ResponseEntity.ok("Hello jenkins !!!");
    }
    @GetMapping("/test2")
    public ResponseEntity<?> getImage(){
        try {
            // Load ảnh từ thư mục static
            Resource resource = new ClassPathResource("static/download.jpg");

            if (!resource.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }

            // Trả về ảnh với header Content-Type
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    //demo2
    //test job 2
    @GetMapping("/bapv")
    public ResponseEntity<String> testGet2(){
        return ResponseEntity.ok("Build Jenkins 2!");
    }
}
