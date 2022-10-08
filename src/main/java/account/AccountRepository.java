package account;

import java.sql.*;

public class AccountRepository {

    public void addAccount(Account account) {
        String sql = "INSERT INTO `account`(id,account_number,account_name) VAlUES(?,?,?)";

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setString(2, account.getAccountNumber());
            preparedStatement.setString(3, account.getAccountName());
            int rows = preparedStatement.executeUpdate();
            System.out.println("Updated rows " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
        String sql = "DELETE * FROM account where id=" + id;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
             Statement statement = connection.createStatement()) {

            int rows = statement.executeUpdate(sql);
            System.out.println("Rows deleted: " + rows);
        } catch (SQLException e) {
            System.err.println("Exception");
            e.printStackTrace();
        }
    }

    public void printAllAccounts() {
        String sql = "Select * FROM account";

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String accountNumber = resultSet.getString(2);
                String accountName = resultSet.getString(3);

                System.out.println("Account id: " + id);
                System.out.println("Account number: " + accountNumber);
                System.out.println("Account name: " + accountName);
            }
        } catch (Exception e) {
            System.out.println("Błąd odczytu");
        }
    }
    public void balance(){
        String sql = "SELECT COUNT(*) i.amount, e.amount FROM income AS i INNER JOIN account AS a ON i.account_id_fk = a.id" +
                " INNER JOIN expence AS e ON a.id = e.account_id_fk;";
        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/finance_manager", "root", "BengalSQL");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                double incomesAmount = resultSet.getDouble(1);
                double expencesAmount = resultSet.getDouble(2);

                System.out.println("Saldo wynosi: "+ (incomesAmount - expencesAmount));
            }
        } catch (Exception e) {
            System.out.println("Błąd odczytu");
        }

    }


}
