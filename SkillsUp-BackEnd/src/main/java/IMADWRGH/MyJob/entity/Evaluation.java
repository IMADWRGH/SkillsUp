package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double note;
    private String commentaire;
    private String date;

    /// Relation avec Candidat
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;


    ///Relation avec Formateur
    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;
}
