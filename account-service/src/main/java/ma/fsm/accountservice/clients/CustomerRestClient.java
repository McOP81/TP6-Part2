package ma.fsm.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.fsm.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id, Exception e){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not vailable");
        customer.setLastName("Not vailable");
        customer.setEmail("Not vailable");
        return customer;
    }
    default List<Customer> getDefaultCustomers(Exception e){
        return List.of();
    }

}
