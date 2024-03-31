package IMADWRGH.MyJob.Controller.Candidat;

import IMADWRGH.MyJob.service.CandidatService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatController {
    private final CandidatService candidatService;

    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }
}
