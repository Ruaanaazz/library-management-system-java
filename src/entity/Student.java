package entity;

public class Student {
	private String stud_id;
	private String name;
	private String branch;
	private int sem;
	private String mobile;
	private String email;
	public Student() {
		super();
	}
	public Student(String stud_id, String name, String branch, int sem, String mobile, String email) {
		super();
		this.stud_id = stud_id;
		this.name = name;
		this.branch = branch;
		this.sem = sem;
		this.mobile = mobile;
		this.email = email;
	}
	public String getStud_id() {
		return stud_id;
	}
	public void setStud_id(String stud_id) {
		this.stud_id = stud_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", name=" + name + ", branch=" + branch + ", sem=" + sem + ", mobile="
				+ mobile + ", email=" + email + "]";
	}
	
	
}
