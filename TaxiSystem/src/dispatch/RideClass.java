package dispatch;

import java.util.Date;

public class RideClass implements Ride{
	
	State state;
	
	public RideClass()
	{
		state=new Ride_started(this);
	}
	
	public void startRide(){
		state.startRide();
	};
	public String modifyRide(String s){
		//System.out.println("state" +state.getClass());
		return state.modifyRide(s);
	};
	public void cancelRide(){
		state.cancelRide();
	};
	public void delayRide(){
		state.delayRide();
	};
	public void endRide(){
		state.endRide();
	};
	public void setState(State s){
		this.state=s;
	};
	public State getState(){
		return state;
	};
	
	
	
	
	//// for all getters and setters
	
	private int request_id;
	private int driver_id;
	private Date start_time;
	private Date end_time;
	private double fare;
	private String payment_type;
	private String status;
	private int user_rating;
	private int driver_rating;
	
	
	
	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(int user_rating) {
		this.user_rating = user_rating;
	}

	public int getDriver_rating() {
		return driver_rating;
	}

	public void setDriver_rating(int driver_rating) {
		this.driver_rating = driver_rating;
	}




	
	

}
