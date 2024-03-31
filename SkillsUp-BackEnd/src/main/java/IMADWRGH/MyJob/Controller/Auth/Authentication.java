package IMADWRGH.MyJob.Controller.Auth;

import IMADWRGH.MyJob.Controller.Model.*;
import IMADWRGH.MyJob.Exception.UserException;
import IMADWRGH.MyJob.entity.User;
import IMADWRGH.MyJob.service.CandidatService;
import IMADWRGH.MyJob.service.FormateurService;
import IMADWRGH.MyJob.service.RecruteurService;
import IMADWRGH.MyJob.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "auth")
public class Authentication {

    private final UserService userService;
    private final RecruteurService recruteurService;
    private final FormateurService formateurService;
    private final CandidatService candidatService;


    public Authentication(UserService userService, RecruteurService recruteurService, FormateurService formateurService, CandidatService candidatService) {
        this.userService = userService;
        this.recruteurService = recruteurService;
        this.formateurService = formateurService;
        this.candidatService = candidatService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginResponse> LoginUser(@Valid @RequestBody LoginBody loginBody) {
        String jwt = userService.Login(loginBody);
        if (jwt == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping(path = "/registerRecruteur")
    public ResponseEntity<Void> RegisterUser(@Valid @RequestBody RecruteurRegistrationBody registrationBody)  {
        try {
            recruteurService.registerRecruteur(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/registerCandidat")
    public ResponseEntity<Void> RegisterUser(@Valid @RequestBody CandidatRegistrationBody registrationBody)  {
        try {
            candidatService.registerCandidat(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PostMapping(path = "/registerFormateur")
    public ResponseEntity<Void> RegisterUser(@Valid @RequestBody FormateurRegistrationBody registrationBody)  {
        try {
            formateurService.registerFormation(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/profile")
    public User getLoggedInUserProfile(@AuthenticationPrincipal User user){
        return user;
    }



}


