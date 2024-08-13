//package org.kakarla.OrchestratingPrecisionRealtime.KafkaConsumer;
//import org.apache.kafka.clients.consumer.Consumer;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//
//@Component
//public class BaseConsumer {
//
//    // Kafka bootstrap servers
//    String bootstrapServers = "localhost:9092";
//
//    // Kafka consumer group id
//    String groupId = "sample-consumer-group";
//
//    // Kafka topic to subscribe to
//    String topic = "sample-topic";
//
//
//
//
//    // Poll for new messages
//        while (true) {
//        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//
//        // Process the received records
//        records.forEach(record -> {
//            System.out.println("Received message: " +
//                    "Key: " + record.key() +
//                    ", Value: " + record.value() +
//                    ", Partition: " + record.partition() +
//                    ", Offset: " + record.offset());
//        });
//    }
//
//    public String getTopic() {
//        return topic;
//    }
//}
