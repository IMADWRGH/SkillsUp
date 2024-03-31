package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String langagePro;
    private String frameWork;
    private String niveau;

    /// Relation avec Candidat
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;
}
