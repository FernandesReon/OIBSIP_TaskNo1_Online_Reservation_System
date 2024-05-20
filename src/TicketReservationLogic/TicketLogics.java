package TicketReservationLogic;

import ConnectivitynQueries.ConnectDB;
import ConnectivitynQueries.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TicketLogics {

    static Connection connection = ConnectDB.connectDB();
    public static void readData(){
        try (
                PreparedStatement statement = connection.prepareStatement(Queries.PRINT_DETAILS);
        ){
            ResultSet result = statement.executeQuery();
            if (result.next()){
                int prnNumber = result.getInt("prnNumber");
                String trainName = result.getString("trainName");
                String classType = result.getString("classType");
                String journeyDate = result.getString("journeyDate");
                String location = result.getString("location");
                String destination = result.getString("destination");


                System.out.println("PRN_Number: "+prnNumber);
                System.out.println("Train_Name: "+ trainName);
                System.out.println("Class_Type : "+ classType);
                System.out.println("Journey_Date: "+journeyDate);
                System.out.println("Location: "+ location);
                System.out.println("Destination: "+ destination);
                System.out.println("----------------------------");
            }
            else {
                System.out.println("No Data Available.");
                System.out.println("----------------------------");

            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }

    public static void insertData(){
        Ticket ticket = new Ticket();
        try (
//                Connection connection = ConnectDB.connectDB();
                PreparedStatement statement = connection.prepareStatement(Queries.INSERT_DETAILS)
        ){

            int prn_Number = ticket.getPrnNumber();
            String train_Name = ticket.getTrainName();
            String class_Type = ticket.getClassType();
            String journey_Date = ticket.getJourneyDate();
            String location = ticket.getLocation();
            String destination = ticket.getDestination();


            statement.setInt(1, prn_Number);
            statement.setString(2, train_Name);
            statement.setString(3, class_Type);
            statement.setString(4, journey_Date);
            statement.setString(5, location);
            statement.setString(6, destination);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Data added successfully.");
            }
            else{
                System.out.println("No records were added.");
            }
        }
        catch (SQLException e){
            System.out.println("SQL Exception: "+e.getMessage());

        }
    }

    public static void deleteData(){
        Scanner scanner = new Scanner(System.in);
        try (
//                Connection connection = ConnectDB.connectDB();
                PreparedStatement statement = connection.prepareStatement(Queries.DELETE_DATA)
        ){
            System.out.println("Enter the PRN number to delete record: ");
            int prn_Number = scanner.nextInt();

            statement.setInt(1, prn_Number);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Record was deleted successfully.");
            }
            else{
                System.out.println("No record were deleted.");
            }
        }
        catch (SQLException e){
            System.out.println("SQL Exception: "+e.getMessage());
        }
    }
}
