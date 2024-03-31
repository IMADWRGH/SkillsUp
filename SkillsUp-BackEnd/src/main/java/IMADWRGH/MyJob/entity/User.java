package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @Column(unique = true)
    private String username;
    private String password;

    ////Relation avec Avteurs
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Candidat candidat;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Formateur formateur;

    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private Recruteur recruteur;
}
