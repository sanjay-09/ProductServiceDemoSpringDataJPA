package com.example.ProductService.Services;

import com.example.ProductService.Models.Booking;
import com.example.ProductService.Models.Driver;
import com.example.ProductService.Models.DriverDTO;
import com.example.ProductService.Models.Review;
import com.example.ProductService.Repository.BookingRepository;
import com.example.ProductService.Repository.DriverRepository;
import com.example.ProductService.Repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RepositoryService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    private DriverRepository driverRepository;

    private BookingRepository bookingRepository;


    RepositoryService(ReviewRepository reviewRepository, DriverRepository driverRepository,BookingRepository bookingRepository){

        /// Spring Data JPA creates the repository implementation object, registers it as a Spring bean, and then the Spring container injects it into your constructor.

        this.reviewRepository=reviewRepository;
        this.driverRepository=driverRepository;
        this.bookingRepository=bookingRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("*****");

       //By default, IDEs (not Java itself) disable annotation processing because annotation processors
        //execute third-party code and generate additional code at compile time, which can impact
        //performance and change the project structure.
        //
        //To enable it:
        //Settings → Build, Execution, Deployment → Compiler → Annotation Processors → Enable
        //
        //To use Lombok comfortably during development, install the Lombok plugin in the IDE so that
        //the editor can understand the generated methods (getters, setters, builder, etc.).
//        Optional<Driver> driver= this.driverRepository.findById(1L);
//        if(driver.isPresent()){
//            Driver d=driver.get();
//            System.out.println(d.getId()+d.getName());
//        }
//
//        Optional<Driver> driver1=this.driverRepository.findByIdAndLicenseNumber(1L,"UPLIC1");
//        if(driver1.isPresent()){
//            Driver d=driver1.get();
//            System.out.println(d.getId()+d.getName());
//        }


//
//
//        Optional<Booking> bookings=this.bookingRepository.findById(1L);
//        if(bookings.isPresent()){
//            System.out.println(bookings.get().getDriver());
//        }
//
//
        Optional<DriverDTO> driver=this.driverRepository.rawFindByIdAndLicenseNumber2(1L,"UPLIC1");
        if(driver.isPresent()){
            DriverDTO d=driver.get();
            System.out.println(d.getLicensenumber());

        }






    }
}
