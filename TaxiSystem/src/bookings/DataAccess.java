package bookings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import members.Customer;
import members.Driver;
import ui.Pricing;
import vehicles.ForHireVehicleState;
import vehicles.HiredVehicleState;
import vehicles.IVehicleState;
import vehicles.InMaintenanceVehicleState;
import vehicles.OfflineVehicleState;
import vehicles.Vehicle;
import dispatch.RideClass;

public class DataAccess {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3307/taxi_cab_system";
	private static final String USER = "root";
	private static final String PASS = "root";

	Statement stmt = null;
	PreparedStatement preparedStatement = null;

	public void insertRequest(Request request, Customer c) throws SQLException {

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

	insertRequest = "Insert into request( customer_id,"
	+ "request_type," + "pickup_longitude, "
	+ "pickup_latitude, " + "destination_longitude,"
	+ " destination_latitude," + "request_time, "

	+ " car_type, " + "is_car_seat," + "is_pet_friendly, "
	+ "bid_amount, " + "status , request_id) " + "values"
	+ "(?,?,?,?,?," + "?,?,?,?,?," + "?,?,?)";

	preparedStatement = dbConnection.prepareStatement(insertRequest);
	preparedStatement.setInt(1, c.getId());
	preparedStatement.setString(2, request.getRequestType());
	preparedStatement.setDouble(3, request.getPickY());
	preparedStatement.setDouble(4, request.getPickX());
	preparedStatement.setDouble(5, request.getDestY());
	preparedStatement.setDouble(6, request.getDestX());
	preparedStatement.setString(7,
	(request.getBookingDate()).toString());
	preparedStatement.setString(8, request.getCarType());

	int myInt = (request.isPetFriendlyFlag()) ? 1 : 0;
	preparedStatement.setInt(9, myInt);
	myInt = (request.isCarSeatFlag()) ? 1 : 0;
	preparedStatement.setInt(10, myInt);
	if (request.getBid() != null) {
	preparedStatement.setDouble(11, request.getBid().getFare());
	} else {
	preparedStatement.setDouble(11, 0);
	}
	preparedStatement.setString(12, request.getState().toString());
	preparedStatement.setLong(13, request.getRequestId());

	preparedStatement.executeUpdate();

	} catch (Exception e) {
	System.out.println("Error in inserting into Request table");
	e.printStackTrace();
	} finally {
	preparedStatement.close();
	dbConnection.close();

	}
	}

	public void cancelRequest(int requestId) throws SQLException {
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
	preparedStatement = dbConnection.prepareStatement(cancelRequest);
	preparedStatement.setString(1, "Cancelled");
	preparedStatement.setInt(2, requestId);
	preparedStatement.executeUpdate();
	} catch (Exception e) {
	System.out.println("Error in cancelling request");
	e.printStackTrace();
	} finally {
	preparedStatement.close();
	dbConnection.close();

	}

	// Get available drivers :

	// Select * from drivers where drivers where is_Availabe = true
	// insert ride object into ride table

	// Cancel request

	}

	public Vehicle retreivebyvehicleId(String vehicleId) {

	int vId = Integer.parseInt(vehicleId);
	String retreivebyvehicleId = null;
	Connection dbConnection = null;
	Vehicle vehicle = new Vehicle();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreivebyvehicleId = "Select * from vehicle where vehicle_id = ?";
	preparedStatement = dbConnection
	.prepareStatement(retreivebyvehicleId);

	preparedStatement.setInt(1, vId);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	// Retrieve by column name
	vehicle.setVehicleType(rs.getString("vehicle_type"));
	vehicle.setVehicleColor(rs.getString("vehicle_color"));
	vehicle.setModelNo(rs.getString("model_no"));
	vehicle.setLicensePlate(rs.getString("license_plate"));
	vehicle.setDriverName(rs.getString("driver_name"));

	vehicle.setVehicleId(rs.getInt("vehicle_id"));
	IVehicleState state = null;
	switch (rs.getString("status").toLowerCase()) {
	case "offline":
	state = new OfflineVehicleState(vehicle);
	break;
	case "hired":
	state = new HiredVehicleState(vehicle);
	break;
	case "for_hire":
	state = new ForHireVehicleState(vehicle);
	break;
	case "maintenance":
	state = new InMaintenanceVehicleState(vehicle);
	break;

	default:
	state = new OfflineVehicleState(vehicle);
	break;
	}
	vehicle.setState(state);

	}
	} catch (Exception e) {
	System.out.println("Error in retreiving vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	return vehicle;

	}

	public Customer retreiveCustomerById(String customerId) {
	int custId = Integer.parseInt(customerId);
	String retreiveCustomerById = null;
	Connection dbConnection = null;
	Customer customer = new Customer();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveCustomerById = "Select * from customer where customer_id = ?";
	preparedStatement = dbConnection
	.prepareStatement(retreiveCustomerById);

	preparedStatement.setInt(1, custId);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	// Retrieve by column name
	customer.setId(rs.getInt("customer_id"));
	customer.setName(rs.getString("name"));
	customer.setPlan(rs.getString("membership"));
	customer.setContactNo(rs.getString("contact_no"));
	customer.setEmail(rs.getString("email"));
	customer.setCreditCardNo(rs.getString("credit_card_number"));
	customer.setExpirationDate((rs.getString("exp_date")));

	}
	} catch (Exception e) {
	System.out
	.println("Error in retreiving Customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	return customer;

	}

	public void UpdateVehicleDetails(Vehicle v) {
	String UpdateVehicleDetails = null;
	Connection dbConnection = null;
	Customer customer = new Customer();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	UpdateVehicleDetails = "Update vehicle " + "set vehicle_color =?,"
	+ "vehicle_type =? ," + "model_no=?," + "driver_name=?, "
	// + "status=?"
	+ "license_plate=? " + "where vehicle_id=?";

	preparedStatement = dbConnection
	.prepareStatement(UpdateVehicleDetails);

	preparedStatement.setString(1, v.getVehicleColor());
	preparedStatement.setString(2, v.getVehicleType());
	preparedStatement.setString(3, v.getModelNo());
	preparedStatement.setString(4, v.getDriverName());
	preparedStatement.setString(5, v.getLicensePlate());
	// set where condition
	preparedStatement.setInt(6, v.getVehicleId());

	int i = preparedStatement.executeUpdate();

	}

	catch (Exception e) {
	System.out.println("Error in updating vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	}

	public void updateCustomerDetails(Customer c) {

	String updateCustomerDetails = null;
	Connection dbConnection = null;
	Customer customer = new Customer();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	updateCustomerDetails = "Update customer " + "set name =?,"

	+ "contact_no=?," + "email=?," + "credit_card_number=?,"
	+ "exp_date=?"

	// where
	+ "where customer_id=? ";

	preparedStatement = dbConnection
	.prepareStatement(updateCustomerDetails);

	preparedStatement.setString(1, c.getName());

	preparedStatement.setString(2, c.getContactNo());
	preparedStatement.setString(3, c.getEmail());
	preparedStatement.setString(4, c.getCreditCardNo());
	preparedStatement.setString(5, c.getExpirationDate());
	// set where condition
	preparedStatement.setInt(6, c.getId());

	int i = preparedStatement.executeUpdate();

	}

	catch (Exception e) {
	System.out.println("Error in updating customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	}

	public void deleteCustomer(Customer c) {

	String deleteCustomer = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	deleteCustomer = "Delete from customer where customer_id=?";

	preparedStatement = dbConnection.prepareStatement(deleteCustomer);

	preparedStatement.setInt(1, c.getId());

	preparedStatement.executeUpdate();

	}

	catch (Exception e) {
	System.out.println("Error in deleting customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	}

	public void updateObserverFlag(Driver driver) {

	String updateObserverFlag = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	updateObserverFlag = "Update driver " + "set is_observer=?"
	+ "where driver_id=?";

	preparedStatement = dbConnection
	.prepareStatement(updateObserverFlag);

	preparedStatement.setBoolean(1, driver.isObserver());
	preparedStatement.setInt(2, driver.getId());

	preparedStatement.executeQuery();

	}

	catch (Exception e) {
	System.out.println("Error in updating observer flag for driver");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	}

	public ArrayList<Customer> retreiveallCustomers() {

	String retreiveCustomerById = null;
	Connection dbConnection = null;
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveCustomerById = "Select * from customer";
	preparedStatement = dbConnection
	.prepareStatement(retreiveCustomerById);

	ResultSet rs = preparedStatement.executeQuery(retreiveCustomerById);
	while (rs.next()) {
	Customer customer = new Customer();
	// Retrieve by column name
	customer.setId(rs.getInt("customer_id"));
	customer.setName(rs.getString("name"));

	// Shraddha chnaged column name to memebrship from
	// membership_plan
	customer.setPlan(rs.getString("membership"));
	customer.setContactNo(rs.getString("contact_no"));
	customer.setEmail(rs.getString("email"));
	customer.setCreditCardNo(rs.getString("credit_card_number"));
	customer.setExpirationDate((rs.getString("exp_date")));
	customerList.add(customer);

	}
	} catch (Exception e) {
	System.out
	.println("Error in retreiving Customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	return customerList;
	}

	public void deleteDriver(Driver d) {

	String deleteDriver = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	deleteDriver = "Delete from Driver where driver_id=?";

	preparedStatement = dbConnection.prepareStatement(deleteDriver);

	preparedStatement.setInt(1, d.getId());

	preparedStatement.executeQuery();

	}

	catch (Exception e) {
	System.out.println("Error in deleting Driver information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	}

	public ArrayList<Driver> retrieveavailableObservers() {

	String retrieveavailableObservers = null;
	Connection dbConnection = null;
	ArrayList<Driver> driverList = new ArrayList<Driver>();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retrieveavailableObservers = "Select * from driver where is_observer=?";

	preparedStatement = dbConnection
	.prepareStatement(retrieveavailableObservers);
	preparedStatement.setBoolean(1, true);
	ResultSet rs = preparedStatement
	.executeQuery(retrieveavailableObservers);
	while (rs.next()) {
	Driver driver = new Driver();
	// Retrieve by column name
	driver.setId(rs.getInt("driver_id"));
	driver.setName(rs.getString("name"));
	driver.setContactNo(rs.getString("contact_no"));
	driver.setEmail(rs.getString("email"));
	driver.setLicenceNo(rs.getString("driver_license"));
	driver.setRegistrationDate((rs.getString("reg_date")));
	driver.setShiftStartTime((rs.getString("shift_start_time")));
	driver.setShiftEndTime((rs.getString("shift_end_time")));
	driverList.add(driver);

	}
	} catch (Exception e) {
	System.out.println("Error in retreiving Driver information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	return driverList;
	}

	public ArrayList<Driver> retreiveallDrivers() {

	String retreiveallDrivers = null;
	Connection dbConnection = null;
	ArrayList<Driver> driverList = new ArrayList<Driver>();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveallDrivers = "Select * from driver";
	preparedStatement = dbConnection
	.prepareStatement(retreiveallDrivers);

	ResultSet rs = preparedStatement.executeQuery(retreiveallDrivers);
	while (rs.next()) {
	Driver driver = new Driver();
	// Retrieve by column name
	driver.setId(rs.getInt("driver_id"));
	driver.setName(rs.getString("name"));
	// Shraddha Changed for SQL EXCEPTION CONTACT NO NOT PRESSENT
	// driver.setContactNo(rs.getString("contact_no"));
	// driver.setEmail(rs.getString("email"));
	driver.setLicenceNo(rs.getString("driver_license"));
	driver.setRegistrationDate((rs.getString("reg_date")));
	driver.setShiftStartTime((rs.getString("shift_start_time")));
	driver.setShiftEndTime((rs.getString("shift_end_time")));
	driverList.add(driver);

	}
	} catch (Exception e) {
	System.out.println("Error in retreiving Driver information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	return driverList;
	}

	public void deleteVehicle(Vehicle v) {

	String deleteVehicle = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block3

	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	deleteVehicle = "Delete from Vehicle where vehicle_id=?";

	preparedStatement = dbConnection.prepareStatement(deleteVehicle);

	preparedStatement.setInt(1, v.getVehicleId());

	preparedStatement.executeUpdate();

	}

	catch (Exception e) {
	System.out.println("Error in deleting Vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	}

	// Shraddha
	public Customer retreiveCustomerByName(String customerName) {
	String retreiveCustomerById = null;
	Connection dbConnection = null;
	Customer customer = new Customer();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveCustomerById = "Select * from customer where name = ?";
	preparedStatement = dbConnection
	.prepareStatement(retreiveCustomerById);

	preparedStatement.setString(1, customerName);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	// Retrieve by column name
	customer.setName(rs.getString("name"));

	customer.setContactNo(rs.getString("contact_no"));
	customer.setEmail(rs.getString("email"));
	customer.setCreditCardNo(rs.getString("credit_card_number"));
	customer.setExpirationDate((rs.getString("exp_date")));

	}
	} catch (Exception e) {
	System.out
	.println("Error in retreiving Customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}

	}

	return customer;

	}

	public void insertVehicleDetails(Vehicle v) {

	String insertVehicleDetails = null;
	Connection dbConnection = null;
	Vehicle vehicle = new Vehicle();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	insertVehicleDetails = "insert into vehicle (vehicle_color,vehicle_type,model_no,license_plate,driver_name,status) values(?,?,?,?,?,?)";

	preparedStatement = dbConnection
	.prepareStatement(insertVehicleDetails);

	preparedStatement.setString(1, v.getVehicleColor());

	preparedStatement.setString(2, v.getVehicleType());
	preparedStatement.setString(3, v.getModelNo());
	preparedStatement.setString(4, v.getLicensePlate());
	preparedStatement.setString(5, v.getDriverName());
	String string = "offline";
	IVehicleState state = v.getState();
	if (state instanceof OfflineVehicleState)
	string = "offline";
	if (state instanceof ForHireVehicleState)
	string = "for_hire";
	if (state instanceof HiredVehicleState)
	string = "hired";
	if (state instanceof InMaintenanceVehicleState)
	string = "inmaintenance";
	preparedStatement.setString(6, string);

	Boolean b = preparedStatement.execute();

	}

	catch (Exception e) {
	System.out.println("Error in inserting vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	}

	public int insertCustomer(Customer c) {

	Boolean b = false;
	String insertCustomer = null;
	Connection dbConnection = null;
	int i = 0;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {

	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	insertCustomer = "insert into customer(name,contact_no,email,membership, credit_card_number, exp_date,cvv) "

	+ "values(?,?,?,?,?,?,?)";
	preparedStatement = dbConnection.prepareStatement(insertCustomer);
	preparedStatement.setString(1, c.getName());
	preparedStatement.setString(2, c.getContactNo());
	preparedStatement.setString(3, c.getEmail());
	preparedStatement.setString(4, c.getPlan());
	preparedStatement.setString(5, c.getCreditCardNo());
	preparedStatement.setString(6, c.getExpirationDate());
	preparedStatement.setInt(7, c.getCvv());
	i = preparedStatement.executeUpdate();

	} catch (Exception e) {
	System.out.println("Error in Inserting customer information");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}

	}
	return i;
	}

	public void insertDriver(Driver c) {

	String insertDriver = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {

	dbConnection = DriverManager.getConnection(URL, USER, PASS);

	insertDriver = "INSERT INTO driver"
	+ "(driver_license ,reg_date ,shift_start_time , has_carseat , is_petfriendly ,"
	+ "is_available , driver_rating ,"
	+ " current_latitude , current_longitude ,is_observer ,status ,name ,shift_end_time)"
	+ "values" + "(?,?,?,?,?," + "?,?,?,?,?," + "?,?,?)";

	preparedStatement = dbConnection.prepareStatement(insertDriver);
	preparedStatement.setString(1, c.getLicenceNo());
	preparedStatement.setString(2, c.getRegistrationDate());
	preparedStatement.setString(3, c.getShiftStartTime());
	preparedStatement.setInt(4, 1);
	preparedStatement.setInt(5, 1);
	preparedStatement.setInt(6, 1);
	preparedStatement.setInt(7, 5);
	preparedStatement.setInt(8, 0);// Latitude
	preparedStatement.setInt(9, 0);

	preparedStatement.setInt(10, 1);
	preparedStatement.setString(11, "offline");

	preparedStatement.setString(12, c.getName());
	preparedStatement.setString(13, c.getShiftEndTime());
	int i = preparedStatement.executeUpdate();
	} catch (Exception e) {
	System.out.println("Error in Inserting customer information");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}

	}

	}

	public void insertPricingRules(Pricing p) {
	String insertPricingRules = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {

	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	insertPricingRules = "insert into pricingrules(normalrate,peakrate,cab_type,sub_type) "
	+ "values(?,?,?,?)";
	preparedStatement = dbConnection
	.prepareStatement(insertPricingRules);
	preparedStatement.setDouble(1, p.getNormalRate());
	preparedStatement.setDouble(2, p.getPeakRate());
	preparedStatement.setString(3, p.getCabType());
	preparedStatement.setString(4, p.getSubType());

	int i = preparedStatement.executeUpdate();
	} catch (Exception e) {
	System.out.println("Error in deleting Driver information by ID");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	}

	public Pricing retreivePricing(String cartype, String subtype) {

	String retreivePricing = null;
	Pricing pricing = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreivePricing = "Select * from pricingrules where cab_type=? and sub_type = ?";

	preparedStatement = dbConnection.prepareStatement(retreivePricing);
	preparedStatement.setString(1, cartype);
	preparedStatement.setString(2, subtype);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	pricing = new Pricing();
	pricing.setCabType(rs.getString("cab_type"));
	pricing.setSubType(rs.getString("sub_type"));
	pricing.setNormalRate(rs.getInt("normalrate"));
	pricing.setPeakRate(rs.getInt("peakrate"));
	}

	} catch (Exception e) {
	System.out.println("Error in fetching in Pricing table");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	return pricing;
	}

	public void updatePricingRules(Pricing p) {
	String insertPricingRules = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {

	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	insertPricingRules = "Update pricingrules " + "set normalrate=? , "
	+ "peakrate=? " + "where cab_type=? and sub_type =?";
	preparedStatement = dbConnection
	.prepareStatement(insertPricingRules);
	preparedStatement.setDouble(1, p.getNormalRate());
	preparedStatement.setDouble(2, p.getPeakRate());
	preparedStatement.setString(3, p.getCabType());
	preparedStatement.setString(4, p.getSubType());

	int i = preparedStatement.executeUpdate();
	} catch (Exception e) {
	System.out.println("Error in deleting Driver information by ID");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	}

	public ArrayList<Driver> retreiveDriverByStatus(String status) {

	ArrayList<Driver> driverList = new ArrayList<Driver>();
	String retreiveDriverByStatus = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveDriverByStatus = "Select * from driver where status = ?";

	preparedStatement = dbConnection
	.prepareStatement(retreiveDriverByStatus);
	// set where condition
	preparedStatement.setString(1, status);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	Driver driver = new Driver();
	driver.setName(rs.getString("name"));
	driver.setObserver((rs.getInt("is_observer") == 1) ? true
	: false);
	driver.setId(Integer.parseInt(rs.getString("driver_id")));
	driver.setCurrent_latitude(Integer.parseInt(rs
	.getString("current_latitude")));
	driver.setCurrent_longitude(Integer.parseInt(rs
	.getString("current_longitude")));
	driverList.add(driver);

	}

	}

	catch (Exception e) {
	System.out.println("Error in updating customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	return driverList;

	}

	public Driver retreiveDriverByName(String driverName) {

	ArrayList<Driver> driverList = new ArrayList<Driver>();
	String retreiveDriverByStatus = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveDriverByStatus = "Select * from driver where name = ?";

	preparedStatement = dbConnection
	.prepareStatement(retreiveDriverByStatus);
	// set where condition
	preparedStatement.setString(1, driverName);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	Driver driver = new Driver();
	driver.setName(rs.getString("name"));
	driver.setId(Integer.parseInt(rs.getString("driver_id")));
	driver.setCurrent_latitude(Integer.parseInt(rs
	.getString("current_latitude")));
	driver.setCurrent_longitude(Integer.parseInt(rs
	.getString("current_longitude")));
	driverList.add(driver);
	return driver;
	}

	}

	catch (Exception e) {
	System.out.println("Error in updating customer information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	return null;

	}

	public Vehicle retreiveVehicleByDriver(String DriverName) {

	String retreiveVehicleByDriver = null;
	Connection dbConnection = null;
	Vehicle vehicle = new Vehicle();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveVehicleByDriver = "Select * from vehicle where driver_name = ?";
	preparedStatement = dbConnection
	.prepareStatement(retreiveVehicleByDriver);
	preparedStatement.setString(1, DriverName);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	// Retrieve by column name

	vehicle.setModelNo(rs.getString("model_no"));
	vehicle.setLicensePlate(rs.getString("license_plate"));
	vehicle.setVehicleColor(rs.getString("vehicle_color"));
	vehicle.setVehicleId(rs.getInt("vehicle_id"));
	vehicle.setVehicleType(rs.getString("vehicle_type"));
	vehicle.setDriverName(rs.getString("driver_name"));
	}
	} catch (Exception e) {
	System.out.println("Error in retreiving vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	return vehicle;

	}

	public ArrayList<Vehicle> retreiveAllVehicles() {

	String retreiveVehicleByDriver = null;
	Connection dbConnection = null;
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retreiveVehicleByDriver = "Select * from vehicle";
	preparedStatement = dbConnection
	.prepareStatement(retreiveVehicleByDriver);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	// Retrieve by column name
	Vehicle vehicle = new Vehicle();

	vehicle.setVehicleType(rs.getString("vehicle_type"));
	vehicle.setVehicleColor(rs.getString("vehicle_color"));
	vehicle.setModelNo(rs.getString("model_no"));
	vehicle.setLicensePlate(rs.getString("license_plate"));
	vehicle.setDriverName(rs.getString("driver_name"));

	vehicle.setVehicleId(rs.getInt("vehicle_id"));
	IVehicleState state = null;
	switch (rs.getString("status").toLowerCase()) {
	case "offline":
	state = new OfflineVehicleState(vehicle);
	break;
	case "hired":
	state = new HiredVehicleState(vehicle);
	break;
	case "for_hire":
	state = new ForHireVehicleState(vehicle);
	break;
	case "inmaintenance":
	state = new InMaintenanceVehicleState(vehicle);
	break;

	default:
	state = new OfflineVehicleState(vehicle);
	break;
	}
	vehicle.setState(state);
	vehicles.add(vehicle);
	}
	} catch (Exception e) {
	System.out.println("Error in retreiving vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	return vehicles;

	}

	public void insertRideDetails(RideClass ride) {
	String insertRideDetails = null;
	Connection dbConnection = null;

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	DateFormat dateFormat = new SimpleDateFormat(
	"yyyy-MM-dd HH:mm:ss.ms");
	Date date = new Date();

	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	insertRideDetails = "insert into ride(request_id,driver_id,fare,payment_type,status,customer_rating,driver_rating) "
	+ "values(?,?,?,?,?,?,?)";
	// order of cols in the table - username , email , creditcard ,
	// billing address , plan , phone number , password and country
	preparedStatement = dbConnection
	.prepareStatement(insertRideDetails);
	preparedStatement.setLong(1, ride.getRequest_id());
	preparedStatement.setInt(2, ride.getDriver_id());
	// preparedStatement.setDate(3, new java.sql.Date(new
	// java.util.Date().getTime()));
	// preparedStatement.setDate(4, new java.sql.Date(new
	// java.util.Date().getTime()));
	preparedStatement.setFloat(3, (float) ride.getFare());
	preparedStatement.setString(4, ride.getPayment_type());
	preparedStatement.setString(5, ride.getStatus());
	preparedStatement.setInt(6, ride.getUser_rating());
	preparedStatement.setInt(7, ride.getDriver_rating());

	int i = preparedStatement.executeUpdate();
	} catch (Exception e) {
	System.out.println("Error in deleting Driver information by ID");
	e.printStackTrace();
	}

	finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}
	}

	public List<String> getNotAssignedDriverNames() {

	String retrieveDrivers = null;
	List<String> drivers = new ArrayList<String>();

	Connection dbConnection = null;
	Vehicle vehicle = new Vehicle();
	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	System.out.println("Error in connecting to the database");
	e1.printStackTrace();
	}

	try {
	dbConnection = DriverManager.getConnection(URL, USER, PASS);
	retrieveDrivers = "SELECT driver.name from driver where driver.name not in (select driver_name from vehicle);";
	preparedStatement = dbConnection.prepareStatement(retrieveDrivers);

	ResultSet rs = preparedStatement.executeQuery();
	while (rs.next()) {
	drivers.add(rs.getString(1));
	}
	} catch (Exception e) {
	System.out.println("Error in retreiving vehicle information by ID");
	e.printStackTrace();
	} finally {
	try {
	preparedStatement.close();
	dbConnection.close();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

	return drivers;

	}

}
