package Model.customer;

import java.util.ArrayList;

/**
 * @author dlsqo
 * @version 1.0
 * @created 10-5-2022 ���� 9:00:56
 */
public class Customer {

	private int age; // 0
	private int birthDate;
	private boolean gender; // 0
	private String id;
	private String job;
	private String customerName; // 0
	private String phoneNum; // 0
	private String ssn; // 0
	private ArrayList<String> subscribedInsurance;
	private String uniqueness;
	private ArrayList<String> accidentId;
	private String userId;
	private String userPw;
	// 새로 만든 속성(id, pw)

	public Customer() {

	}

	public Customer(int age,
			int birthDate,
			boolean gender,
			String name,
			String phoneNum,
			String ssn,
			String userId,
			String userPw, 
			String jop) {
		this.age = age;
		this.birthDate = birthDate;
		this.gender = gender;
		this.customerName = name;
		this.phoneNum = phoneNum;
		this.ssn = ssn;
		this.userId = userId;
		this.userPw = userPw;
		this.job = jop;
		this.subscribedInsurance = new ArrayList<String>();
	}

	public void finalize() throws Throwable {

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ArrayList<String> getSubscribedInsurance() {
		return subscribedInsurance;
	}

	public void setSubscribedInsurance(ArrayList<String> subscribedInsurance) {
		this.subscribedInsurance = subscribedInsurance;
	}

	public String getUniqueness() {
		return uniqueness;
	}

	public void setUniqueness(String uniqueness) {
		this.uniqueness = uniqueness;
	}

	public ArrayList<String> getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(ArrayList<String> accidentId) {
		this.accidentId = accidentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public boolean addInsurance(String insuranceName) {
		// 새로 만든 함수
		return subscribedInsurance.add(insuranceName);
	}

	@Override
	public String toString() {
		// 새로 만든 함수
		return id + " " + age + " " + birthDate + " " + customerName +
				" " + phoneNum + " " + ssn;
	}
}