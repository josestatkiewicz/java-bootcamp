CREATE VIEW CriticsStudents AS (
	SELECT 	S.lastName StudentLastName,
			S.firstName StudentFirstName,
			C.name CourseName,
			ROUND(((CFS.partialNote1 + CFS.partialNote2 + CFS.partialNote3) / 3), 2) AverageNote,
			T.lastName TeacherLastName,
			T.firstName TeacherFirstName
		
	FROM (Student S, CoursesForStudent CFS, Course C, Teacher T)
	WHERE (	(S.idStudent = CFS.student) and
			(C.idCourse = CFS.course) and
			(T.idTeacher = C.asignedTeacher) and
			((CFS.partialNote1 < 7) or (CFS.partialNote2 < 7) or (CFS.partialNote3 < 7)))
	ORDER BY StudentLastName ASC, StudentFirstName ASC 
) 