package workshop.account.test;

import workshop.account.entity.Account;
import workshop.pserson.controle.PersonManager;
import workshop.pserson.entity.PersonEntity;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account("A1100", "221-22-347", 100000);
        System.out.println(account);
        
        System.out.println(account.getBalnce());
    	account.deposite(10000);
    	account.withdraw(2000);
    	System.out.println("금액 : " + account.getBalnce());
    }
}
