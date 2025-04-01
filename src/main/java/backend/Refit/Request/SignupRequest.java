package backend.Refit.Request;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class SignupRequest {
    private String email;
    private String password;
    private String mobileNumber;

    public SignupRequest(String email, String password, String mobileNumber) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
}
