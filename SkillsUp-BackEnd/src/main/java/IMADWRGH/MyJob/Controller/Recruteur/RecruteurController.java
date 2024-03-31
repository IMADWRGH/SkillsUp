package IMADWRGH.MyJob.Controller.Recruteur;

import IMADWRGH.MyJob.entity.Offer;
import IMADWRGH.MyJob.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/offer")
public class RecruteurController {

    private final OfferService offerService;

    public RecruteurController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<Offer> createOffer(@PathVariable Integer id, @RequestBody Offer offer){
       offerService.save(offer);
        return new ResponseEntity<>(offer , HttpStatus.CREATED);
    }


}
