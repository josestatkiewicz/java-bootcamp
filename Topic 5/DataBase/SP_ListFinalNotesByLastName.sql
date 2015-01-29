DELIMITER //
CREATE PROCEDURE ListFinalNotesByLastName(IN student varchar(45))
	BEGIN
		SELECT 	S.lastName StudentLastName, 
				S.firstName StudentFirstName, 
				C.name CourseName, 
				CFS.finalNote FinalNote
		FROM (Student S, CoursesForStudent CFS, Course C)
		WHERE 	((S.lastName = student) and 
				(C.idCourse = CFS.course) and 
				(S.idStudent = CFS.student))
		ORDER BY CFS.finalNote;
END //
DELIMITER ;