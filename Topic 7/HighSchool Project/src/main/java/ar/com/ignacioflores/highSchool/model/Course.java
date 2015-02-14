package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idCourse;
	private Teacher teacher;
	private String name;
	private Float hoursByWeek;
	private Set<TimeCourse> timeCourses = new HashSet<TimeCourse>(0);
	private Set<CoursesForStudent> coursesForStudents = new HashSet<CoursesForStudent>(0);

	public Course() {
	}

	public Course(	Teacher teacher, String name, Float hoursByWeek, 
					Set<TimeCourse> timeCourses, Set<CoursesForStudent> coursesForStudents) {
		this.teacher = teacher;
		this.name = name;
		this.hoursByWeek = hoursByWeek;
		this.timeCourses = timeCourses;
		this.coursesForStudents = coursesForStudents;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCourse", unique = true, nullable = false)
	public Integer getIdCourse() {
		return this.idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asignedTeacher")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "hoursByWeek", precision = 12, scale = 0)
	public Float getHoursByWeek() {
		return this.hoursByWeek;
	}

	public void setHoursByWeek(Float hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TimeCourseForCourse", catalog = "high-school", joinColumns = { @JoinColumn(name = "course", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "timeCourse", nullable = false, updatable = false) })
	public Set<TimeCourse> getTimeCourses() {
		return this.timeCourses;
	}

	public void setTimeCourses(Set<TimeCourse> timeCourses) {
		this.timeCourses = timeCourses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	public Set<CoursesForStudent> getCoursesForStudents() {
		return this.coursesForStudents;
	}

	public void setCoursesForStudents(Set<CoursesForStudent> coursesForStudents) {
		this.coursesForStudents = coursesForStudents;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tidCourse: %s\n\tteacher: %s\n\tname: %s\n\thoursByWeek: %s\n}",
						getClass().getName(), idCourse, teacher, name,
						hoursByWeek);
	}
	
	
}
