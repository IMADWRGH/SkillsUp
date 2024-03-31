package IMADWRGH.MyJob.Repository;

import IMADWRGH.MyJob.entity.Formateur;
import IMADWRGH.MyJob.entity.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur,Integer> {

    Optional<Recruteur> findByUsernameIgnoreCase(String unsermane);

    Optional<Recruteur> findByEmailIgnoreCase(String emial);
}
