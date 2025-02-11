package DAOS;

import DTOs.Expense;
import DTOs.Income;
import Exceptions.DAOException;

import java.util.List;

public interface UserDaoInterface {
public List<Expense> findAllExpense() throws DAOException;
public List<Income> findAllIncome() throws DAOException;
public void addNewExpense(String title, String category, String amount, String dateIncurred ) throws DAOException;
public void addNewIncome(String title, String amount, String dateEarned ) throws DAOException;
public void deleteExpense(int id) throws DAOException;
public void deleteIncome(int id) throws DAOException;

}
