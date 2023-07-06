package com.travelbookingsystem.offers.repository;

        import com.travelbookingsystem.offers.model.Offer;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {
        List<Offer> findByOfferName(String offerName);

}
