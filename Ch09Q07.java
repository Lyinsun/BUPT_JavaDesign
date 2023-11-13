import java.util.Date;

public class Ch09Q07 {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withDraw(2500);
        account.deposit(3000);
        System.out.println("余额"+account.getBalance());
        System.out.println("月利息"+account.getMonthlyInterest());
        System.out.println("开户日期"+account.getDateCreated());
    }
}

class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();

    public Account(){
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public double getMonthlyInterestRate(){     //返回月利率
        return  annualInterestRate/12;
    }

    public double getMonthlyInterest(){     //返回月利息
        return  balance*getMonthlyInterestRate()/100;
    }
    public void withDraw(double amount){        //取出
        if(this.balance >= amount) {
            this.balance = this.balance - amount;
        }
    }

    public void deposit(double amount){         //存入
        this.balance += amount;
    }


}