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

public class MySqlUserDao extends DAOs.MySqlDao implements UserDaoInterface {

    public List<Expense> findAllExspense() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Expense> expenseList = new ArrayList<>();

        try {
            conn = this.getConnection();

            String sql = "SELECT * FROM tasks";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int expenseId = rs.getInt("expenseId");
                String title = rs.getString("title");
                Double amount = rs.getDouble("amount");
                Date dateIncurred = rs.getDate("dateIncurred");

                Expense expense = new Expense(expenseId,title,amount,dateIncurred);
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
    public List<Expense> findAllExpense() throws DAOException {
        return List.of();
    }

    @Override
    public List<Income> findAllIncome() throws DAOException {
        return List.of();
    }

    @Override
    public void addNewExpense(String title, String category, String amount, String dateIncurred) throws DAOException {

    }

    @Override
    public void addNewIncome(String title, String amount, String dateEarned) throws DAOException {

    }

    @Override
    public void deleteExpense(int id) throws DAOException {

    }

    @Override
    public void deleteIncome(int id) throws DAOException {

    }
}
