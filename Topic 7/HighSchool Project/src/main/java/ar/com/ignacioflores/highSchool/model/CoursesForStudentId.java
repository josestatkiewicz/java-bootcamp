package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CoursesForStudentId implements Serializable {

	private static final long serialVersionUID = 1L;

	private int student;
	private int course;

	public CoursesForStudentId() {
	}

	public CoursesForStudentId(int student, int course) {
		this.student = student;
		this.course = course;
	}

	@Column(name = "student", nullable = false)
	public int getStudent() {
		return this.student;
	}

	public void setStudent(int student) {
		this.student = student;
	}

	@Column(name = "course", nullable = false)
	public int getCourse() {
		return this.course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CoursesForStudentId))
			return false;
		CoursesForStudentId castOther = (CoursesForStudentId) other;

		return (this.getStudent() == castOther.getStudent()) && (this.getCourse() == castOther.getCourse());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getStudent();
		result = 37 * result + this.getCourse();
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s {\n\tstudent: %s\n\tcourse: %s\n}", getClass()
				.getName(), student, course);
	}
	
	

}
