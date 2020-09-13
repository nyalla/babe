package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BabeController {

    @PostMapping(path = "/trigger", consumes = "application/json")
    public Object trigger(@RequestBody String json) {

        Object response =null;
        try {
            //Logic to create project
            if (response != null)
                return ResponseEntity.ok("success");
            else
                return ResponseEntity.ok("failed");
        } catch (Exception e) {
            return ResponseEntity.badRequest();
        }
    }
}
