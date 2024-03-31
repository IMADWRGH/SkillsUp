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
public class Recruteur extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullname;
    private String email;
    private String nomEntreprise;

    //Relation avec Offer
    @OneToMany(mappedBy = "recruteur",cascade = CascadeType.ALL)
    private List<Offer> offerList;

    /////Relation avec user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
