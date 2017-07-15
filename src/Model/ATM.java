package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ATM {

    @Column
    private int AmountAvailable;
    @Column
    private int D500;
    @Column
    private int D100;
    @Column
    private int D2000;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany
    List<Customer> customers;


    public ATM() {
    }

    public ATM(int d500, int d100, int d2000) {
        D500 = d500;
        D100 = d100;
        D2000 = d2000;
        AmountAvailable = D500*500 + D100*100 + D2000*2000;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountAvailable() {
        return AmountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        AmountAvailable = amountAvailable;
    }

    public int getD500() {
        return D500;
    }

    public void setD500(int d500) {
        D500 = d500;
    }

    public int getD100() {
        return D100;
    }

    public void setD100(int d100) {
        D100 = d100;
    }

    public int getD2000() {
        return D2000;
    }

    public void setD2000(int d2000) {
        D2000 = d2000;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "AmountAvailable=" + AmountAvailable +
                ", D500=" + D500 +
                ", D100=" + D100 +
                ", D2000=" + D2000 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ATM atm = (ATM) o;

        if (AmountAvailable != atm.AmountAvailable) return false;
        if (D500 != atm.D500) return false;
        if (D100 != atm.D100) return false;
        return D2000 == atm.D2000;
    }

    @Override
    public int hashCode() {
        int result = AmountAvailable;
        result = 31 * result + D500;
        result = 31 * result + D100;
        result = 31 * result + D2000;
        return result;
    }
}
