package backend.Refit.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
 @JsonFormat(shape = JsonFormat.Shape.OBJECT)
 public enum ErrorCode {
    MOBILE_ALREADY_EXISTS(400,"C001","해당 전화번호가 존재합니다"),
     EMAIL_ALREADY_EXISTS(400,"C001","해당 이메일이 존재합니다");
     private final int status;
     private final String code;
     private final String message;
 
     ErrorCode(int status, String code, String message) {
         this.status = status;
         this.code = code;
         this.message = message;
     }
 }