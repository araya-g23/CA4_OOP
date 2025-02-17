package org.example;

import DAOS.MySqlUserDao;
import DAOS.UserDaoInterface;
import DTOs.Expense;
import DTOs.Income;
import Exceptions.DAOException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SystemMenu dispalyMenu=new SystemMenu();
        Scanner sc=new Scanner(System.in);
        int choice;

        try {

            while (true) {
                dispalyMenu.menu();
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        findAllExpense();
                        break;
                    case 2:
                        getTotalExpense();
                        break;
                    case 3:
                        addNewExpense();
                        break;
                    case 4:
                        deleteExpense();
                        break;
                    case 5:
                        findAllIncome();
                        break;
                    case 6:
                        getTotalIncome();
                        break;
                    case 7:
                        addNewIncome();
                        break;
                    case 8:
                        deleteIncome();
                        break;
                    case 9:

                        findExpensesByMonth();
                        findIncomeByMonth();
                        break;
                        case 10:
                            getIncomeAndExpensesForMonth();
                            break;
                            case 11:
                                System.out.println("exit");
                                return;
                    default:
                        System.out.printf("Invalid choice! Try again!\n");


                }
            }
        }
        catch (DAOException e){
            e.printStackTrace();
        }
    }




    public static void getTotalIncome() {
        UserDaoInterface userDao=new MySqlUserDao();
        System.out.println("Displaying total income");
        double totalIncome=userDao.getTotalIncome();
        System.out.println("Total income: "+totalIncome);
    }
    public static void findAllExpense() {
      UserDaoInterface usdi=new MySqlUserDao();
        System.out.println("Displaying all expenses: \n");
        List<Expense> allExpenseList=usdi.findAllExpense();
        if(allExpenseList.isEmpty()){
            System.out.println("No expenses found!");
        }
        for(Expense expense:allExpenseList){
            System.out.println("Expense: "+expense);
        }
    }
    public static void getTotalExpense() {
        UserDaoInterface usdi=new MySqlUserDao();
        System.out.println("Displaying total expenses: \n");
        double total=usdi.getTotalExpense();
        System.out.println("Total expense: "+total);

    }
    public static void addNewExpense() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        String title,category,amount,dateIncurred;

        System.out.println("Enter title: ");
        title=sc.nextLine();
        System.out.println("Enter category: ");
        category=sc.nextLine();
        System.out.println("Enter amount: ");
        amount=sc.nextLine();
        System.out.println("Enter date incurred: ");
        dateIncurred=sc.nextLine();

        usdi.addNewExpense(title,category,amount,dateIncurred);
    }
    public static void deleteExpense() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int expenseId;
        System.out.println("Enter expenseId you want to delete: ");
        expenseId=sc.nextInt();
        usdi.deleteExpense(expenseId);
    }
    public static void findAllIncome() {
        UserDaoInterface usdi=new MySqlUserDao();
        System.out.println("Displaying all income: \n");
        List<Income> allIncomeList=usdi.findAllIncome();
        if(allIncomeList.isEmpty()){
            System.out.println("No Income found!");
        }
        for(Income income:allIncomeList){
            System.out.println("Income: "+income);
        }
    }
    public static void addNewIncome() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        String title,amount,dateEarned;
        System.out.println("Enter title: ");
        title=sc.nextLine();
        System.out.println("please enter amount: ");
        amount=sc.nextLine();
        System.out.println("Enter date earned: ");
        dateEarned=sc.nextLine();

        usdi.addNewIncome(title,amount,dateEarned);
    }
    public static void findExpensesByMonth() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int month;
        int year;

        System.out.println("*******Expenses*********  \n");
        System.out.println("Enter month: ");
        month=sc.nextInt();
        System.out.println("Enter year: ");
        year=sc.nextInt();
        List<Expense> allExpenseList=usdi.findExpensesByMonth(month,year);
        if(allExpenseList.isEmpty()){
            System.out.println("No expenses found!");
        }
        for(Expense expense:allExpenseList){
            System.out.println("Expense: "+expense);
        }
        System.out.println("\n");
        System.out.println(" *********Incomes******** \n");

    }
    public static void findIncomeByMonth() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int month;
        int year;
        System.out.println("Enter month: ");
        month=sc.nextInt();
        System.out.println("Enter year: ");
        year=sc.nextInt();
        List<Income>allIncomeList=usdi.findIncomeByMonth(month,year);
        if(allIncomeList.isEmpty()){
            System.out.println("No Income found!");
        }
        for(Income income:allIncomeList){
            System.out.println("Income: "+income);
        }
    }
    public static void deleteIncome() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int incomeId;
        System.out.println("Enter income id you want to delete: ");
        incomeId=sc.nextInt();
        usdi.deleteIncome(incomeId);
    }
    public static void getIncomeAndExpensesForMonth() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int month;
        int year;
        System.out.println("Enter month: ");
        month=sc.nextInt();
        System.out.println("Enter year: ");
        year=sc.nextInt();

        String summary=usdi.getIncomeAndExpensesForMonth(month,year);
        System.out.println("\n"+summary);


    }





}