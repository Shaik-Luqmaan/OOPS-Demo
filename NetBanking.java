package OOPS_Demo;
import java.util.*;

interface IAmountDetails {
     void getAmountDetails();
}
abstract class Debit {
   public static double balance = 6000;
   abstract public void debitAmountFromAccount(double amount);
}
abstract class Credit {
    public static double balance = 6000;
    abstract public void creditAmountToAccount(double amount);
}

    class AccountHolderDetails {
        private String ownerName = "Luqmaan";
        private String ownerPassword = "password";

        private String userName;
        private String userPassword;

        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getUserPassword() {
            return userPassword;
        }
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
        public boolean validateTheUser() {
            if (userName.equals(this.ownerName) && userPassword.equals(this.ownerPassword)) {
                System.out.println(
                        "Authentication is successful."
                );
                return true;

            } else {
                System.out.println(
                        "Authentication failed"
                );
                return false;
            }
        }
    }

    class AmountDebit extends Debit implements IAmountDetails {
        public void debitAmountFromAccount(double amount) {
            balance -= amount;
            System.out.println(
                    "Debit Successful."
            );
        }

        public void getAmountDetails() {
            System.out.println(
                    "Available Balance after debit is Rs:" + balance
            );
        }
    }
    class AmountCredit extends Credit implements IAmountDetails {
        public void creditAmountToAccount(double amount) {
            balance += amount;
            System.out.println(
                    "Credit Successful."
            );
        }
        public void getAmountDetails() {
            System.out.println(
                    "Available Balance after credit is Rs:" + balance
            );
        }

    }
    class PurchaseItems {
    double number;
    String item;
    int discount;

    public void buyItem(double number,String item){
        System.out.println(
                "You can buy "+item+" from the available balance: Rs "+number
        );
    }

    public void buyItem(double number, String item,int discount){
        System.out.println(
                "You can buy "+item+" from the available balance: Rs "
                +number+" with discount of "+discount+"%"
        );
             }
    }

    public class NetBanking{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter UserName: ");
            String name = sc.nextLine();
            System.out.println("Enter Password: ");
            String pass = sc.nextLine();

            AccountHolderDetails accountHolderDetailsObject = new AccountHolderDetails();
            AmountCredit creditObject = new AmountCredit();
            AmountDebit debitObject = new AmountDebit();
            PurchaseItems purchaseItemsObject =new PurchaseItems();

            accountHolderDetailsObject.setUserName(name);
            accountHolderDetailsObject.setUserPassword(pass);
            boolean isUser =  accountHolderDetailsObject.validateTheUser();

            if(isUser == true){
                System.out.println("Enter the amount to be debited or credited");
                double value= sc.nextDouble();
                System.out.println("Enter 0 for debit and 1 for credit");
                int choiceValue = sc.nextInt();
                if(choiceValue == 0){
                    debitObject.debitAmountFromAccount(value);
                    debitObject.getAmountDetails();
                    purchaseItemsObject.buyItem(debitObject.balance,"Books");
                    purchaseItemsObject.buyItem(debitObject.balance,"Toys",10);
                }
               else if(choiceValue == 1){
                    creditObject.creditAmountToAccount(value);
                    creditObject.getAmountDetails();
                    purchaseItemsObject.buyItem(creditObject.balance,"Books");
                    purchaseItemsObject.buyItem(creditObject.balance,"Toys",10);
                }

            }
        }
    }

