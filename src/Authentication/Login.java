package Authentication;

import ConnectivitynQueries.ConnectDB;
import ConnectivitynQueries.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    Scanner input = new Scanner(System.in);
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void checkDetails() {
        try (Connection connection = ConnectDB.connectDB();
             PreparedStatement statement = connection.prepareStatement(Queries.LOGIN_QUERY)) {

            boolean loginSuccess = false;
            while (!loginSuccess) {
                System.out.println("Enter Details to login --");
                System.out.print("Username: ");
                username = input.nextLine();
                System.out.print("Password: ");
                password = input.nextLine();

                statement.setString(1, username);
                statement.setString(2, password);

                ResultSet result = statement.executeQuery();

                if (result.next()) {
                    System.out.println();
                    System.out.println("-------------");
                    System.out.println("Login Successful!");
                    loginSuccess = true;

                    System.out.println("Hello " + username + ". Welcome to Online Reservation System.");
                    System.out.println("----------------");
                    System.out.println();
                } else {
                    System.out.println("Invalid Username or Password. Please try again.");
                }
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
}
