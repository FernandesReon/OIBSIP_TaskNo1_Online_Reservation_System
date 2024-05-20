package ConnectivitynQueries;

public class Queries {
    public static final String LOGIN_QUERY = "SELECT * FROM login_details WHERE username = ? AND password = ?";
    public static final String PRINT_DETAILS = "SELECT * FROM ticket_info";
    public static final String INSERT_DETAILS = "INSERT INTO ticket_info (prnNumber, trainName, classType, journeyDate, " +
            "location, destination) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String DELETE_DATA = "DELETE FROM ticket_info WHERE prnNumber = ?";
}
