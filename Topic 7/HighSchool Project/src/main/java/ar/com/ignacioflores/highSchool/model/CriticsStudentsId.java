package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CriticsStudentsId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String studentLastName;
	private String studentFirstName;
	private String courseName;
	private BigDecimal averageNote;
	private String teacherLastName;
	private String teacherFirstName;

	public CriticsStudentsId() {
	}

	public CriticsStudentsId(String studentLastName, String studentFirstName,
			String courseName, BigDecimal averageNote, String teacherLastName,
			String teacherFirstName) {
		this.studentLastName = studentLastName;
		this.studentFirstName = studentFirstName;
		this.courseName = courseName;
		this.averageNote = averageNote;
		this.teacherLastName = teacherLastName;
		this.teacherFirstName = teacherFirstName;
	}

	@Column(name = "StudentLastName", length = 45)
	public String getStudentLastName() {
		return this.studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	@Column(name = "StudentFirstName", length = 45)
	public String getStudentFirstName() {
		return this.studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	@Column(name = "CourseName", length = 45)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "AverageNote", precision = 15)
	public BigDecimal getAverageNote() {
		return this.averageNote;
	}

	public void setAverageNote(BigDecimal averageNote) {
		this.averageNote = averageNote;
	}

	@Column(name = "TeacherLastName", length = 45)
	public String getTeacherLastName() {
		return this.teacherLastName;
	}

	public void setTeacherLastName(String teacherLastName) {
		this.teacherLastName = teacherLastName;
	}

	@Column(name = "TeacherFirstName", length = 45)
	public String getTeacherFirstName() {
		return this.teacherFirstName;
	}

	public void setTeacherFirstName(String teacherFirstName) {
		this.teacherFirstName = teacherFirstName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CriticsStudentsId))
			return false;
		CriticsStudentsId castOther = (CriticsStudentsId) other;

		return ((this.getStudentLastName() == castOther.getStudentLastName()) || (this
				.getStudentLastName() != null
				&& castOther.getStudentLastName() != null && this
				.getStudentLastName().equals(castOther.getStudentLastName())))
				&& ((this.getStudentFirstName() == castOther
						.getStudentFirstName()) || (this.getStudentFirstName() != null
						&& castOther.getStudentFirstName() != null && this
						.getStudentFirstName().equals(
								castOther.getStudentFirstName())))
				&& ((this.getCourseName() == castOther.getCourseName()) || (this
						.getCourseName() != null
						&& castOther.getCourseName() != null && this
						.getCourseName().equals(castOther.getCourseName())))
				&& ((this.getAverageNote() == castOther.getAverageNote()) || (this
						.getAverageNote() != null
						&& castOther.getAverageNote() != null && this
						.getAverageNote().equals(castOther.getAverageNote())))
				&& ((this.getTeacherLastName() == castOther
						.getTeacherLastName()) || (this.getTeacherLastName() != null
						&& castOther.getTeacherLastName() != null && this
						.getTeacherLastName().equals(
								castOther.getTeacherLastName())))
				&& ((this.getTeacherFirstName() == castOther
						.getTeacherFirstName()) || (this.getTeacherFirstName() != null
						&& castOther.getTeacherFirstName() != null && this
						.getTeacherFirstName().equals(
								castOther.getTeacherFirstName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStudentLastName() == null ? 0 : this.getStudentLastName()
						.hashCode());
		result = 37
				* result
				+ (getStudentFirstName() == null ? 0 : this
						.getStudentFirstName().hashCode());
		result = 37
				* result
				+ (getCourseName() == null ? 0 : this.getCourseName()
						.hashCode());
		result = 37
				* result
				+ (getAverageNote() == null ? 0 : this.getAverageNote()
						.hashCode());
		result = 37
				* result
				+ (getTeacherLastName() == null ? 0 : this.getTeacherLastName()
						.hashCode());
		result = 37
				* result
				+ (getTeacherFirstName() == null ? 0 : this
						.getTeacherFirstName().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tstudentLastName: %s\n\tstudentFirstName: %s\n\tcourseName: %s\n\taverageNote: %s\n\tteacherLastName: %s\n\tteacherFirstName: %s\n}",
						getClass().getName(), studentLastName,
						studentFirstName, courseName, averageNote,
						teacherLastName, teacherFirstName);
	}
	
	

}
