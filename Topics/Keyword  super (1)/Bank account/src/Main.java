class BankAccount {

    protected String number;
    protected Long balance;

    public BankAccount(String number, Long balance) {
        this.number = number;
        this.balance = balance;
    }

}

class CheckingAccount extends BankAccount {
    protected double fee;

    public CheckingAccount(String number, Long balance, double fee) {
        super(number, balance);
        super.number = number;
        super.balance = balance;
        this.fee = fee;
    }
}

class SavingsAccount extends BankAccount {
    protected double interestRate;

    public SavingsAccount(String number, Long balance, double interestRate) {
        super(number, balance);
        super.number = number;
        super.balance = balance;
        this.interestRate = interestRate;
    }
}