package backend.Refit.Service;

import backend.Refit.Entity.Child;
import backend.Refit.Repository.ChildRepository;
import backend.Refit.Request.Childrequest;
import backend.Refit.Response.ChildResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    public ChildResponse enroll(Childrequest request) {
        String name = request.getName();
        String gender = request.getGender();
        Double height = request.getHeight();
        Double weight = request.getWeight();
        String size = request.getSize();
        String profile_image_url = request.getProfile_image_url();

        Child child = Child.builder()
                .name(name)
                .gender(gender)
                .height(height)
                .weight(weight)
                .size(size)
                .profile_image_url(profile_image_url)
                .build();

       childRepository.save(child);

       ChildResponse childResponse = ChildResponse
               .builder()
               .gender(gender)
               .name(name)
               .id(child.getId())
               .build();

       return childResponse;


    }
}
