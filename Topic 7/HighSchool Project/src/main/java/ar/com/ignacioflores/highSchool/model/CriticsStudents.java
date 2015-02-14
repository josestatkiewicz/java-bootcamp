package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CriticsStudents implements Serializable {

	private static final long serialVersionUID = 1L;

	private CriticsStudentsId id;

	public CriticsStudents() {
	}

	public CriticsStudents(CriticsStudentsId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "studentLastName", column = @Column(name = "StudentLastName", length = 45)),
			@AttributeOverride(name = "studentFirstName", column = @Column(name = "StudentFirstName", length = 45)),
			@AttributeOverride(name = "courseName", column = @Column(name = "CourseName", length = 45)),
			@AttributeOverride(name = "averageNote", column = @Column(name = "AverageNote", precision = 15)),
			@AttributeOverride(name = "teacherLastName", column = @Column(name = "TeacherLastName", length = 45)),
			@AttributeOverride(name = "teacherFirstName", column = @Column(name = "TeacherFirstName", length = 45)) })
	public CriticsStudentsId getId() {
		return this.id;
	}

	public void setId(CriticsStudentsId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%s {\n\tid: %s\n}", getClass().getName(), id);
	}

	
}
