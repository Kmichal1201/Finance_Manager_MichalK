package expences;

import java.sql.*;
import java.time.LocalDate;

public class ExpencesRepository {

    public void addExpence(Expence expence) {
        String sql = "INSERT INTO expense(amount,comment,expense_date,category_id_fk,account_id_fk) VALUES(?,?,?,?,?)";
        LocalDate localDate = LocalDate.now();
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, expence.getAmount());
            preparedStatement.setString(2, expence.getComment());
            preparedStatement.setDate(3, Date.valueOf(localDate));
            preparedStatement.setInt(4, expence.getCategoryIdFk());
            preparedStatement.setInt(5, expence.getAccountIdfk());
            int rows = preparedStatement.executeUpdate();
            System.out.println("Updated rows " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteExpence(int id) {
        String sql = "DELETE * FROM expence where id=" + id;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
             Statement statement = connection.createStatement()) {

            int rows = statement.executeUpdate(sql);
            System.out.println("Expences deleted: " + rows);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    public void showAllExpences() {
        String sql = "Select * FROM expence";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String amount = resultSet.getString(2);
                String comment = resultSet.getString(3);
                Date expenceDate = resultSet.getDate(4);
                int categoryIdFk = resultSet.getInt(5);
                int accountIdFk = resultSet.getInt(6);

                System.out.println("Expence id: " + id);
                System.out.println("Amount: " + amount);
                System.out.println("Comment: " + comment);
                System.out.println("Date: " + expenceDate);
                System.out.println("Category Id: " + categoryIdFk);
                System.out.println("Account Id: " + accountIdFk);
                System.out.println("\n");
            }
        } catch (Exception e) {
            System.out.println("Błąd odczytu");
        }
    }

    public void expencesByAccountId(int ID) {
        String sql = "SELECT * WHERE account_id_fk =" + ID;
        try (
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double amount = resultSet.getDouble(2);
                String comment = resultSet.getString(3);
                Date expenseDate = resultSet.getDate(4);
                int categoryIdFk = resultSet.getInt(5);
                int accountIdFk = resultSet.getInt(6);

                System.out.print("| Expense ID: " + id + " | Amount: " + amount + " | Comment: " + comment + " | Date: " + expenseDate + " | Category: " + categoryIdFk + " | Account ID: " + accountIdFk + " |");
                System.out.println();
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
