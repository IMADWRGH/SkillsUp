package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formateur extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullname;
    private String email;
    private String demaineExperter;


    /// Relation avec Evaluation *** Bidirectional association
    @OneToMany(mappedBy = "formateur" ,cascade = CascadeType.ALL)
    private List<Evaluation> evaluationList;

    /////Relation avec user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
