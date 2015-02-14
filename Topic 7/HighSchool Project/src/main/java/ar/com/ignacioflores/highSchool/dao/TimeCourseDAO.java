package ar.com.ignacioflores.highSchool.dao;

import java.util.List;

import ar.com.ignacioflores.highSchool.model.TimeCourse;

public interface TimeCourseDAO {

	public void addTimeCourse(TimeCourse timeCourse);
    public void updateTimeCourse(TimeCourse timeCourse);
    public List<TimeCourse> listTimeCourses();
    public TimeCourse getTimeCourseById(int timeCourseId);
    public void removeTimeCourse(int timeCourseId);
}
