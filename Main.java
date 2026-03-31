import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        while (true) {

            System.out.println("\n===== STUDENT EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Total Expense");
            System.out.println("4. Show Highest Expense");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {

                System.out.print("Enter expense category (Food/Travel/Recharge/Other): ");
                String category = sc.nextLine();

                System.out.print("Enter expense amount: ");
                double amount = sc.nextDouble();

                expenses.add(new Expense(category, amount));
                System.out.println("Expense added successfully!");

            }

            else if (choice == 2) {

                if (expenses.size() == 0) {
                    System.out.println("No expenses added yet.");
                } else {
                    System.out.println("\n--- All Expenses ---");
                    for (int i = 0; i < expenses.size(); i++) {
                        System.out.println((i + 1) + ". " +
                                expenses.get(i).category + " - Rs. " +
                                expenses.get(i).amount);
                    }
                }

            }

            else if (choice == 3) {

                double total = 0;

                for (int i = 0; i < expenses.size(); i++) {
                    total += expenses.get(i).amount;
                }

                System.out.println("Total Expense = Rs. " + total);

            }

            else if (choice == 4) {

                if (expenses.size() == 0) {
                    System.out.println("No expenses added yet.");
                } else {

                    double max = expenses.get(0).amount;
                    String category = expenses.get(0).category;

                    for (int i = 1; i < expenses.size(); i++) {
                        if (expenses.get(i).amount > max) {
                            max = expenses.get(i).amount;
                            category = expenses.get(i).category;
                        }
                    }

                    System.out.println("Highest Expense: Rs. " + max + " (" + category + ")");
                }

            }

            else if (choice == 5) {
                System.out.println("Thank you for using Expense Tracker!");
                break;
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}