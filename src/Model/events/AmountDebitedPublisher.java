package Model.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class AmountDebitedPublisher implements ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher=applicationEventPublisher;
    }

    public void publish(WithdrawalEvent event){
        publisher.publishEvent(event);
    }
}
