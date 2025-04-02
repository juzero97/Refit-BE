package backend.Refit.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChildResponse {
    private Long Childid;
    private String name;
    private String gender;

    @Builder
    public ChildResponse(Long id, String name, String gender) {
        this.Childid = id;
        this.name = name;
        this.gender = gender;
    }

}
