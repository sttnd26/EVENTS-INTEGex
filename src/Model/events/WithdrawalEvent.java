package Model.events;

import Model.Customer;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;

@Async
public class WithdrawalEvent extends ApplicationEvent {

    int debitAmount;

    public WithdrawalEvent(Object source, int debitAmount) {
        super(source);
        this.debitAmount = debitAmount;
    }

}
