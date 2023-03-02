import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;

public class ATM_Interface {
    public static void main(String[] args) {

        String userName;
        int pin;
        // Considering following are Existing Customer of Bank with initial account
        // balance 100000
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("aryan", 1011);
        ht.put("sai", 5616);
        ht.put("Varun", 6898);
        ht.put("Siddesh", 2565);
        ht.put("Samarth", 9898);
        ht.put("Khushi", 8080);
        Scanner sc = new Scanner(System.in);

        System.out.println("-----*****WELCOME TO HDFC ATM*****-----");
        System.out.print("Enter Your user id: \n");
        userName = sc.nextLine();
        System.out.print("Enter Your Pin: \n");
        pin = sc.nextInt();

        // checking wheather the user is an existing customer of Bank or not
        if (ht.get(userName) != null && ht.get(userName) == pin) {
            System.out.println("*****LOGIN SUCESSFULL*****");
            Boolean Login = false;
            BankAccount BA = new BankAccount();
            while (!Login) {
                System.out.println("\n1. Transaction History  \n2. withdraw  \n3. Deposit \n4. Transfer \n5. Quit");
                System.out.print("\nEnter Your Choice: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        BA.TransactionHistory();
                        break;

                    case 2:
                        BA.Withdraw();
                        break;

                    case 3:
                        BA.Deposit();
                        break;

                    case 4:
                        BA.Transfer();
                        break;

                    case 5:
                        BA.Quit();
                        break;

                    default:
                        System.out.println("INVALID CHOICE");
                        break;

                }
            }

        } else {
            System.out.println("Invalid User");
        }
    }
}

class BankAccount {
    float balance = 100000f;
    String tranHistory = "";
    int transactions = 0;
    Scanner sc = new Scanner(System.in);

    public void TransactionHistory() {
        System.out.println("\n" + tranHistory);
    }

    public void Withdraw() {
        int amount;
        System.out.print("Enter the Amount: \n");
        amount = sc.nextInt();
        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            transactions++;
            balance -= amount;
            System.out.println("Withdraw Successfully");
            String str = transactions + ") Rs " + amount + " Withdrawed \n";
            tranHistory = tranHistory.concat(str);
        }
    }

    public void Deposit() {
        transactions++;
        int amount;
        System.out.print("Enter the Amount to be Deposited: \n");
        amount = sc.nextInt();
        balance += amount;
        System.out.println("Deposited Successfully");
        String str = transactions + ") Rs " + amount + " Deposited \n";
        tranHistory = tranHistory.concat(str);

    }

    public void Transfer() {

        int amount;
        String receipent;
        System.out.println("Enter the Receipent Name: ");
        receipent = sc.nextLine();
        System.out.println("Enter the Amount to Transfer: ");
        amount = sc.nextInt();
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            transactions++;
            balance -= amount;
            System.out.println("Money Transferred Succeddfully.");
            String str = transactions + ") Rs " + amount + " Transferred to " + receipent + "\n";
            tranHistory = tranHistory.concat(str);
        }
    }

    public void Quit() {
        System.exit(0);
    }
}
