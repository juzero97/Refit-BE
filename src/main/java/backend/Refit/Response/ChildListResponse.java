package backend.Refit.Response;

import backend.Refit.Entity.Child;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ChildListResponse {
    private Long id;
    private String name;
    private String gender;
    private LocalDateTime birth_date;
    private Double height;
    private Double weight;
    private String size;
    private String  profile_image_url;

    public ChildListResponse(Child child) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.height = height;
        this.weight = weight;
        this.size = size;
        this.profile_image_url = profile_image_url;
    }
}
