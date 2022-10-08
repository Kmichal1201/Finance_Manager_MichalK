package income;

import java.util.Date;

public class Income {
    private int id, accountIdFk;
    private String comment;
    private double amount;
    private Date date;

    public Income(int id, int accountIdFk, String comment, double amount, Date date) {
        this.id = id;
        this.accountIdFk = accountIdFk;
        this.comment = comment;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getAccountIdFk() {
        return accountIdFk;
    }

    public String getComment() {
        return comment;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}

