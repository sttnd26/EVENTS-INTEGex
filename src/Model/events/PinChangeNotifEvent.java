package Model.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;


public class PinChangeNotifEvent extends ApplicationEvent {

    public PinChangeNotifEvent(Object source) {
        super(source);
    }
}
