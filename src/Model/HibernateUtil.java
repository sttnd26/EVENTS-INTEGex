package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    SessionFactory sessionFactory=new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
    Session session=sessionFactory.openSession();

    public HibernateUtil() {
        session.beginTransaction();
    }

    public void saveCustomer(Customer c){
        session.save(c);
    }

    public void saveAtm(ATM atm){
        session.save(atm);
    }

    public void updateAtm(ATM atm){
        session.update(atm);
    }
    public void updateCustomer(Customer customer){
        session.update(customer);
    }
    public void close(){
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
