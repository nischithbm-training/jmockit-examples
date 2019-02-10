package jmockit.examples.users;


public class User {
	private String id; // auto-generated id
	private String userName;
	private String password;
	private String displayName;
	private Long rewardPoints;

	@Override
	public User clone()
	throws CloneNotSupportedException {
		User newUser = new User();
		newUser.setId(this.id);
		newUser.setUserName(this.userName);
		newUser.setPassword(this.password);
		newUser.setDisplayName(this.displayName);
		newUser.setRewardPoints(this.rewardPoints);
		return newUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Long getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
}
