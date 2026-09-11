package my.dsm.model;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

    // Exact match by firstName
    @Query("{ 'firstName': ?0 }")
    List<Customer> findByFirstNameQuery(String firstName);

    // Match by two fields: implicit AND
    @Query("{ 'firstName': ?0, 'lastName': ?1 }")
    Optional<Customer> findByFullNameQuery(
            String firstName,
            String lastName
    );

    // Explicit AND
    @Query("""
            {
              '$and': [
                { 'firstName': ?0 },
                { 'lastName': ?1 }
              ]
            }
            """)
    List<Customer> findByExplicitAnd(
            String firstName,
            String lastName
    );

    // OR condition
    @Query("""
            {
              '$or': [
                { 'firstName': ?0 },
                { 'lastName': ?0 }
              ]
            }
            """)
    List<Customer> findByFirstNameOrLastName(String value);

    // IN condition
    @Query("{ 'lastName': { '$in': ?0 } }")
    List<Customer> findByLastNames(Collection<String> lastNames);

    // NOT IN condition
    @Query("{ 'lastName': { '$nin': ?0 } }")
    List<Customer> findByLastNamesNotIn(Collection<String> lastNames);

    // Case-insensitive regular expression
    @Query("""
            {
              'firstName': {
                '$regex': ?0,
                '$options': 'i'
              }
            }
            """)
    List<Customer> findByFirstNameRegex(String regex);

    // Field is not equal to the parameter
    @Query("{ 'lastName': { '$ne': ?0 } }")
    List<Customer> findByLastNameNotEqual(String lastName);

    // Field exists in the document
    @Query("{ 'lastName': { '$exists': true } }")
    List<Customer> findCustomersHavingLastName();

    // Search by MongoDB _id
    @Query("{ '_id': ?0 }")
    Optional<Customer> findByMongoId(String id);

    // Projection: retrieve only _id and firstName
    @Query(
            value = "{ 'lastName': ?0 }",
            fields = "{ '_id': 1, 'firstName': 1 }"
    )
    List<Customer> findFirstNamesByLastName(String lastName);

    // Static sorting
    @Query(
            value = "{}",
            sort = "{ 'lastName': 1, 'firstName': 1 }"
    )
    List<Customer> findAllSortedByName();

    // Check whether at least one matching document exists
    @Query(
            value = "{ 'lastName': ?0 }",
            exists = true
    )
    boolean existsByLastNameQuery(String lastName);

    // Count matching documents
    @Query(
            value = "{ 'lastName': ?0 }",
            count = true
    )
    long countByLastNameQuery(String lastName);

    // Query combined with dynamic pagination and sorting
    @Query("{ 'lastName': ?0 }")
    Page<Customer> findPageByLastName(
            String lastName,
            Pageable pageable
    );
}