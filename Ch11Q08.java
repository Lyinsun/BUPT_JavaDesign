import java.util.ArrayList;
import java.util.Date;

public class Ch11Q08 {
    public static void main(String[] args) {
        NewAccount newAccount = new NewAccount(1122,1000,"George");
        newAccount.setAnnualInterestRate(1.5);
//        newAccount.set
        newAccount.deposit(30);
        newAccount.deposit(40);
        newAccount.deposit(50);
        newAccount.withDraw(5);
        newAccount.withDraw(4);
        newAccount.withDraw(2);
        newAccount.printTransactions();
    }
}

class NewAccount extends Account{
    private String name;
    // NewAccount ctor
    private ArrayList<Transaction> transactions = new ArrayList<>() ;

    public NewAccount(int id, double balance,String Name) {
        super(id, balance);
        name = Name;
    }

    @Override
    public void withDraw(double amount) {
        super.withDraw(amount);
        transactions.add(new Transaction('W',amount,getBalance(),"取款成功"));
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions.add(new Transaction('D',amount,getBalance(),"存款成功"));
    }
    public void printTransactions() {
        for(Transaction transaction: transactions){
            System.out.println(transaction.toString());
        }
    }
}

class Transaction {
    private Date date = new Date();
    private char type; // 'D' 'W'
    private double amount;
    private double balance;
    private String description; // KFC


    Transaction(char Type, double Amount, double Balance, String Description) {
        type = Type;
        amount = Amount;
        balance = Balance;
        description = Description;
        date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}';
    }
}