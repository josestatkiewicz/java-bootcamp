package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class CoursesForStudent implements Serializable {

	private static final long serialVersionUID = 1L;

	private CoursesForStudentId id;
	private Course course;
	private Student student;
	private Integer partialNote1;
	private Integer partialNote2;
	private Integer partialNote3;
	private Integer finalNote;

	public CoursesForStudent() {
	}

	public CoursesForStudent(CoursesForStudentId id, Course course, Student student) {
		this.id = id;
		this.course = course;
		this.student = student;
	}

	public CoursesForStudent(	CoursesForStudentId id, Course course, Student student, Integer partialNote1, 
								Integer partialNote2, Integer partialNote3, Integer finalNote) {
		this.id = id;
		this.course = course;
		this.student = student;
		this.partialNote1 = partialNote1;
		this.partialNote2 = partialNote2;
		this.partialNote3 = partialNote3;
		this.finalNote = finalNote;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "student", column = @Column(name = "student", nullable = false)),
			@AttributeOverride(name = "course", column = @Column(name = "course", nullable = false)) })
	public CoursesForStudentId getId() {
		return this.id;
	}

	public void setId(CoursesForStudentId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "partialNote1")
	public Integer getPartialNote1() {
		return this.partialNote1;
	}

	public void setPartialNote1(Integer partialNote1) {
		this.partialNote1 = partialNote1;
	}

	@Column(name = "partialNote2")
	public Integer getPartialNote2() {
		return this.partialNote2;
	}

	public void setPartialNote2(Integer partialNote2) {
		this.partialNote2 = partialNote2;
	}

	@Column(name = "partialNote3")
	public Integer getPartialNote3() {
		return this.partialNote3;
	}

	public void setPartialNote3(Integer partialNote3) {
		this.partialNote3 = partialNote3;
	}

	@Column(name = "finalNote")
	public Integer getFinalNote() {
		return this.finalNote;
	}

	public void setFinalNote(Integer finalNote) {
		this.finalNote = finalNote;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tid: %s\n\tcourse: %s\n\tstudent: %s\n\tpartialNote1: %s\n\tpartialNote2: %s\n\tpartialNote3: %s\n\tfinalNote: %s\n}",
						getClass().getName(), id, course, student,
						partialNote1, partialNote2, partialNote3, finalNote);
	}
	
	

}
