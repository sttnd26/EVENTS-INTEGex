package Model.events;

import Model.Customer;
import org.springframework.context.ApplicationListener;

public class PhoneChangeListener implements ApplicationListener<PhoneChangeEvent> {
    @Override
    public void onApplicationEvent(PhoneChangeEvent event) {
        Customer customer=(Customer)event.getSource();
        System.out.println(customer.getName()+" your phone number has been successfully changed to "+customer.getPhoneNum());
    }
}
