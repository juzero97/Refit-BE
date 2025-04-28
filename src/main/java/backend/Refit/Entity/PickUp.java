package backend.Refit.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter

public class PickUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupTime;
    private String pickupDate;
    private String season;
    private String address;
    private String kind;
    private String gender;
    private String memo;
    private String photoUrl;

    @Builder
    public PickUp(Long id, String pickupTime, String pickupDate, String season, String address, String kind, String gender, String memo, String status, String photoUrl) {
        this.id = id;
        this.pickupTime = pickupTime;
        this.pickupDate = pickupDate;
        this.season = season;
        this.address = address;
        this.kind = kind;
        this.gender = gender;
        this.memo = memo;
        this.photoUrl = photoUrl;
    }
}
