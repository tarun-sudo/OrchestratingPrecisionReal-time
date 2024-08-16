package org.kakarla.OrchestratingPrecisionRealtime.KafkaProducer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class BaseProducer {

    @Value("bootstrap.servers")
    private String bootstrapServers;

    @Value("topic.name")
    private String producerTopic;


    public void produce() {
        // Set up the producer configuration
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers); // Kafka broker address
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a producer

        // Send messages to the topic
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 10; i++) {
                String key = "key-" + i;
                String value = "value-" + i;
                producer.send(new ProducerRecord<>(producerTopic, key, value));
                System.out.println("Sent message: (" + key + ", " + value + ")");
            }
        } catch (Exception e) {
           throw new RuntimeException("** Exception while sending messages to topic: " + producerTopic);
        }
        // Close the producer to flush any remaining records and free resources
    }
}
