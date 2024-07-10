package student.view;

import java.util.List;
import java.util.Scanner;

import student.controller.StudentController;
import student.model.vo.Student;

public class StudentView {

	StudentController sController;
	
	public StudentView() {
		sController = new StudentController();
	}
	
	public void startProgram() {
		end:
		while (true) {
			int value = this.printMainManu();
			switch (value) {
			case 1: // 학생 정보 입력
				Student student = this.inputStudent();
				int result = sController.insertStudent(student);
				if(result > 0) {
					this.displayMessage("등록 성공");
				} else {
					this.displayMessage("등록 실패");
				}
				break;
			case 2: // 전체 학생 조회
				List<Student> sList = sController.printAllStudent();
				this.printAllStudent(sList);
				break;
			case 3: // 학생 정보 조회
				String studentName = this.inputStudentName();
				student = sController.printOneStudent(studentName);
				this.printOneStudent(student);
				break;
			case 4: // 학생 정보 수정
				studentName = inputStudentName();
				student = sController.printOneStudent(studentName);
				if(student != null) {
					Student modifyInfo = this.inputModifyInfo();
					modifyInfo.setStudentName(studentName);
					result = sController.modifyStudent(modifyInfo);
					if(result > 0) {
						this.displayMessage("수정 성공");
					} else {
						this.displayMessage("수정 실패");
					}
				} else {
					this.displayMessage("존재하지 않는 정보입니다.");
				}
				break;
			case 5: // 학생 정보 삭제
				studentName = this.inputStudentName();
				student = sController.printOneStudent(studentName);
				if(student != null) {
					result = sController.removeStudent(studentName);
					if(result > 0) {
						this.displayMessage("삭제 성공");
					} else {
						this.displayMessage("삭제 실패");
					}
				} else {
					this.displayMessage("존재하지 않는 정보입니다.");
				}
				break;
			case 0: // 프로그램 종료
				this.displayMessage("프로그램 종료");
				break end;
			}
		}
	}

	private Student inputModifyInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원 정보 수정 =====");
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.next();
		String address = sc.nextLine();
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		
		Student student = new Student();
		student.getEmail();
		student.getPhone();
		student.getAddress();
		student.getHobby();
		
		return student;
	}

	private void displayMessage(String msg) {
		System.out.println("[서비스 결과] : " + msg);
	}

	private void printOneStudent(Student student) {
		System.out.println("===== 학생 정보 출력 =====");
		System.out.printf("이름 : %s, 성별 : %s, 이메일 : %s, 전화번호 : %s, 주소 : %s, 취미 : %s\n",
				student.getStudentName(), student.getGender(), student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby());

	}

	private String inputStudentName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 이름 : ");
		String studentName = sc.next();
		return studentName;
	}

	private void printAllStudent(List<Student> sList) {
		System.out.println("====== 학생 정보 출력 =====");
		for(Student student : sList) {
		System.out.printf("이름 : %s, 성별 : %s, 이메일 : %s, 전화번호 : %s, 주소 : %s, 취미 : %s\n",
							student.getStudentName(), student.getGender(), student.getEmail(), student.getPhone(), student.getAddress(), student.getHobby());
		}
	}

	private Student inputStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 학생 정보 등록 =====");
		System.out.print("이름 : ");
		String studentName = sc.next();
		System.out.print("주민등록번호 : ");
		sc.nextLine();
		String studentNo = sc.nextLine();
		System.out.print("성별 : ");
		String gender = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		System.out.print("주소 : ");
		sc.nextLine();
		String address = sc.nextLine();
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentNo(studentNo);
		student.setGender(gender);
		student.setEmail(email);
		student.setPhone(phone);
		student.setAddress(address);
		student.setHobby(hobby);
		
		return student;
	}

	private int printMainManu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 학생 관리 프로그램 =====");
		System.out.println("1. 학생 등록");
		System.out.println("2. 전체 학생 조회");
		System.out.println("3. 학생 정보 조회 ");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
}
