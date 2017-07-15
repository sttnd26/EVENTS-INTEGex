package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String pin;
    @Column
    private String phoneNum;
    @Column
    private int Balance;

    @ManyToMany(mappedBy = "customers")
    List<ATM> atms;
    public Customer() {
    }

    public Customer(String name, String pin, String phoneNum) {
        this.name = name;
        this.pin = pin;
        this.phoneNum = phoneNum;
    }

    public List<ATM> getAtms() {
        return atms;
    }

    public void setAtms(List<ATM> atms) {
        this.atms = atms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
