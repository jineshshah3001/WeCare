package vo;

public class subscriptionVO {
	 
	private int subscription_id;
	private String email_id;
	private String EIN;
	private String name;
	private int active;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getEIN() {
		return EIN;
	}
	public void setEIN(String eIN) {
		EIN = eIN;
	}
	public int getSubscription_id() {
		return subscription_id;
	}
	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	
}
