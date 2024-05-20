import Authentication.Login;
import ConnectivitynQueries.ConnectDB;
import TicketReservationLogic.TicketLogics;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();
        String choice;
        System.out.println("Welcome to Online Reservation System");
        System.out.println();
        login.checkDetails();

        try (Connection connection = ConnectDB.connectDB()){
            label:
            while (true){
                System.out.println("Select the Operation");
                System.out.println("1. View details");
                System.out.println("2. Insert data");
                System.out.println("3. Cancel ticket");
                System.out.println("4. Exit");
                System.out.println();
                System.out.print("Enter Choice: ");
                choice = input.nextLine();

                switch (choice) {
                    case "1":
                        TicketLogics.readData();
                        break;
                    case "2":
                        TicketLogics.insertData();
                        break;
                    case "3":
                        TicketLogics.deleteData();
                        break;
                    case "4":
                        System.out.println("Thank you!");
                        break label;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }
        }
        catch (SQLException e){
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}