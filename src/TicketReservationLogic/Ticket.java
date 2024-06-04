package TicketReservationLogic;

import java.util.Random;
import java.util.Scanner;

public class Ticket {
    Scanner input = new Scanner(System.in);
    private static final int min = 100;
    private static final int max = 1000;

    private static final String[] trainNames = {
            "Shinkansen H5 and E5", "Rajdhani Express", "Shatabdi Express",
            "Duronto Express", "Eurostar", "Rajya Rani Express",
            "Orient Express", "Tejas Express", "TGV"
    };
    private int prnNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String location;
    private String destination;


    public int getPrnNumber(){
        Random random = new Random();
        prnNumber = random.nextInt(max) + min;
        return prnNumber;
    }

    public String getTrainName() {
        Random random = new Random();
        int index = random.nextInt(trainNames.length);
        trainName = trainNames[index];
        return trainName;
    }

    public String getClassType() {
        System.out.print("Enter the class type: ");
        classType = input.nextLine();
        return classType;
    }

    public String getJourneyDate() {
        System.out.print("Enter date of journey: ");
        journeyDate = input.nextLine();
        return journeyDate;
    }

    public String getLocation() {
        System.out.print("Enter your location: ");
        location = input.nextLine();
        return location;
    }

    public String getDestination() {
        System.out.print("Enter your destination: ");
        destination = input.nextLine();
        return destination;
    }

}
