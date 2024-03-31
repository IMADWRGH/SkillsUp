package IMADWRGH.MyJob.Controller.Formateur;

import IMADWRGH.MyJob.entity.Formateur;
import IMADWRGH.MyJob.service.FormateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/formateur")
public class FormateurController {

    private final FormateurService formateurService;


    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Formateur> getFormateur(@PathVariable Integer id){
        return null;
    }
}
