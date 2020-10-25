package org.frm.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class VerySimpleProducer {
    // The topic we are going to write records to

    public static void main(String[] args) {
        // Set producer configuration properties
        final Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constant.KAFKA_ADDRESS);
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // Create a new producer
        try (final KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps)) {
            // Write 10 records into the topic
            for (int i = 0; i < 10; i++) {
                final String key = "key-" + i;
                final String value = "value-" + i;
                producer.send(new ProducerRecord<>(Constant.SIMPLE_TOPIC, key, value), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        System.out.println("msg received");
                        System.out.println(metadata.offset());
                    }
                });
                System.out.println("====i=" + i);
            }
        }
    }
}
