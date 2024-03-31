package IMADWRGH.MyJob.service;

import IMADWRGH.MyJob.Repository.OfferRepository;
import IMADWRGH.MyJob.entity.Offer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    public Optional<Offer> findById(int id) {
        return offerRepository.findById(id);
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public Boolean deleteById(int id) {
        offerRepository.deleteById(id);
        return Boolean.TRUE;
    }

    public Offer update(Offer offer,int id){
        Offer offer1 =offerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Offer not found"));
        if (offer1!=null){
           offer.setId(offer1.getId());
           return offerRepository.save(offer);
        }
        return  null;
    }


}
