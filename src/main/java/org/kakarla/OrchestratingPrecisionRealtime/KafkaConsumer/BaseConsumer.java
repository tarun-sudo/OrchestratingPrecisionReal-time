package org.kakarla.OrchestratingPrecisionRealtime.KafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BaseConsumer {

    @Value("consumer.topic.name1")
    private String Ticket_topic;

    @Value("consumer.topic.name2")
    private String Booking_Topic;

    @Value("group.id")
    private String groupId;

    @KafkaListener(topics = "Ticket_topic", groupId = "Tickets")
    public void TicketsConsumer(ConsumerRecords<String, String> records) {
        // Poll for new messages
            // Process the received records
            records.forEach(record -> {
                System.out.println("Received message: " +
                        "Key: " + record.key() +
                        ", Value: " + record.value() +
                        ", Partition: " + record.partition() +
                        ", Offset: " + record.offset());
            });

    }

    @KafkaListener(topics = "Booking_Topic", groupId = "Bookings")
    public void BookingsConsumer(ConsumerRecords<String, String> records) {
        // Poll for new messages
        records.forEach(record -> {
            System.out.println("Received message: " +
                    "Key: " + record.key() +
                    ", Value: " + record.value() +
                    ", Partition: " + record.partition() +
                    ", Offset: " + record.offset());
        });

    }
}
