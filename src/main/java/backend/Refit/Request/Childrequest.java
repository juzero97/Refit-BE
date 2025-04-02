package backend.Refit.Request;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Childrequest {

    private String name;
    private String gender;
    private LocalDateTime birth_date;
    private Double height;
    private Double weight;
    private String size;
    private String  profile_image_url;

}
