package student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.model.vo.Student;

public class StudentDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JDBC";
	private final String PASSWORD = "JDBC";

	public int insertStudnet(Student student) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String query = "INSERT INTO STUDENT_TBL VALUES (?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentNo());
			pstmt.setString(3, student.getGender());
			pstmt.setString(4, student.getEmail());
			pstmt.setString(5, student.getPhone());
			pstmt.setString(6, student.getAddress());
			pstmt.setString(7, student.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Student> selectList() {
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		List<Student> sList = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String query = "SELECT * FROM STUDENT_TBL";
			rset = stmt.executeQuery(query);
			sList = new ArrayList<Student>();
			while(rset.next()) {
				Student student = this.rsetToStudent(rset);
				sList.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sList;
	}

	public Student selectOne(String studentName) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		Student student = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String query = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME = '" + studentName + "'";
			rset = stmt.executeQuery(query);
			if(rset.next())
			student = rsetToStudent(rset);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public int deleteStudent(String studentName) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false); // 자동 커밋 해제
			stmt = conn.createStatement();
			String query = "DELETE FROM STUDENT_TBL WHERE STUDENT_NAME = '" + studentName + "'";
			result = stmt.executeUpdate(query);
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateStudent(Student modifyInfo) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			String query = "UPDATE STUDENT_TBL SET EMAIL = '" + modifyInfo.getEmail() 
							+ "', PNONE = '" + modifyInfo.getPhone() 
							+ "', ADDRESS = '" + modifyInfo.getAddress() 
							+ "', HOBBY = '" + modifyInfo.getHobby() + "'";
			result = stmt.executeUpdate(query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private Student rsetToStudent(ResultSet rset) throws SQLException 
	{
		Student student = new Student();
		student.setStudentName(rset.getString("STUDENT_NAME"));
		student.setStudentNo(rset.getString("STUDENT_NO"));
		student.setGender(rset.getString("GENDER"));
		student.setEmail(rset.getString("EMAIL"));
		student.setPhone(rset.getString("PHONE"));
		student.setAddress(rset.getString("ADDRESS"));
		student.setHobby(rset.getString("HOBBY"));
		return student;
	}
}
