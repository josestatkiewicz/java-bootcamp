DELIMITER //
CREATE PROCEDURE RemoveOldTeacher()
	BEGIN
		DELETE
		FROM Teacher
		WHERE (Teacher.idTeacher not in (SELECT distinct C.asignedTeacher FROM Course C));
END //
DELIMITER ;