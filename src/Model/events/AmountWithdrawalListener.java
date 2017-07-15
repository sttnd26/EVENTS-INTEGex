package Model.events;

import Model.Customer;
import org.springframework.context.ApplicationListener;

public class AmountWithdrawalListener implements ApplicationListener<WithdrawalEvent> {

    @Override
    public void onApplicationEvent(WithdrawalEvent withdrawalEvent) {
        Customer customer=(Customer)withdrawalEvent.getSource();
        System.out.println("SMS : Dear "+customer.getName()+" your account has been debited with Rs."+withdrawalEvent.debitAmount);
    }
}
