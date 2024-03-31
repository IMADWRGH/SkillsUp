package IMADWRGH.MyJob.service;


import IMADWRGH.MyJob.Controller.Model.FormateurRegistrationBody;
import IMADWRGH.MyJob.Exception.UserException;
import IMADWRGH.MyJob.Repository.FormateurRepositoty;
import IMADWRGH.MyJob.entity.Formateur;
import org.springframework.stereotype.Service;

@Service
public class FormateurService {

    private final FormateurRepositoty formateurRepositoty;
    private final EncryptionService encryptionService;

    public FormateurService(FormateurRepositoty formateurRepositoty, EncryptionService encryptionService) {
        this.formateurRepositoty = formateurRepositoty;
        this.encryptionService = encryptionService;
    }


    public void registerFormation(FormateurRegistrationBody registrationBody)  {
        if(formateurRepositoty.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()
                || formateurRepositoty.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()){
            throw new UserException("Formateur already exists");
        }
        Formateur formateur=new Formateur();
        formateur.setFullname(registrationBody.getFullname());
        formateur.setEmail(registrationBody.getEmail());
        formateur.setUsername(registrationBody.getUsername());
        formateur.setDemaineExperter(registrationBody.getDemaineExperter());
        formateur.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
        formateurRepositoty.save(formateur);
    }
}
