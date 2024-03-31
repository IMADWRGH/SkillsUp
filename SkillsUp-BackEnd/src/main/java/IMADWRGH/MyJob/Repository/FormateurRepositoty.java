package IMADWRGH.MyJob.Repository;

import IMADWRGH.MyJob.entity.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormateurRepositoty extends JpaRepository<Formateur,Integer> {
    Optional<Formateur> findByUsernameIgnoreCase(String unsermane);

    Optional<Formateur> findByEmailIgnoreCase(String emial);
}
