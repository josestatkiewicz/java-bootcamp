package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table  
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idStudent;
	private String firstName;
	private String lastName;
	private Integer regNumber;
	private static final SimpleDateFormat ftDate = new SimpleDateFormat("yyyy-MM-dd");
	private Date dateOfBirth;
	private Set<CoursesForStudent> coursesForStudents = new HashSet<CoursesForStudent>(0);

	public Student() {
	}

	public Student(String firstName, String lastName, Integer regNumber, Date dateOfBirth, Set<CoursesForStudent> coursesForStudents) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNumber = regNumber;
		this.dateOfBirth = dateOfBirth;
		this.coursesForStudents = coursesForStudents;
	}
	
	
	public Student(String firstName, String lastName, Integer regNumber, String dateOfBirth, Set<CoursesForStudent> coursesForStudents) throws ParseException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNumber = regNumber;
		this.dateOfBirth = ftDate.parse(dateOfBirth);
		this.coursesForStudents = coursesForStudents;
	}

	@Id
	@Column(name = "idStudent", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	@Column(name = "firstName", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "regNumber")
	public Integer getRegNumber() {
		return this.regNumber;
	}

	public void setRegNumber(Integer regNumber) {
		this.regNumber = regNumber;
	}

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using=DateSerializer.class)
	@Column(name = "dateOfBirth", length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) throws ParseException {
		this.dateOfBirth = ftDate.parse(dateOfBirth);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	public Set<CoursesForStudent> getCoursesForStudents() {
		return this.coursesForStudents;
	}

	public void setCoursesForStudents(Set<CoursesForStudent> coursesForStudents) {
		this.coursesForStudents = coursesForStudents;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tidStudent: %s\n\tfirstName: %s\n\tlastName: %s\n\tregNumber: %s\n\tdateOfBirth: %s\n}",
						getClass().getName(), idStudent, firstName, lastName,
						regNumber, dateOfBirth);
	}
	
	

}
