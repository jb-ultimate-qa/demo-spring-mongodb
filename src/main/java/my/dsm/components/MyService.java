package my.dsm.components;

import my.dsm.model.CustomerRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class MyService {

    private final CustomerRepository customerRepository;

    MyService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    void checkCustomerQuery() {
        customerRepository.findByFirstNameQuery("John");

        customerRepository.findByFullNameQuery("Jane", "Smith");

        customerRepository.findByLastNames(List.of("Smith", "Brown"));

        customerRepository.findByFirstNameRegex("^Jo");

        customerRepository.existsByLastNameQuery("Williams");

        customerRepository.findPageByLastName("Smith", Pageable.ofSize(10));
    }
}
