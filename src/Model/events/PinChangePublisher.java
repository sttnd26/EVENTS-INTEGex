package Model.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PinChangePublisher implements ApplicationEventPublisherAware {
    ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
    public void publish(PinChangeNotifEvent event){
        publisher.publishEvent(event);
    }
}
