package org.oar.app.service;

import java.util.List;
import java.util.Optional;

import org.oar.app.bean.Attendence;
import org.oar.app.exception.NoAttendenceFoundException;
import org.oar.app.repo.AttendenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AttendenceServiceImpl implements AttendenceService {

	@Autowired
	private AttendenceRepo repo;
	
	
	@Override
	public List<Attendence> getAttendences() {
	return repo.findAll();
		
	}

	@Override
	public Attendence getAttendence(Integer id) {
	Optional<Attendence> findById = repo.findById(id);
	
	if(findById.isPresent())
	{
		System.out.println(findById.get());
	}
	
	return null;
	
	}

	@Override
	public void deleteAttendence(Integer id) {
	
		repo.deleteById(id);
		
	}

	@Override
	public boolean saveAttendence(Attendence attendence) {
		
		try
		{
		Attendence save = repo.save(attendence);
		System.out.println(save);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
		return false;
	}

	@Override
	public Attendence updateAttendence(Integer id) {
		try {
		Attendence attendence = repo.save(id);
		System.out.println(attendence);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
