DELIMITER //
CREATE PROCEDURE ListFinalNotesByRegNumber(IN student int)
	BEGIN
		SELECT 	S.lastName StudentLastName, 
				S.firstName StudentFirstName, 
				C.name CourseName, 
				CFS.finalNote FinalNote
		FROM (Student S, CoursesForStudent CFS, Course C)
		WHERE 	((S.regNumber = student) and 
				(C.idCourse = CFS.course) and 
				(S.idStudent = CFS.student))
		ORDER BY CFS.finalNote;
END //
DELIMITER ;