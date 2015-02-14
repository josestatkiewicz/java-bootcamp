package ar.com.ignacioflores.highSchool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.com.ignacioflores.highSchool.model.Course;
import ar.com.ignacioflores.highSchool.model.Student;
import ar.com.ignacioflores.highSchool.model.Teacher;
import ar.com.ignacioflores.highSchool.service.CourseService;
import ar.com.ignacioflores.highSchool.service.CriticsStudentsService;
import ar.com.ignacioflores.highSchool.service.StudentService;
import ar.com.ignacioflores.highSchool.service.TeacherService;
import ar.com.ignacioflores.highSchool.service.TimeCourseService;

@Controller
public class HighSchoolController {
	
	private CourseService courseService;
	private StudentService studentService;
	private TeacherService teacherService;
	private TimeCourseService timeCourseService;
	
	@Autowired(required=true)
	@Qualifier(value="courseService")
	public void setCourseService(CourseService courseService){
		this.courseService = courseService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="criticsStudentsService")
	public void setCriticsStudentsService(CriticsStudentsService criticsStudentsService){
	}
	
	@Autowired(required=true)
	@Qualifier(value="studentService")
	public void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="teacherService")
	public void setTeacherService(TeacherService teacherService){
		this.teacherService = teacherService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="timeCourseService")
	public void setTimeCourseService(TimeCourseService timeCourseService){
		this.timeCourseService = timeCourseService;
	}
	
	@RequestMapping(value= "/utstudents/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody void addStudent(@ModelAttribute("user")Student student) {
		this.studentService.addStudent(student);	
	}
	
	@RequestMapping(value= "/teachers/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody void addTeacher(@ModelAttribute("teacher")Teacher teacher) {
		this.teacherService.addTeacher(teacher);	
	}
	
	@RequestMapping(value= "/courses/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public @ResponseBody void addCourse(@ModelAttribute("course")Course course) {
		this.courseService.addCourse(course);	
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public @ResponseBody String listStudents() {
		return this.studentService.listStudents().toString();
	}
	
	@RequestMapping(value = "/timeCourses", method = RequestMethod.GET)
	public @ResponseBody String listTimeCourses() {
		return this.timeCourseService.listTimeCourses().toString();
	}
	
	@RequestMapping(value = "/timeCourses/{id}", method = RequestMethod.GET)
	public @ResponseBody String getTimeCourses(@PathVariable("id") int id) {
		return this.timeCourseService.getTimeCourseById(id).toString();
	}
	
	@RequestMapping(value="/students/{id}", method= RequestMethod.GET)
	public @ResponseBody String getStudent(@PathVariable("id") int id) {
		Student studentRes = studentService.getStudentById(id);
		return studentRes.toString();
	}
	
	@RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){
		
        this.studentService.removeStudent(id);
        return "redirect:/students";
    }
 
    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentService.getStudentById(id));
        model.addAttribute("listStudents", this.studentService.listStudents());
        return "student";
    }
	
}
