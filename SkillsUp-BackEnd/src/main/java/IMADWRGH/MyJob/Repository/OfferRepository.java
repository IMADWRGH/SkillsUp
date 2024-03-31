package IMADWRGH.MyJob.Repository;

import IMADWRGH.MyJob.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
}
