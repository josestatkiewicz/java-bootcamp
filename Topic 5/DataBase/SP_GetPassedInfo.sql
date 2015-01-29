DELIMITER //
CREATE PROCEDURE GetPassedInfo(IN course int)
	BEGIN
		SELECT 	CourseName.CourseName,
				round(((C2.Failed / C1.Total)*100), 1) FailedPorcent, 
				round((((C1.Total - C2.Failed) / C1.Total) * 100), 1) PassedPorcent
		FROM(	(SELECT count(*) Total
				FROM CoursesForStudent CFS1
				WHERE (CFS1.course = course)) C1,
				(SELECT count(*) Failed
				FROM CoursesForStudent CFS2
				WHERE ((CFS2.course = course) and (CFS2.finalNote < 4))) C2),
				(SELECT C.name CourseName
				FROM Course C
				WHERE (C.idCourse = course)) CourseName;
		END //
DELIMITER ;