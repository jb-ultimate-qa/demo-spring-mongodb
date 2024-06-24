package my.dsm;

import my.dsm.model.Order;
import my.dsm.model.OrderRepository;
import my.dsm.nested_doc.Building;
import my.dsm.nested_doc.Location;
import my.dsm.model.CustomerRepository;
import my.dsm.model.Customer;
import my.dsm.repo.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringMongoApplication implements CommandLineRunner {

    @Autowired private CustomerRepository customerRepo;
    @Autowired private OrderRepository orderRepo;
    @Autowired private BuildingRepo buildingRepo;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //buildingActions();
        customersActions();
    }

    private void customersActions() {
        customerRepo.deleteAll();

        // save a couple of customers
        Customer firstCustomer = new Customer("Alice", "Smith");
        customerRepo.save(firstCustomer);
        customerRepo.save(new Customer("Bob", "Smith"));
        customerRepo.save(new Customer("Eve", "Roy"));

        orderRepo.deleteAll();
        Order order = new Order();
        order.setDescription("test order");
        order.setCustomer(firstCustomer);
        orderRepo.save(order);

        // fetch all customers
        System.out.println("\n  Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepo.findAll()) {
            System.out.println(customer);
        }

        // fetch an individual customer
        System.out.println("\n  Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepo.findByFirstName("Alice"));

        System.out.println("\n  Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : customerRepo.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }

    private void buildingActions(){
        buildingRepo.deleteAll();

        Location location1 = new Location("test desc1");
        Location location2 = new Location("test desc2");
        Building building1 = new Building(11);
        Building building2 = new Building(22);
        building1.setLocation(location1);
        building2.setLocation(location2);

        buildingRepo.save(building1);
        buildingRepo.save(building2);
    }

}
