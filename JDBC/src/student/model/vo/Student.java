package student.model.vo;

public class Student {
	
	private String studentName;
	private String studentNo;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentNo=" + studentNo + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby + "]";
	}
	
}
