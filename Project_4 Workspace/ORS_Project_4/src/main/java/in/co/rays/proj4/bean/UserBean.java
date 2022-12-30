package in.co.rays.proj4.bean;

import java.util.Date;
import java.sql.Timestamp;

public class UserBean extends BaseBean {

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String confirmPassword;
	private Date dob;
	private String mobileNo;
	private long roleId;
	private int unsuccessfulLogin;
	private String gender;
	private Timestamp lastLogin;
	private String lock = INACTIVE;
	private String registeredIP;
	private String lastloginIP;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date date) {
		this.dob = date;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getUnsuccessfulLogin() {
		return unsuccessfulLogin;
	}

	public void setUnsuccessfulLogin(int unsuccessfulLogin) {
		this.unsuccessfulLogin = unsuccessfulLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastloginIP() {
		return lastloginIP;
	}

	public void setLastloginIP(String lastloginIP) {
		this.lastloginIP = lastloginIP;
	}

	public static String getActive() {
		return ACTIVE;
	}

	public static String getInactive() {
		return INACTIVE;
	}
    
	public String getkey() {
		
		return id+"";
	}

	public String getValue() {
		
		return firstname+" "+lastname;
	}

	

}
