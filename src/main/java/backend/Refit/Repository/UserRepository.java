package backend.Refit.Repository;

import backend.Refit.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Member, Long> {
     Optional<Member> findByEmail(String email);
     Optional<Member> findBymobileNumber(String mobileNumber);
     Optional<Member> findById(Long id);
}