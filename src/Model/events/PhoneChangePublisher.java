package Model.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class PhoneChangePublisher implements ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }
    public void publish(PhoneChangeEvent event){
        publisher.publishEvent(event);
    }
}

