package ar.com.ignacioflores.mysqljava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String host = "jdbc:mysql://localhost/";
	private String db = "high-school";
	private String user = "bootcamp";
	private String pass = "bootcamp-java";

	public void getCourseParticipants(int courseId) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call GetCourseParticipants("+ courseId +")");
			resultSet.next();
			String courseName = resultSet.getString("CourseName");
			System.out.println("Course: " + courseName);
			String teacherName = 	resultSet.getString("TeacherLastName").toUpperCase() + ", " + 
									resultSet.getString("TeacherFirstName");
			System.out.println("Teacher: " + teacherName);
			System.out.println("Students:");
			resultSet.absolute(0);
			while (resultSet.next()) {
				String studentName =	resultSet.getString("StudentLastName").toUpperCase() + ", " + 
										resultSet.getString("StudentFirstName");
				System.out.println("\t" + studentName);			 
			}
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}

	public void listFinalNotes(String studentLastName) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call ListFinalNotesByLastName('"+ studentLastName +"')");
			String studentName = "";
			while (resultSet.next()) {
				if (studentName != 	resultSet.getString("StudentLastName").toUpperCase() + ", " + 
									resultSet.getString("StudentFirstName")) {
					studentName =	resultSet.getString("StudentLastName").toUpperCase() + ", " + 
									resultSet.getString("StudentFirstName");
					System.out.println(studentName);
				}
				String courseName = resultSet.getString("CourseName");
				String finalNote = resultSet.getString("FinalNote");
				System.out.println("\t" + courseName + ": " + finalNote);
			}
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}
	
	public void listFinalNotes(int studentRegNumber) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call ListFinalNotesByRegNumber("+ studentRegNumber +")");
			resultSet.next();
			String studentName =resultSet.getString("StudentLastName").toUpperCase() + ", " + 
								resultSet.getString("StudentFirstName");
			System.out.println(studentName);
			resultSet.absolute(0);
			while (resultSet.next()) {
				String courseName = resultSet.getString("CourseName");
				String finalNote = resultSet.getString("FinalNote");
				System.out.println("\t" + courseName + ": " + finalNote);
			}
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}
	
	public void getPassedInfo(int courseId) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call GetPassedInfo("+ courseId +")");
			resultSet.next();
			String courseName = resultSet.getString("CourseName");
			System.out.println(courseName + ":");
			String passedPorcent = resultSet.getString("PassedPorcent");
			System.out.println("\t" + "Passed: " + passedPorcent + "%");
			String failedPorcent = resultSet.getString("FailedPorcent");
			System.out.println("\t" + "Failed: " + failedPorcent + "%");
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}

	public void getTeacherTimeline(int teacherId) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call GetTeacherTimeline("+ teacherId +")");
			resultSet.next();
			String teacherName =resultSet.getString("TeacherLastName").toUpperCase() + ", " + 
								resultSet.getString("TeacherFirstName");
			System.out.println("Teacher: " + teacherName);
			System.out.println("Schedule: ");
			resultSet.absolute(0);
			while (resultSet.next()) {
				String timeCourseDayOfWeek = resultSet.getString("TimeCourseDayOfWeek");
				String timeCourseTimeFrom = resultSet.getString("TimeCourseTimeFrom");
				String timeCourseTimeTo = resultSet.getString("TimeCourseTimeTo");
				String courseName = resultSet.getString("CourseName");
				
				System.out.println(	"\t" + 
									timeCourseDayOfWeek + " " +
									timeCourseTimeFrom + " - " +
									timeCourseTimeTo + ": " +
									courseName);
			}
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}
	
	public void getCriticsStudent() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CriticsStudents");
			resultSet.next();
			String studentName = "";
			
			while (resultSet.next()) {
				
				studentName =	resultSet.getString("StudentLastName").toUpperCase() + ", " +
								resultSet.getString("StudentFirstName");
				System.out.println(studentName + ":");
				String courseName = resultSet.getString("CourseName");
				System.out.println("\t" + "Course: " + courseName + ":");
				String averageNote = resultSet.getString("AverageNote");
				System.out.println("\t" + "Average note: " + averageNote);
				String teacherName =resultSet.getString("TeacherLastName").toUpperCase() + ", " +
									resultSet.getString("TeacherFirstName");
				System.out.println(	"\t" + "Teacher: " + teacherName);
			}
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}
	
	public void removeOldTeacher() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(host + db , user, pass);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("call RemoveOldTeacher()");
		} 
		catch (Exception e) {
			throw e;
		} 
		finally {
			close();
		}
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}
		catch (Exception e) {
			
		}
	}
} 