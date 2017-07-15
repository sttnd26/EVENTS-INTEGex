import Model.ATM;
import Model.Customer;
import Model.CustomerAtmSession;
import Model.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        ATM atm1=new ATM(200,200,200);
        ATM atm2=new ATM(100,210,100);
        Customer customer1=new Customer("Snigdha","Rudola","9834835238");
        customer1.setBalance(200000);

        Customer customer2=new Customer("Argh","Chakraborty","73436946583");
        customer2.setBalance(300000);

        List<ATM> atms=new ArrayList<>();
        atms.add(atm1);
        atms.add(atm2);
        List<Customer> customers=new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        atm1.setCustomers(customers);
        atm2.setCustomers(customers);
        customer1.setAtms(atms);
        customer2.setAtms(atms);

        HibernateUtil hibernateUtil=new HibernateUtil();
        hibernateUtil.saveAtm(atm1);
        hibernateUtil.saveAtm(atm2);
        hibernateUtil.saveCustomer(customer1);
        hibernateUtil.saveCustomer(customer2);

        CustomerAtmSession customerAtmSession=new CustomerAtmSession(atm1,customer1,hibernateUtil);
        if(customerAtmSession.withdrawAmount(200)){
            System.out.println("New atm balance : "+atm1.getAmountAvailable());
            System.out.println("New customer balance : "+customer1.getBalance());
        }

        customerAtmSession.changePin();
        customerAtmSession.changeMobileNumber();
        hibernateUtil.close();
    }
}
