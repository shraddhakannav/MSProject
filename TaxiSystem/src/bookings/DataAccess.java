package bookings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DataAccess {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/taxi_cab_system";
	private static final String USER = "root";
	private static final String PASS = "password";

	Statement stmt = null;
	PreparedStatement preparedStatement = null;

	public void insertRequest(Request request, int customerId)throws SQLException{


		String insertRequest = null;
		Connection dbConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error in connecting to the database");
			e1.printStackTrace();
		}
		dbConnection = DriverManager.getConnection(URL, USER, PASS);
		try {

			insertRequest = "Insert into request(customer_id,request_type,"
					+ "pickup_longitude, pickup_latitude, destination_longitude, destination_latitude"
					+ "request_time, is_preschedule, is_taxi, car_type, is_car_seat"
					+ "is_pet_friendly, bid_amount, status) "
					+ "values"
					+ "(?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?" ;

			preparedStatement = dbConnection
					.prepareStatement(insertRequest);
			preparedStatement.setInt(1,customerId);
			preparedStatement.setString(2,request.getRequestType());
			//			preparedStatement.setDouble(3,request.getPickUpLongitude());
			//			preparedStatement.setDouble(4,request.getPickUpLatitude());
			//			preparedStatement.setDouble(5,request.getDestLongitude());
			//			preparedStatement.setDouble(6,request.getDestLatitude());

			//preparedStatement.setString(7,request.getRequestTime());
			//			preparedStatement.setInt(8,request.getPrescheduleFlag());
			//			preparedStatement.setInt(8,request.getCarTypeFlag());
			//
			//			preparedStatement.setInt(9,request.getCaSeatFlag);
			//			preparedStatement.setInt(9,request.getPetFriendlyFlag());
			//			preparedStatement.setInt(11, request.getBid().getFare());


			preparedStatement.executeUpdate();

		}
		catch(Exception e)
		{
			System.out.println("Error in inserting into Request table");
			e.printStackTrace();
		}
		finally{
			preparedStatement.close();
			dbConnection.close();

		}
	}
	public void cancelRequest(int requestId)throws SQLException
	{
		String cancelRequest = null;
		Connection dbConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Error in connecting to the database");
			e1.printStackTrace();
		}
		dbConnection = DriverManager.getConnection(URL, USER, PASS);
		try {

			cancelRequest = "Update Request set status = ? where request_id = ?";
			preparedStatement = dbConnection
					.prepareStatement(cancelRequest);
			preparedStatement.setString(1,"Cancelled");
			preparedStatement.setInt(2,requestId);
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("Error in cancelling request");
			e.printStackTrace();
		}
		finally{
			preparedStatement.close();
			dbConnection.close();

		}


	}
}
