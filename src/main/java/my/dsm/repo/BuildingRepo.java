package my.dsm.repo;

import my.dsm.nested_doc.Building;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepo extends MongoRepository<Building, String> {
}
