package help.lixin.eventuate;

import help.lixin.eventuate.config.DuplicateMessageDetectorConfig;
import io.eventuate.tram.spring.commands.consumer.TramCommandConsumerConfiguration;
import io.eventuate.tram.spring.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.spring.consumer.common.TramConsumerCommonConfiguration;
import io.eventuate.tram.spring.events.common.TramEventsCommonAutoConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.spring.inmemory.TramInMemoryCommonConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TramCommandProducerConfiguration.class,//
        TramConsumerCommonConfiguration.class, //
        TramCommandConsumerConfiguration.class, //
        TramEventsCommonAutoConfiguration.class,//
        TramEventSubscriberConfiguration.class,//
        TramEventsPublisherConfiguration.class,//
        TramInMemoryCommonConfiguration.class, //
        DuplicateMessageDetectorConfig.class //
})
public class EventuateInMemoryAutoConfiguration {
}
