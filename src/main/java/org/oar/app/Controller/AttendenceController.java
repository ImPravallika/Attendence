package org.oar.app.Controller;

import java.util.List;
import java.util.Optional;

import org.oar.app.bean.Attendence;
import org.oar.app.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AttendenceController {
	
	@Autowired
	private AttendenceService service;
	
	
	@GetMapping("/getting")
	public ResponseEntity<List<Attendence>> getAttendence()
	{
		List<Attendence> attendences = service.getAttendences();
		if(attendences.size()<=0)
		{
			System.out.println(attendences);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}

	@GetMapping("/get")
	public ResponseEntity<Attendence> getAttendence(@PathVariable("id") Integer id)
	{
		
		
		Attendence attendence = service.getAttendence(id);
		if(attendence==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		return ResponseEntity.of(Optional.of(attendence));
		
	}
	
	@PostMapping("/save")
	
	public ResponseEntity<Boolean> saveContact(@RequestBody Attendence attendence)
	{
		
		boolean saveAttendence = service.saveAttendence(attendence);
		
		if(saveAttendence)
		{
			return ResponseEntity.ok(saveAttendence);
			
		}
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@DeleteMapping("/delete")
	
	public ResponseEntity<Void> deleteAttendence(Integer id)
	{
	try
	{
	service.deleteAttendence(id);
	return ResponseEntity.status(HttpStatus.OK).build();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	
}
	
	@PutMapping("/update/{id}")
	
	
	public ResponseEntity<Attendence> updateAttendence(@PathVariable("id") Integer id)
	{
	
		try
		{
		Attendence updateAttendence = service.updateAttendence(id);
		
		

		return ResponseEntity.ok(updateAttendence);
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		
		
		
	}
	
	
	@ExceptionHandler(value=NullPointerException.class)
	
	public String HandleNullPointerException(Model model)
	{
	
		model.addAttribute("errMsg" ,"some problem occured");
		return "error";
	}
	
	
}

