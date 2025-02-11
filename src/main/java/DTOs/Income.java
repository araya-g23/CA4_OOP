package DTOs;

import java.sql.Date;

public class Income {
    //incomeid,title,amount,dateEarned
    private int incomeId;
    private String title;
    private Double amount;
    private Date dateEarned;

    public Income(int incomeId, String title, Double amount, Date dateEarned) {
        this.incomeId = incomeId;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }
    public Income(){

    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(Date dateEarned) {
        this.dateEarned = dateEarned;
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeId=" + incomeId +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateEarned=" + dateEarned +
                '}';
    }
}
