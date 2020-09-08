package OOPS_Demo;

import java.util.*;

//Abstraction
interface Amount{
    public void getAmount();
}
abstract class debit {
   public static double balance = 6000;
    abstract public void debitAmount(double amount);
}
abstract class credit {
    public static double balance = 6000;
    abstract public void creditAmount(double amount);
}

    class accountHolder {
        private String ownerName = "Luqmaan";
        private String ownerPassword = "password";

        private String name;
        private String password;

        //Encapsulation

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        //Validation
        public boolean validate() {
            if (name.equals(this.ownerName) && password.equals(this.ownerPassword)) {
                System.out.println("Authentication is successful.");
                return true;

            } else {
                System.out.println("Authentication failed");
                return false;
            }
        }
    }

    class amountDebit extends debit implements Amount {
        //Overriding methods
        public void debitAmount(double amount) {
            balance -= amount;
            System.out.println("Debit Successful.");
        }

        public void getAmount() {
            System.out.println("Available Balance after debit is :" + balance);
        }
    }

    class amountCredit extends credit implements Amount {
        //Overriding methods
        public void creditAmount(double amount) {
            balance += amount;
            System.out.println("Credit Successful.");
        }

        public void getAmount() {
            System.out.println("Available Balance after credit is :" + balance);
        }

    }
    class Purchase{
    double number;
    String item;
    int discount;

    //Overloading methods
    public void buyItem(double number,String item){
        System.out.println("You can buy "+item+" from the available balance "+number);
    }

    public void buyItem(double number, String item,int discount){
        System.out.println("You can buy "+item+" from the available balance "+number+" with discount of "+discount+"%");
    }
    }

    public class BankDetails {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            accountHolder o = new accountHolder();
            amountCredit c = new amountCredit();
            amountDebit d = new amountDebit();
            Purchase p =new Purchase();
            System.out.println("Enter UserName: ");
            String name = sc.nextLine();
            System.out.println("Enter Password: ");
            String pass = sc.nextLine();
            o.setName(name);
            o.setPassword(pass);
            boolean result = o.validate();
            if (result == true) {
                System.out.println("Current balance is: "+debit.balance);
                System.out.println("Enter amount to be deposited or credited");
                int val = sc.nextInt();
                System.out.println("Enter 0 for debit and 1 for credit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        d.debitAmount(val);
                        d.getAmount();
                        break;
                    case 1:
                        c.creditAmount(val);
                        c.getAmount();
                        break;
                    default:
                        System.out.println("Enter either 0 or 1");
                }
                if(choice==0){
                    p.buyItem(d.balance,"Books");
                    p.buyItem(d.balance,"Toys",10);
                }
                else if(choice == 1){
                    p.buyItem(c.balance,"Books");
                    p.buyItem(c.balance,"Toys",10);
                }

            } else {
                result = false;
            }
        }
    }

