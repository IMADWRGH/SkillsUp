package IMADWRGH.MyJob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String date;
    private boolean status;
    private String feedback;


    /////Relation avec Candidat
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

}
