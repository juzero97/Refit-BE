package backend.Refit.Controller;

import backend.Refit.Request.Childrequest;
import backend.Refit.Response.ChildListResponse;
import backend.Refit.Response.ChildResponse;
import backend.Refit.Service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;
    /*아이 등록*/
    @PostMapping("/api/children")
    public ResponseEntity<?> enroll(@RequestBody Childrequest request) {
        ChildResponse response = childService.enroll(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    /*아이 삭제*/
    @DeleteMapping("/api/children/{childId}")
    public  ResponseEntity<?> delete(@PathVariable Long childId){
        childService.delete(childId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("삭제가 완료되었습니다");
    }

    /*아이 목록 조회*/
    @GetMapping("/api/children")
    public ResponseEntity<?> listChildren() {
        List<ChildListResponse> response = childService.listGet();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    /*특정 아이 목록 조회*/
    @GetMapping("/api/children/{childId}")
    public ResponseEntity<?> detailChildren(@PathVariable Long childId){
        ChildResponse response = childService.deteailget(childId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
