package SGCR_DB;
import java.sql.*;

public class DataBase {
	/* Server connection details */
	private static String url;
	private static String user;
	private static String password;
	private static boolean isOnline;
	private static Connection connexion;
	private static Statement statement;
	private static ResultSet resultset;
	private static String status;

	private DataBase() {

		System.out.println("-------Using Oracle DataBase --------- ! ");
	}

	/* getters & setters */

	

	private String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	

	public boolean isOnline() {
		return isOnline;
	}

	@Override
	public String toString() {
		String status = this.isOnline ? "Online" : "Offline";
		return ("MyAppDataBase info : \n url:\n" + url + ", user:\n" + user + ", password:\n" + password + ", status:\n"
				+ status);
	}

	public static void connectToDB(String url, String user, String password, String schema)
	
			throws ClassNotFoundException, SQLException {
//Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("-------Using Oracle DataBase --------- ! ");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connexion = DriverManager.getConnection(url, user, password);
		statement = connexion.createStatement();
		statement.execute("alter session set current_schema="+schema);
		isOnline = true;
		status = isOnline ? "Online" : "Offline";	
	}

	public static void updateQuery(String Query) throws SQLException {
		if (isOnline) {
			statement.executeUpdate(Query); //INSERT, UPDATE, DELETE
		} else {
			throw new SQLException("you cannot execute Queries unless you are connected to a database !");
		}
	}

	public static ResultSet selectQuery(String Query2) throws SQLException {
		if (isOnline) {
			return statement.executeQuery(Query2);
		} else {
			throw new SQLException("you cannot execute Queries unless you are connected to a database !");
		}
	
	}

	public void disconnectFromDB() throws SQLException {
		/*
		 * disconnects from the current connected database throws SQL Exception
		 */
		if (isOnline) {
			connexion.close();
			statement.close();
			status = "Offline";
		}

		System.out.println("Server status : \t" + status);
	}

}
