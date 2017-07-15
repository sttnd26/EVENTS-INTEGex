package Model.events;

import Model.Customer;
import org.springframework.context.ApplicationListener;

public class PinChangeListener implements ApplicationListener<PinChangeNotifEvent> {

    @Override
    public void onApplicationEvent(PinChangeNotifEvent event) {
        Customer customer=(Customer)event.getSource();
        System.out.println("To "+customer.getName()+": ALERT! Your pin is getting changed !");
    }

}
