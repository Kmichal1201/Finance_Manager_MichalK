package expences;

import java.util.Date;

public class Expence {
    private int id, categoryIdFk,accountIdfk;
    private String comment;
    private double amount;


    public Expence(int id, int categoryIdFk, int accountIdfk, String comment, double amount) {
        this.id = id;
        this.categoryIdFk = categoryIdFk;
        this.accountIdfk = accountIdfk;
        this.comment = comment;
        this.amount = amount;

    }

    public int getId() {
        return id;
    }

    public int getCategoryIdFk() {
        return categoryIdFk;
    }

    public int getAccountIdfk() {
        return accountIdfk;
    }

    public String getComment() {
        return comment;
    }

    public double getAmount() {
        return amount;
    }
 
}
