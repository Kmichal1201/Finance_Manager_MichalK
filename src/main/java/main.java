import account.Account;
import account.AccountRepository;
import category.CategoriesRepository;
import expences.Expence;
import expences.ExpencesRepository;
import income.IncomesReposiotry;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        ExpencesRepository expencesRepository = new ExpencesRepository();
        IncomesReposiotry incomesReposiotry = new IncomesReposiotry();
        CategoriesRepository categoriesRepository = new CategoriesRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type the operation to execution: ");

            System.out.println("1 - Add new account");
            System.out.println("2 - Display all accounts");
            System.out.println("3 - Delete account");
            System.out.println("4 - Add expense");
            System.out.println("5 - Add income");
            System.out.println("6 - Delete expense");
            System.out.println("7 - Delete income");
            System.out.println("8 - Display all expenses and incomes"); // Wyświetl wszystkie wydatki i przychody
            System.out.println("9 - Display all expenses");
            System.out.println("10 - Display all incomes");
            System.out.println("11 - Display balance");
            System.out.println("12 - Display all expenses grouping by category");
            System.out.println("13 - Display all expenses between dates");
            System.out.println("14 - Add new category");
            System.out.println("15 - Delete category");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Dodawanie nowego konta: ");
                    System.out.println("Wpisz ID konta");
                    int id = scanner.nextInt();
                    System.out.println("Wpisz numer konta:");
                    String numerKonta = scanner.next();
                    System.out.println("Wpisz nazwę konta: ");
                    String nazwaKonta = scanner.next();
                    accountRepository.addAccount(new Account(id,numerKonta,nazwaKonta));
                    System.out.println("Konto zostało dodane.");
                    break;
                case 2:
                    System.out.println("Wyświetlanie wszystkich kont:");
                    accountRepository.printAllAccounts();
                    break;
                case  3:
                    System.out.println("Usuwanie konta: ");
                    System.out.println("Wpisz id konta: ");
                    int ID = scanner.nextInt();
                    accountRepository.deleteAccount(ID);
                case 4:
                    System.out.println("Dodawanie wydatku: ");
                    System.out.println("Wpisz kwote: ");
                    double kwota = scanner.nextDouble();
                    System.out.println("Komentarz: ");
                    String komentarz = scanner.nextLine();
                    System.out.println();
            }
        }





    }
}
