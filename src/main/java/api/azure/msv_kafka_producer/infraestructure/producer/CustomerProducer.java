package api.azure.msv_kafka_producer.infraestructure.producer;

import api.azure.msv_kafka_producer.domain.entities.Customer;
import api.azure.msv_kafka_producer.infraestructure.config.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerProducer {

    private final KafkaTemplate<String, Customer> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void sendMessage(Customer customer) {
        Message<Customer> message = MessageBuilder
                .withPayload(customer)
                .setHeader(KafkaHeaders.TOPIC, kafkaProperties.getTopics().getCustomerNotification())
                .build();
        kafkaTemplate.send(message);
        log.info("Sending message to topic -> : '{}' :: '{}'", kafkaProperties.getTopics().getCustomerNotification(), customer);
    }
}
