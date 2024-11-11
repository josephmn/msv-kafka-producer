package api.azure.msv_kafka_producer.domain.services;

import api.azure.msv_kafka_producer.domain.entities.Customer;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
}
