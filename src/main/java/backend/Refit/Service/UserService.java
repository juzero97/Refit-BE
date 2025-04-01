package backend.Refit.Service;

import backend.Refit.Entity.Member;
import backend.Refit.Exception.CustomException;
import backend.Refit.Repository.UserRepository;
import backend.Refit.Request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static backend.Refit.Exception.ErrorCode.EMAIL_ALREADY_EXISTS;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void signUp(SignupRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        String mobileNumber = request.getMobileNumber();


        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new CustomException(EMAIL_ALREADY_EXISTS);
        }

        if (userRepository.findBymobileNumber(mobileNumber).isPresent()){
            throw new CustomException(EMAIL_ALREADY_EXISTS);
        }
        Member member = Member.builder()
                .password(password)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();
        userRepository.save(member);
    }

    public void login(SignupRequest request) {

    }
}
