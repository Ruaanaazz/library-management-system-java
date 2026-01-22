package dbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutils.DBConnection;
import entity.Student;

public class StudentOperations {
public int addStudent(Student student) {
	int status = 0;
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "insert into student(stud_id,name,branch,sem,mobile,email) values (?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(qry);
		pst.setString(1, student.getStud_id());
		pst.setString(2, student.getName());
		pst.setString(3, student.getBranch());
		pst.setInt(4, student.getSem());
		pst.setString(5, student.getMobile());
		pst.setString(6, student.getEmail());
		
		status = pst.executeUpdate();
		
	}catch(Exception e) {
		System.out.println("error in addbook():"+e.getMessage());
	}
	return status;
}
public Student findStudent(String stud_id) {

    Student student = null;

    try {
        Connection conn = DBConnection.getConnection();
        String qry = "select stud_id,name,branch,sem,mobile,email from student where stud_id=?";
        PreparedStatement pst = conn.prepareStatement(qry);

        pst.setString(1, stud_id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            student = new Student();
            student.setStud_id(rs.getString("stud_id"));
            student.setName(rs.getString("name"));
            student.setBranch(rs.getString("branch"));
            student.setSem(rs.getInt("sem"));
            student.setMobile(rs.getString("mobile"));
            student.setEmail(rs.getString("email"));
        }

        pst.close();
        conn.close();

    } catch (Exception e) {
        System.out.println("Error in findStudent(): " + e.getMessage());
    }

    return student;
}
public int deleteStudent(String stud_id) {
	 int status = 0;
	 try {
	        Connection conn = DBConnection.getConnection();
	        String qry = "delete from student where stud_id=?";
	        PreparedStatement pst = conn.prepareStatement(qry);
	        pst.setString(1, stud_id);
	        status = pst.executeUpdate();

	        pst.close();
	        conn.close();

	    } catch (Exception e) {
	        System.out.println("Error in deleteStudent(): " + e.getMessage());
	    }
return status;
}
public int updateStudent(Student student) {
	int status = 0;
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "update student set name=?,branch=?,sem=?,mobile=?,email=? where stud_id=?";
		PreparedStatement pst = conn.prepareStatement(qry);
		pst.setString(1, student.getName());
		pst.setString(2, student.getBranch());
		pst.setInt(3, student.getSem());
		pst.setString(4, student.getMobile());
		pst.setString(5, student.getEmail());
		pst.setString(6, student.getStud_id());	
		status = pst.executeUpdate();
		
	}catch(Exception e) {
		System.out.println("error in updateStudent():"+e.getMessage());
	}
	return status;
}
public List<Student> getAllStudents(){
	List<Student> studentsList = new ArrayList<Student>();
	try {
		Connection conn = DBConnection.getConnection();
		String qry = "select stud_id,name,branch,sem,mobile,email from student";
		PreparedStatement pst = conn.prepareStatement(qry);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Student student = new Student();
			student.setStud_id(rs.getString("stud_id"));
			student.setName(rs.getString("name"));
			student.setBranch(rs.getString("branch"));
			student.setSem(rs.getInt("sem"));
			student.setMobile(rs.getString("mobile"));
			student.setEmail(rs.getString("email"));
			studentsList.add(student);
		}
		pst.close();
		conn.close();
	}catch(Exception e) {
		System.out.println("error in addbook:"+e.getMessage());
	}
	return studentsList;
}
}
