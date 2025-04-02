package backend.Refit.Controller;

import backend.Refit.Request.Childrequest;
import backend.Refit.Response.ChildResponse;
import backend.Refit.Service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    @PostMapping("/api/children")
    public ResponseEntity<?> enroll(@RequestBody Childrequest request) {
        ChildResponse response = childService.enroll(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
