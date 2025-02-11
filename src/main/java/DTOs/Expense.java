package DTOs;

import java.sql.Date;

public class Expense {
    private int expenseId;
    private String title;
    private double amount;
    private Date dateIncurred;

    public Expense(int expenseId, String title, double amount, Date dateIncurred) {
        this.expenseId = expenseId;
        this.title = title;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }
    public  Expense(){

    }
    public int getExpenseId() {
        return expenseId;
    }
    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getDateIncurred() {
        return dateIncurred;
    }
    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}
