package ar.com.ignacioflores.highSchool.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.ignacioflores.highSchool.dao.CriticsStudentsDAO;
import ar.com.ignacioflores.highSchool.model.CriticsStudents;

@Service
public class CriticsStudentsServiceImpl implements CriticsStudentsService, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private CriticsStudentsDAO criticsCriticsStudentssDAO;

	public void setCriticsStudentsDAO(CriticsStudentsDAO criticsCriticsStudentssDAO) {
		this.criticsCriticsStudentssDAO = criticsCriticsStudentssDAO;
	}	

	@Override
	@Transactional
	public List<CriticsStudents> listCriticsStudentss() {
		return this.criticsCriticsStudentssDAO.listCriticsStudentss();
	}

	@Override
	@Transactional
	public CriticsStudents getCriticsStudentsById(int id) {
		return this.criticsCriticsStudentssDAO.getCriticsStudentsById(id);
	}
}
