package com.kflyddn.demo;

@SpringBootApplication
public class HadesTmsApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(HadesTmsApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        FlinkKafkaConsumer010 kafkaConsumer = new FlinkKafkaConsumer010<>("topic-name"), new SimpleStringSchema(), getProperties());
        DataStream<String> dataStream = env.addSource(kafkaConsumer);
// 此处省略处理逻辑
        dataStream.addSink(new MySink());


    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", bootstrap_servers);
        properties.setProperty("zookeeper.connect", zookeeper_connect);
        properties.setProperty("group.id", group_id);
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }
}
