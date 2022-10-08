package income;

import expences.Expence;

import java.sql.*;
import java.time.LocalDate;

public class IncomesReposiotry {

    public void addIncome(Income income) {
        String sql = "INSERT INTO expense(id,aomunt,comment,date,account_id_fk) VALUES(?,?,?,?,?)";
        LocalDate localDate = LocalDate.now();
        try (
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, income.getId());
            preparedStatement.setDouble(2, income.getAmount());
            preparedStatement.setString(3, income.getComment());
            preparedStatement.setDate(4, Date.valueOf(localDate));
            preparedStatement.setInt(6, income.getAccountIdFk());
            int rows = preparedStatement.executeUpdate();
            System.out.println("Updated rows " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteIncome(int id) {
        String sql = "DELETE * FROM income where id=" + id;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
             Statement statement = connection.createStatement()) {

            int rows = statement.executeUpdate(sql);
            System.out.println("Incomes deleted: " + rows);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }
    public void incomesByAccountId(int ID){
        String sql = "SELECT * WHERE account_id_fk ="+ID;
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                double amount = resultSet.getDouble(2);
                String comment = resultSet.getString(3);
                Date expenseDate = resultSet.getDate(4);
                int accountIdFk = resultSet.getInt(5);

                System.out.print("| Income ID: "+id+" | Amount: "+amount+" | Comment: "+ comment+" | Date: "+expenseDate+" | Account ID: "+ accountIdFk+" |");
                System.out.println();
            }

        }catch (Exception e){
            e.getMessage();
        }
    }
    public void showAllIncomes(){
        String sql = "Select * FROM income";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String amount = resultSet.getString(2);
                String comment = resultSet.getString(3);
                Date expenceDate = resultSet.getDate(4);
                int accountIdFk = resultSet.getInt(5);

                System.out.println("Expence id: "+ id);
                System.out.println("Amount: "+amount);
                System.out.println("Comment: "+ comment);
                System.out.println("Date: "+ expenceDate);
                System.out.println("Account Id: "+accountIdFk);
                System.out.println("-------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println("Błąd odczytu");
        }
    }
}
