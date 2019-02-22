package vo;

public class available_thingsVO {
	
	private String category;

	private int user_id;
	private int elec;
	private int edu;
	private int health;
	private int hunger;
	private int sports;
	private int household;
	private String other;
	private userVO userVo;
	
	private String electext;
	private String edutext;
	private String healthtext;
	private String hungertext;
	private String sportstext;
	private String housetext;
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getElectext() {
		return electext;
	}
	public void setElectext(String electext) {
		this.electext = electext;
	}
	public String getEdutext() {
		return edutext;
	}
	public void setEdutext(String edutext) {
		this.edutext = edutext;
	}
	public String getHealthtext() {
		return healthtext;
	}
	public void setHealthtext(String healthtext) {
		this.healthtext = healthtext;
	}
	public String getHungertext() {
		return hungertext;
	}
	public void setHungertext(String hungertext) {
		this.hungertext = hungertext;
	}
	public String getSportstext() {
		return sportstext;
	}
	public void setSportstext(String sportstext) {
		this.sportstext = sportstext;
	}
	public String getHousetext() {
		return housetext;
	}
	public void setHousetext(String housetext) {
		this.housetext = housetext;
	}
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public userVO getUserVo() {
		return userVo;
	}
	public void setUserVo(userVO userVo) {
		this.userVo = userVo;
	}

	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	public int getElec() {
		return elec;
	}
	public void setElec(int elec) {
		this.elec = elec;
	}
	public int getEdu() {
		return edu;
	}
	public void setEdu(int edu) {
		this.edu = edu;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getHunger() {
		return hunger;
	}
	public void setHunger(int hunger) {
		this.hunger = hunger;
	}
	public int getSports() {
		return sports;
	}
	public void setSports(int sports) {
		this.sports = sports;
	}
	public int getHousehold() {
		return household;
	}
	public void setHousehold(int household) {
		this.household = household;
	}

	

}
