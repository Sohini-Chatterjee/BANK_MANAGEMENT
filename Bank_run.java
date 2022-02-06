
/*Name-Sohini Chatterjee Roll-80 Enrollment no:12019002002115 Section-B SWE MINI PROJECT*/
import java.util.*;
class Bank{
int acno;
String name;
String address;
double balance;

void add_record(){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the name of the customer");
name=sc.next();
System.out.println("Enter the address of the customer");
address=sc.next();
System.out.println("Enter the existing balance of the customer");
balance=sc.nextDouble();
System.out.println("Enter the account number of the customer");
acno=sc.nextInt();
}
void Show_data(){
	System.out.println("Account Number: "+acno+" Name: "+name+" Address: "+address+" Balance: "+balance);
}
boolean search(int acn) {
        if (acno==acn) {
            Show_data();
            return (true);
        }
        return (false);
    }

void delete_acc(int acn){
	System.out.println("Enter the account number to be deleted");
	if(acno==acn){
		name="";
		address="";
		balance=-1.0;
		System.out.println("Account deleted successfully");
	}
}
}
public class Bank_run {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].add_record();
        }
int ch;
        do {
            System.out.println("1.Display all \n 2.Search account \n 3.Edit account \n 4.Delete Account \n 5.Exit ");
                System.out.println("Your Choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].Show_data();
                        }
                        break;
					case 2:
					System.out.println("Total number of records:"+n);
                        System.out.print("Enter Account No U Want to Search...: ");
                        int acn = KB.nextInt();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;
						case 3:
						System.out.println("Total number of records:"+n);
						System.out.print("Enter Account No U Want to Edit...: ");
                        acn = KB.nextInt();
						found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
								int ch1=-1;
								while(ch1!=4){
									System.out.println("1.Edit name \n 2.Edit address \n 3.Edit balance \n 4.Exit");
									System.out.println("Enter your choice");
									ch1=KB.nextInt();
									switch(ch1){
										case 1:
										System.out.println("Enter the new name");
										String new_name=KB.next();
										C[i].name=new_name;
										break;
										case 2:
										System.out.println("Enter the new address");
										String new_add=KB.next();
										C[i].address=new_add;
										break;
										case 3:
										System.out.println("Enter the new balance");
										double new_bal=KB.nextDouble();
										C[i].balance=new_bal;
										break;
										case 4:
										System.out.println("Thank You");
										break;
										default:
										System.out.println("Wrong Choice");
										
										
										
									}
								}
								break;
							}
						}

                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
							
						}
						break;

							case 4:
							System.out.print("Enter Account No you want to delete: ");
                         acn = KB.nextInt();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].search(acn);
                            if (found) {
								C[i].delete_acc(acn);
								 break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;
						case 5:
                        System.out.println("Thank you for using our bank");
                        break;
                }
            }
		
            while (ch != 5);
        
    }
}