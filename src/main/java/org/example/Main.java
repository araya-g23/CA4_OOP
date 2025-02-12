package org.example;

import DAOS.MySqlUserDao;
import DAOS.UserDaoInterface;
import DTOs.Expense;
import Exceptions.DAOException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SystemMenu dispalyMenu=new SystemMenu();
        Scanner sc=new Scanner(System.in);
        int choice;

        try{
            dispalyMenu.menu();
            choice=sc.nextInt();

            switch(choice) {
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
                                                    default:
                                                        System.out.printf("Invalid choice! Try again!\n");


            }
        }
        catch (DAOException e){
            e.printStackTrace();
        }
    }

    public static void getTotalIncome() {
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
    public static void findAllIncome() {}
    public static void addNewIncome() {}
    public static void findExpensesByMonth() {
        UserDaoInterface usdi=new MySqlUserDao();
        Scanner sc=new Scanner(System.in);
        int month;
        int year;

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

    }
    public static void findIncomeByMonth() {}
    public static void deleteIncome() {}





}