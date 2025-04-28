package backend.Refit.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
 public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String mobileNumber;

    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Child> children = new ArrayList<>();

   @Builder
    public Member(Long id, String email, String password, LocalDateTime createdAt, LocalDateTime updatedAt, String mobileNumber) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mobileNumber = mobileNumber;
    }
}