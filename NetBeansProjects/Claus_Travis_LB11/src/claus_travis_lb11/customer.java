package claus_travis_lb11;
public class customer {
    private double balance;
    private double[] deposit;
    private double[] withdrawal;
    private int depositIndex;
    private int withdrawalIndex;

    public int getDepositIndex() {
        return depositIndex;
    }
    public int getWithdrawalIndex() {
        return withdrawalIndex;
    }
    public void setDeposit(double deposit) {
        this.deposit[depositIndex] = deposit;
        balance += this.deposit[depositIndex];
        depositIndex++;
    }
    public void setWithdrawal(double withdrawal) {
        this.withdrawal[withdrawalIndex] = withdrawal;
        balance -= this.withdrawal[withdrawalIndex];
        withdrawalIndex++;
    }
    public double getBalance(){
        return balance;
    }
    public customer(){
        this(100.00);
    }
    public customer(double balance) {
        this.balance = balance;
        this.depositIndex = 0;
        this.withdrawalIndex = 0;
        deposit = new double[10];
        withdrawal = new double[10];
    }
}
