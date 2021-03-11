package org.oar.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ATTENDENCE_DTLS")
public class Attendence {
	
	@Override
	public String toString() {
		return "Attendence [attendenceId=" + attendenceId + ", attendenceName=" + attendenceName + "]";
	}
	@Id
	@GeneratedValue
	@Column(name="ATTENDENCE_ID")
	private Integer attendenceId;
	@Column(name="ATTENDENCE_NAME")
	private String  attendenceName;
	public Integer getAttendenceId() {
		return attendenceId;
	}
	public Attendence(Integer attendenceId, String attendenceName) {
		super();
		this.attendenceId = attendenceId;
		this.attendenceName = attendenceName;
	}
	public void setAttendenceId(Integer attendenceId) {
		this.attendenceId = attendenceId;
	}
	public String getAttendenceName() {
		return attendenceName;
	}
	public void setAttendenceName(String attendenceName) {
		this.attendenceName = attendenceName;
	}

}
