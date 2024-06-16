package exercise;

public class Student {
	private String studentId;
	private String studentName;
	
	public Student(String studentId, String studentName) {
		this.setStudentId(studentId);
		this.setStudentName(studentName);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(studentId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			if(this.studentId == std.studentId) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return studentId + ":" + studentName;
	}
}
