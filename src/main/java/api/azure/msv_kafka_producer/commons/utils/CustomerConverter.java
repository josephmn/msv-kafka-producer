package api.azure.msv_kafka_producer.commons.utils;

import api.azure.kafka.user;
import api.azure.msv_kafka_producer.domain.entities.Customer;

public class CustomerConverter {

    public static user convertToAvroUser(Customer customer) {
        return user.newBuilder()
                .setId(customer.getId().toString()) // Convert UUID to String
                .setName(customer.getName())
                .setLastName(customer.getLastName())
                .setEmail(customer.getEmail())
                .build();
    }

}
