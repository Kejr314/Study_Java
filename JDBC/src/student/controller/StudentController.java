package student.controller;

import java.util.List;

import student.model.dao.StudentDAO;
import student.model.vo.Student;

public class StudentController {

	StudentDAO sDao;
	
	public StudentController() {
		sDao = new StudentDAO();
	}

	public int insertStudent(Student student) {
		int result = sDao.insertStudnet(student);
		return result;
	}

	public List<Student> printAllStudent() {
		List<Student> sList = sDao.selectList();
		return sList;
	}

	public Student printOneStudent(String studentName) {
		Student student = sDao.selectOne(studentName);
		return student;
	}

	public int removeStudent(String studentName) {
		int result = sDao.deleteStudent(studentName);
		return result;
	}

	public int modifyStudent(Student modifyInfo) {
		int result = sDao.updateStudent(modifyInfo);
		return result;
	}

}
