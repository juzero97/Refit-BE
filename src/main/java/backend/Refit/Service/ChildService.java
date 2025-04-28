package backend.Refit.Service;

import backend.Refit.Entity.Child;
import backend.Refit.Repository.ChildRepository;
import backend.Refit.Request.Childrequest;
import backend.Refit.Response.ChildListResponse;
import backend.Refit.Response.ChildResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    @Transactional
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
                .build();

        return childResponse;
    }

    public void delete(Long childId) {
        Child child = childRepository.findById(childId).orElseThrow(
                () -> new IllegalArgumentException("해당 자식을 찾을수없습니다.")
        );

        childRepository.delete(child);
    }

    public List<ChildListResponse> listGet() {
        List<Child> childList =childRepository.findAll();
        List<ChildListResponse> responseDtos= new ArrayList<>();
        for(Child child: childList){
            ChildListResponse childListResponse =new ChildListResponse(child);
            responseDtos.add(childListResponse);
        }
        return responseDtos;
    }

    public ChildResponse deteailget(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new IllegalArgumentException("해당 자식을 찾을수없습니다."));

        return ChildResponse.builder()
                .id(child.getId())
                .name(child.getName())
                .gender(child.getGender())
                .build();
    }
}
