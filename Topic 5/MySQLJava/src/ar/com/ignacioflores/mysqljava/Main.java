package ar.com.ignacioflores.mysqljava;

public class Main {

	public static void main(String[] args) throws Exception {
		MySQLAccess dao = new MySQLAccess();
//		dao.getCourseParticipants(2);
//		dao.listFinalNotes(36431);
//		dao.listFinalNotes("Sanchez");
//		dao.getPassedInfo(1);
//		dao.getTeacherTimeline(2);
//		dao.getCriticsStudent();
		dao.removeOldTeacher();
	}
}