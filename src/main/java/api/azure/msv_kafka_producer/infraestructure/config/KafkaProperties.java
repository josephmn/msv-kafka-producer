package api.azure.msv_kafka_producer.infraestructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private final Topics topics = new Topics();

    @Getter
    @Setter
    public static class Topics {
        private String customerNotification;
    }
}
