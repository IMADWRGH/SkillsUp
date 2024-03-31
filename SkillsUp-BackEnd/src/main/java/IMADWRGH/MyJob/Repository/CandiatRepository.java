package IMADWRGH.MyJob.Repository;

import IMADWRGH.MyJob.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandiatRepository extends JpaRepository<Candidat,Integer> {
    Optional<Candidat> findByEmailIgnoreCase(String email);
    Optional<Candidat> findByUsernameIgnoreCase(String email);

}
