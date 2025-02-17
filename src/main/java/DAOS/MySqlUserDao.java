package DAOS;

import DTOs.Expense;
import DTOs.Income;
import Exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class MySqlUserDao extends MySqlDao implements UserDaoInterface {



    @Override
    public List<Expense> findAllExpense() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expense> expenseList = new ArrayList<>();

        try {
            conn = this.getConnection();

            String sql = "SELECT * FROM expenses";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("expenseId");
                String title = rs.getString("title");
                String category = rs.getString("category");
                Double amount = rs.getDouble("amount");
                Date dateIncurred = rs.getDate("dateIncurred");

                Expense expense = new Expense(expenseId,title,category,amount,dateIncurred);
                expenseList.add(expense);
            }

        } catch (SQLException e) {
            throw new DAOException("findAllTasks() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findAllTasks() " + sqlEx.getMessage());
            }
        }

        return expenseList;
    }

    @Override
    public List<Income> findAllIncome() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Income> incomeList = new ArrayList<>();

        try {
            conn = this.getConnection();

            String sql = "SELECT * FROM incomes";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int incomeId = rs.getInt("incomeId");
                String title = rs.getString("title");
                Double amount = rs.getDouble("amount");
                Date dateEarned = rs.getDate("dateEarned");

                Income income = new Income(incomeId,title,amount,dateEarned);
                incomeList.add(income);
            }

        } catch (SQLException e) {
            throw new DAOException("findAllTasks() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findAllTasks() " + sqlEx.getMessage());
            }
        }

        return incomeList;
    }

    @Override
    public void addNewExpense(String title, String category, String amount, String dateIncurred) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = this.getConnection();
            String sql="INSERT INTO expenses(title,category,amount,dateIncurred) VALUES(?,?,?,?)";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setString(2,category);
            stmt.setString(3,amount);
            stmt.setString(4,dateIncurred);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("addNewExpense() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("addNewExpense() " + sqlEx.getMessage());
            }
        }

    }

    @Override
    public void addNewIncome(String title, String amount, String dateEarned) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = this.getConnection();
            String sql="INSERT INTO incomes(title,amount,dateEarned) VALUES(?,?,?)";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,title);
            stmt.setString(2,amount);
            stmt.setString(3,dateEarned);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new DAOException("addNewIncome() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("addNewIncome() " + sqlEx.getMessage());
            }
        }


    }

    @Override
    public void deleteExpense(int expenseId) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = this.getConnection();
            String sql="DELETE FROM expenses WHERE expenseId = ?";
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,expenseId);
            stmt.executeUpdate();


        }
        catch (SQLException e){
            throw new DAOException("deleteExpense() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("deleteExpense() " + sqlEx.getMessage());
            }
        }

    }

    @Override
    public void deleteIncome(int incomeId) throws DAOException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            conn = this.getConnection();
            String sql="DELETE FROM incomes WHERE incomeId = ?";
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,incomeId);
            stmt.executeUpdate();


        }
        catch (SQLException e){
            throw new DAOException("deleteIncome() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("deleteIncome " + sqlEx.getMessage());
            }
        }

    }

    @Override
    public double getTotalExpense() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double total = 0;

        try{
            conn = this.getConnection();
            String sql="SELECT SUM(amount) FROM expenses";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if(rs.next()){
                total=rs.getDouble(1);
            }
        }
        catch (SQLException e){
            throw new DAOException("getTotalExpenses() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("getTotalExpenses " + sqlEx.getMessage());
            }
        }
        return total;
    }

    @Override
    public double getTotalIncome() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double total = 0;

        try{
            conn = this.getConnection();
            String sql="SELECT SUM(amount) FROM incomes";
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            if(rs.next()){
                total=rs.getDouble(1);
            }
        }
        catch (SQLException e){
            throw new DAOException("getTotalIncome() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("getTotalIncome " + sqlEx.getMessage());
            }
        }
        return total;

    }

    @Override
    public List<Expense> findExpensesByMonth(int month,int year) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expense>expenseList = new ArrayList<>();

        try{
            conn = this.getConnection();
            String sql="SELECT * FROM expenses WHERE month(dateIncurred) = ? AND YEAR(dateIncurred) = ?";
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,month);
            stmt.setInt(2,year);
            rs=stmt.executeQuery();

            while(rs.next()){
                expenseList.add(new Expense(
                        rs.getInt("expenseID"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
                ));
            }
        }
        catch (SQLException e){
            throw new DAOException("findExpensesByMonth() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findExpensesByMonth " + sqlEx.getMessage());
            }
        }
        return expenseList;

    }

    @Override
    public List<Income> findIncomeByMonth(int month,int year) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Income>incomeList = new ArrayList<>();

        try{
            conn = this.getConnection();
            String sql="SELECT * FROM incomes WHERE month(dateEarned) = ? AND YEAR(dateEarned) = ?";
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,month);
            stmt.setInt(2,year);
            rs=stmt.executeQuery();

            while(rs.next()){
                incomeList.add(new Income(
                        rs.getInt("incomeId"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getDate("dateEarned")
                ));
            }
        }
        catch (SQLException e){
            throw new DAOException("findIncomeByMonth() " + e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findIncomeByMonth " + sqlEx.getMessage());
            }
        }
        return incomeList;
    }

    @Override
    public String getIncomeAndExpensesForMonth(int month, int year) throws DAOException {
        double totalIncome = 0;
        double totalExpenses = 0;

        List<Income>incomes=findIncomeByMonth(month,year);
        List<Expense>expenses=findExpensesByMonth(month,year);

        for(Income income:incomes){
            totalIncome += income.getAmount();
        }

        for(Expense expense:expenses){
            totalExpenses += expense.getAmount();
        }
        double balance=totalIncome-totalExpenses;

        return "Income and Expenses for " + month + "/" + year + "\n\n" +
                "Total Income: €" + totalIncome + "\n" +
                "Total Expenses: €" + totalExpenses + "\n" +
                "Remaining Balance: €" + balance;
    }
}
