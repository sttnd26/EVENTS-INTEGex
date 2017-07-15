package Model.events;

import org.springframework.context.ApplicationEvent;

public class PhoneChangeEvent extends ApplicationEvent {
    public PhoneChangeEvent(Object source) {
        super(source);
    }
}
