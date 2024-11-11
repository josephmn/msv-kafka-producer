package api.azure.msv_kafka_producer.application.implementation;

import api.azure.kafka.user;
import api.azure.msv_kafka_producer.commons.utils.CustomerConverter;
import api.azure.msv_kafka_producer.domain.entities.Customer;
import api.azure.msv_kafka_producer.domain.repositories.CustomerRepository;
import api.azure.msv_kafka_producer.domain.services.CustomerService;
import api.azure.msv_kafka_producer.infrastructure.config.KafkaProperties;
import api.azure.msv_kafka_producer.infrastructure.producer.CustomerProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerProducer customerProducer;
    private final KafkaProperties kafkaProperties;

    @Override
    public Customer saveCustomer(Customer customer) {
        // Customer saved in database.
        Customer clientSave = customerRepository.save(customer);

        // Convert Customer to Avro user
        user avroUser  = CustomerConverter.convertToAvroUser(clientSave);

        // Send event to topic.
        customerProducer.sendMessage(avroUser);

        return clientSave;
    }
}
