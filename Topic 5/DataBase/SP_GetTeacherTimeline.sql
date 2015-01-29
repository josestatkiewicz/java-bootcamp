DELIMITER //
CREATE PROCEDURE GetTeacherTimeline(IN teacher int)
	BEGIN
		SELECT	T.lastName TeacherLastName, 
				T.firstName TeacherFirstName, 
				C.name CourseName, 
				TC.scheduleDayOfWeek TimeCourseDayOfWeek, 
				scheduleTimeFrom TimeCourseTimeFrom, 
				scheduleTimeTo TimeCourseTimeTo
		FROM (Teacher T, Course C, TimeCourse TC, TimeCourseForCourse TCFC)
		WHERE ( (T.idTeacher = teacher) and
				(C.asignedTeacher = teacher) and 
				(TCFC.course = C.idCourse) and
				(TC.idTimeCourse = TCFC.timeCourse))
		ORDER BY FIELD(TimeCourseDayOfWeek, 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY');
	END //
DELIMITER ;