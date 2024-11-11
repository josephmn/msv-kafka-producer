package api.azure.msv_kafka_producer.domain.repositories;

import api.azure.msv_kafka_producer.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
