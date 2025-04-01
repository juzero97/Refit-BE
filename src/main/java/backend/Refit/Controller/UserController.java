package backend.Refit.Controller;

import backend.Refit.Request.SignupRequest;
import backend.Refit.Response.SignupResponse;
import backend.Refit.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
 @RequiredArgsConstructor
 public class UserController {
 
     private final UserService userService;
 
     @PostMapping("/api/signup")
     public ResponseEntity<?> signUp(@RequestBody SignupRequest request) {
         userService.signUp(request);
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody SignupRequest request) {
        userService.login(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
 
 }