package com.example.hotelbooking;
import com.example.hotelbooking.model.HotelDetails;
import com.example.hotelbooking.repository.HotelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class HotelRepositoryTest {
    @Autowired private HotelRepository repo;

    @Test
    public void testAddNew(){

        HotelDetails hd = new HotelDetails();

        hd.setHotelName("ABCSA");
        hd.setLocation("Colombo");

        HotelDetails saveHotel = repo.save(hd);

        Assertions.assertThat(saveHotel).isNotNull();
        Assertions.assertThat(saveHotel.getHid()).isGreaterThan(0);
    }

    @Test
    public void testHotelList(){
        Iterable<HotelDetails> hotels = repo.findAll();
        Assertions.assertThat(hotels).hasSizeGreaterThan(0);
        
        for(HotelDetails hotel :hotels){
            System.out.println(hotel);
        }
    }
    
    @Test
    public void hotelUpdate(){
        Integer hid = 1;
        Optional<HotelDetails> optionalHotel = repo.findById(hid);
        repo.findById(hid);
        
        HotelDetails hd = optionalHotel.get();
        hd.setLocation("Negombo");
        repo.save(hd);

        HotelDetails updateHotel = repo.findById(hid).get();
        Assertions.assertThat(updateHotel.getLocation()).isEqualTo("Negombo");
    }

    @Test
    public void getHotels(){
        Integer hid = 2;
        Optional<HotelDetails> optionalHotel = repo.findById(hid);
        HotelDetails hd = optionalHotel.get();
        Assertions.assertThat(optionalHotel).isPresent();
        System.out.println(optionalHotel.get());

    }
    @Test
    public void deleteHotels(){
        Integer hid = 5;
        repo.deleteById(hid);

        Optional<HotelDetails> optionalHotel = repo.findById(hid);
        Assertions.assertThat(optionalHotel).isNotPresent();

    }

}
