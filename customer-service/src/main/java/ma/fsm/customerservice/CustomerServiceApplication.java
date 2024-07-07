package ma.fsm.customerservice;

import ma.fsm.customerservice.config.GlobalConfig;
import ma.fsm.customerservice.entities.Customer;
import ma.fsm.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
         return args -> {
             List<Customer> customerList = List.of(
                     Customer.builder()
                             .firstName("Hassan")
                             .lastName("El kadah")
                             .email("hassan@gmail.com")
                             .build(),
                     Customer.builder()
                             .firstName("Rachid")
                             .lastName("El kadah")
                             .email("rachid@gmail.com")
                             .build()
             );
             customerRepository.saveAll(customerList);
        };
    }
}
