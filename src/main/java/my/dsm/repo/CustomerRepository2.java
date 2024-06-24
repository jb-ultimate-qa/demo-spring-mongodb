package my.dsm.repo;

import my.dsm.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository2 extends MongoRepository<Customer, String> {

    public List<Customer> findByFirstName(String firstName);

}