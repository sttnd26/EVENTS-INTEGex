package Model;

import java.util.Arrays;

public class ATMprocesses {
    ATM atm;

    public ATMprocesses(ATM atm) {
        this.atm = atm;
    }

    Boolean login(char []pswd,String custName){
        //check for the pin and customer name
        Arrays.fill(pswd,'*');
        return true;
    }
    Boolean addD500(int numOfD500){
        atm.setD500(atm.getD500()+numOfD500);
        atm.setAmountAvailable(atm.getAmountAvailable()+500*(numOfD500));
        return true;
    }
    Boolean addD100(int numOfD100){
        atm.setD100(atm.getD100()+numOfD100);
        atm.setAmountAvailable(atm.getAmountAvailable()+100*(numOfD100));
        return true;
    }
    Boolean addD2000(int numOfD2000){
        atm.setD2000(atm.getD2000()+numOfD2000);
        atm.setAmountAvailable(atm.getAmountAvailable()+2000*(numOfD2000));
        return true;
    }

}
