package com.example.ProductService.Services;

import com.example.ProductService.Repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
public class RepositoryService implements CommandLineRunner {

    private ReviewRepository reviewRepository;




    RepositoryService(ReviewRepository reviewRepository){

        /// Spring Data JPA creates the repository implementation object, registers it as a Spring bean, and then the Spring container injects it into your constructor.

        this.reviewRepository=reviewRepository;
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



    }
}
