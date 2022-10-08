package account;

public class Account {
    private int id;
    private String accountNumber;
    private String accountName;

    public Account(int id, String accountNumber, String accountName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }
}
