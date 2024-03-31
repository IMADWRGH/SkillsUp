package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String description;
    private double salaire;
    private String lieu;
    private String nomEntreprise;

    ///Relation avec Recruteur
    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    private Recruteur recruteur;
}
