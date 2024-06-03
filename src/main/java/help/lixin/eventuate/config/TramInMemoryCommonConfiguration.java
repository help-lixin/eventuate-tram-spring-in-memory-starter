package help.lixin.eventuate.config;


import io.eventuate.common.inmemorydatabase.EventuateDatabaseScriptSupplier;
import io.eventuate.common.spring.id.IdGeneratorConfiguration;
import io.eventuate.tram.common.spring.inmemory.EventuateSpringTransactionSynchronizationManager;
import io.eventuate.tram.inmemory.InMemoryMessageConsumer;
import io.eventuate.tram.inmemory.InMemoryMessageProducer;
import io.eventuate.tram.spring.consumer.common.TramConsumerCommonConfiguration;
import io.eventuate.tram.spring.messaging.producer.common.TramMessagingCommonProducerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Collections;

/**
 * 自定义:TramInMemoryCommonConfiguration 去除H2数据源的创建<br/>
 */
@Configuration
@Import({TramConsumerCommonConfiguration.class, //
        TramMessagingCommonProducerConfiguration.class, //
//        EventuateCommonInMemoryDatabaseConfiguration.class, //
        IdGeneratorConfiguration.class})
public class TramInMemoryCommonConfiguration {


    @Bean
    public InMemoryMessageConsumer inMemoryMessageConsumer() {
        return new InMemoryMessageConsumer();
    }

    @Bean
    public InMemoryMessageProducer inMemoryMessageProducer(InMemoryMessageConsumer messageConsumer) {
        return new InMemoryMessageProducer(messageConsumer, new EventuateSpringTransactionSynchronizationManager());
    }

    @Bean
    public EventuateDatabaseScriptSupplier eventuateCommonInMemoryScriptSupplierForTram() {
        return () -> Collections.singletonList("eventuate-tram-embedded-schema.sql");
    }
}
