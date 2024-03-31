package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.Controller.Model.CandidatRegistrationBody;
import IMADWRGH.MyJob.Controller.Model.RecruteurRegistrationBody;
import IMADWRGH.MyJob.Exception.UserException;
import IMADWRGH.MyJob.Repository.RecruteurRepository;
import IMADWRGH.MyJob.entity.Candidat;
import IMADWRGH.MyJob.entity.Recruteur;
import org.springframework.stereotype.Service;

@Service
public class RecruteurService {

    private final EncryptionService encryptionService;
    private final RecruteurRepository recruteurRepository;


    public RecruteurService(EncryptionService encryptionService, RecruteurRepository recruteurRepository) {
        this.encryptionService = encryptionService;
        this.recruteurRepository = recruteurRepository;
    }

    public void registerRecruteur(RecruteurRegistrationBody registrationBody)  {
        if(recruteurRepository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()
                || recruteurRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()){
            throw new UserException("Candidate already exists");
        }
        Recruteur recruteur=new Recruteur();
        recruteur.setFullname(registrationBody.getFullname());
        recruteur.setEmail(registrationBody.getEmail());
        recruteur.setUsername(registrationBody.getUsername());
        recruteur.setNomEntreprise(registrationBody.getNomEntreprise());
        recruteur.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        recruteurRepository.save(recruteur);
    }
}
