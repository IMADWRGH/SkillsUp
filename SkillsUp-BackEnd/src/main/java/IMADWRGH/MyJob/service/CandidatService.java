package IMADWRGH.MyJob.service;


import IMADWRGH.MyJob.Controller.Model.CandidatRegistrationBody;
import IMADWRGH.MyJob.Exception.UserException;
import IMADWRGH.MyJob.Repository.CandiatRepository;
import IMADWRGH.MyJob.entity.Candidat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

   private final CandiatRepository candiatRepository;

   private final EncryptionService encryptionService;

    public CandidatService(CandiatRepository candiatRepository, EncryptionService encryptionService, JwtService jwtService) {
        this.candiatRepository = candiatRepository;
        this.encryptionService = encryptionService;
    }

    public void registerCandidat(CandidatRegistrationBody registrationBody)  {
       if(candiatRepository.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()
       || candiatRepository.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()){
    throw new UserException("Candidate already exists");
       }
        Candidat candidat = new Candidat();
        candidat.setFullname(registrationBody.getFullname());
        candidat.setEmail(registrationBody.getEmail());
        candidat.setUsername(registrationBody.getUsername());
        candidat.setCv(registrationBody.getCv());
        candidat.setAdress(registrationBody.getAdress());
        candidat.setTel(registrationBody.getTel());
        candidat.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
      candiatRepository.save(candidat);
    }

    public Optional<Candidat> getCandidat(int id){
        return candiatRepository.findById(id);
    }

    public List<Candidat> listCandidat(){
        return candiatRepository.findAll();
    }

    public Boolean delete(int id){
        candiatRepository.deleteById(id);
        return Boolean.TRUE;
    }

    public Candidat  update(Candidat candidat){
        return candiatRepository.save(candidat);
    }





}
