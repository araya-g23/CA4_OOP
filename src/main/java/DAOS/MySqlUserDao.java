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

//    public List<Expense> findAllExspense() throws DAOException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Expense> expenseList = new ArrayList<>();
//
//        try {
//            conn = this.getConnection();
//
//            String sql = "SELECT * FROM tasks";
//            stmt = conn.prepareStatement(sql);
//
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int expenseId = rs.getInt("expenseId");
//                String title = rs.getString("title");
//                Double amount = rs.getDouble("amount");
//                Date dateIncurred = rs.getDate("dateIncurred");
//
//                Expense expense = new Expense(expenseId,title,amount,dateIncurred);
//                expenseList.add(expense);
//            }
//
//        } catch (SQLException e) {
//            throw new DAOException("findAllTasks() " + e.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//
//                if (stmt != null) {
//                    stmt.close();
//                }
//
//                if (conn != null) {
//                    freeConnection(conn);
//                }
//            } catch (SQLException sqlEx) {
//                throw new DAOException("findAllTasks() " + sqlEx.getMessage());
//            }
//        }
//
//        return expenseList;
//    }

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

            String sql = "SELECT * FROM OOP_CA4";
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
            String sql="INSERT INTO OOP_CA4(title,amount,dateEarned) VALUES(?,?,?)";
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
            String sql="DELETE FROM OOP_CA4 WHERE incomeId = ?";
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
}
