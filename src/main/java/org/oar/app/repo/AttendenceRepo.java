package org.oar.app.repo;

import org.oar.app.bean.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepo  extends JpaRepository<Attendence , Integer>{

	Attendence save(Integer id);

}
