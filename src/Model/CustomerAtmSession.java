package Model;

import Model.events.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class CustomerAtmSession {

    ATM atm;
    Customer customer;
    HibernateUtil hibernateUtil;
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("resources/Beans.xml");
    public CustomerAtmSession(ATM atm, Customer customer,HibernateUtil hibernateUtil) {
        this.atm = atm;
        this.customer = customer;
        this.hibernateUtil=hibernateUtil;
    }

    public Boolean withdrawAmount(int amount){
        System.out.println("ATM BALANCE : "+atm.getAmountAvailable());
        System.out.println("CUSTOMER BALANCE : "+customer.getBalance());
        System.out.println("Amount to be withdrawn : "+amount);

        if(atm.getAmountAvailable()>amount && customer.getBalance()>amount ){
            atm.setAmountAvailable(atm.getAmountAvailable()-amount);
            customer.setBalance(customer.getBalance()-amount);
            System.out.println("Amount withrawn!");
             hibernateUtil.updateAtm(atm);
             hibernateUtil.updateCustomer(customer);
            //EVENT CODE :-
            AmountDebitedPublisher publisher= (AmountDebitedPublisher) applicationContext.getBean("amountDebitedPublisher");
            publisher.publish(new WithdrawalEvent(customer,amount));
            return true;
        }
        System.out.println("Amount cannot be withdrawn.");
        return false;
    }
    public Boolean changePin(){

        PinChangePublisher pinChangePublisher=(PinChangePublisher)applicationContext.getBean("pinChangePublisher");
        pinChangePublisher.publish(new PinChangeNotifEvent(customer));
        try {

            System.out.println("Enter new pin : ");
            Scanner sc=new Scanner(System.in);
            String newPin=sc.next();
            customer.setPin(newPin);
            hibernateUtil.updateCustomer(customer);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
}
    public Boolean changeMobileNumber(){
        try {

            System.out.println("Enter new phone number : ");
            Scanner sc=new Scanner(System.in);
            String newPhone=sc.next();
            customer.setPhoneNum(newPhone);
            hibernateUtil.updateCustomer(customer);

            PhoneChangePublisher phoneChangePublisher= (PhoneChangePublisher) applicationContext.getBean("phoneChangePublisher");
            phoneChangePublisher.publish(new PhoneChangeEvent(customer));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }

}
