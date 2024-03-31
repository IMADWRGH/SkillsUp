package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidat extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String fullname;
    @Column(unique = true)
    private String email;
    private String adress;
    private String tel;
    // they are two of type byte[] or string
    @Lob
    @NotBlank
    private byte[] cv;


    ////// Relation avec  Competence
    @OneToMany(mappedBy = "candidat",cascade = CascadeType.ALL)
    private List<Competence> competenceList;


    ////// Relation avec  Postulation
    @OneToMany(mappedBy = "candidat",cascade = CascadeType.ALL)
    private List<Postulation> postulationList;

    ////Relation avec Evaluation
    @OneToMany(mappedBy = "candidat",cascade = CascadeType.ALL)
    private List<Evaluation> evaluationList;

    /////Relation avec user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;










}
