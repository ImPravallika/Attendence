package org.oar.app.service;

import java.util.List;

import org.oar.app.bean.Attendence;

public interface AttendenceService {
	
	public List<Attendence> getAttendences();
	
	public Attendence getAttendence(Integer id);
	
	public void deleteAttendence(Integer id);
	
	public boolean saveAttendence(Attendence attendence);
	
	public Attendence updateAttendence(Integer id);
	

}
