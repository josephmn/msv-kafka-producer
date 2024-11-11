package api.azure.msv_kafka_producer.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class CustomerTopicConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public NewTopic customerTopic() {
        return TopicBuilder
                .name(kafkaProperties.getTopics().getCustomerNotification())
                .build();
    }
}
