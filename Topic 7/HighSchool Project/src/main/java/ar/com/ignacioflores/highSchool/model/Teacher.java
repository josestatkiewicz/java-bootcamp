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

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTeacher;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private static final SimpleDateFormat ftDate = new SimpleDateFormat("yyyy-MM-dd");
	private Set<Course> courses = new HashSet<Course>(0);

	public Teacher() {
	}

	public Teacher(String firstName, String lastName, Date dateOfBirth,
			Set<Course> courses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTeacher", unique = true, nullable = false)
	public Integer getIdTeacher() {
		return this.idTeacher;
	}

	public void setIdTeacher(Integer idTeacher) {
		this.idTeacher = idTeacher;
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

	@Temporal(TemporalType.DATE)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tidTeacher: %s\n\tfirstName: %s\n\tlastName: %s\n\tdateOfBirth: %s\n\tcourses: %s\n}",
						getClass().getName(), idTeacher, firstName, lastName,
						dateOfBirth, courses);
	}
	
	

}
