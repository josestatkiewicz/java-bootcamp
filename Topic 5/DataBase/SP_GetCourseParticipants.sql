DELIMITER //
CREATE PROCEDURE GetCourseParticipants(IN course int)
	BEGIN
		SELECT 	S.lastName StudentLastName, 
				S.firstName StudentFirstName, 
				C.name CourseName, 
				T.lastName TeacherLastName, 
				T.firstName TeacherFirstName
		FROM (Student S, CoursesForStudent CFS, Course C, Teacher T)
		WHERE 	((S.idStudent = CFS.student) and 
				(CFS.course = course) and 
				(C.idCourse = course) and 
				(T.idTeacher = C.asignedTeacher))
		ORDER BY S.lastName;
END //
DELIMITER ;