package ar.com.ignacioflores.highSchool.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class TimeCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTimeCourse;
	private String scheduleDayOfWeek;
	private Date scheduleTimeFrom;
	private Date scheduleTimeTo;
	private Set<Course> courses = new HashSet<Course>(0);

	public TimeCourse() {
	}

	public TimeCourse(String scheduleDayOfWeek, Date scheduleTimeFrom,
			Date scheduleTimeTo) {
		this.scheduleDayOfWeek = scheduleDayOfWeek;
		this.scheduleTimeFrom = scheduleTimeFrom;
		this.scheduleTimeTo = scheduleTimeTo;
	}

	public TimeCourse(String scheduleDayOfWeek, Date scheduleTimeFrom,
			Date scheduleTimeTo, Set<Course> courses) {
		this.scheduleDayOfWeek = scheduleDayOfWeek;
		this.scheduleTimeFrom = scheduleTimeFrom;
		this.scheduleTimeTo = scheduleTimeTo;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTimeCourse", unique = true, nullable = false)
	public Integer getIdTimeCourse() {
		return this.idTimeCourse;
	}

	public void setIdTimeCourse(Integer idTimeCourse) {
		this.idTimeCourse = idTimeCourse;
	}

	@Column(name = "scheduleDayOfWeek", nullable = false, length = 9)
	public String getScheduleDayOfWeek() {
		return this.scheduleDayOfWeek;
	}

	public void setScheduleDayOfWeek(String scheduleDayOfWeek) {
		this.scheduleDayOfWeek = scheduleDayOfWeek;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "scheduleTimeFrom", nullable = false, length = 8)
	public Date getScheduleTimeFrom() {
		return this.scheduleTimeFrom;
	}

	public void setScheduleTimeFrom(Date scheduleTimeFrom) {
		this.scheduleTimeFrom = scheduleTimeFrom;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "scheduleTimeTo", nullable = false, length = 8)
	public Date getScheduleTimeTo() {
		return this.scheduleTimeTo;
	}

	public void setScheduleTimeTo(Date scheduleTimeTo) {
		this.scheduleTimeTo = scheduleTimeTo;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TimeCourseForCourse", catalog = "high-school", joinColumns = { @JoinColumn(name = "timeCourse", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "course", nullable = false, updatable = false) })
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return String
				.format("%s {\n\tidTimeCourse: %s\n\tscheduleDayOfWeek: %s\n\tscheduleTimeFrom: %s\n\tscheduleTimeTo: %s\n\tcourses: %s\n}",
						getClass().getName(), idTimeCourse, scheduleDayOfWeek,
						scheduleTimeFrom, scheduleTimeTo, courses);
	}

}
