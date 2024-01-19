package com.school.sba.entity;

import org.springframework.stereotype.Component;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@Component
@AllArgsConstructor
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schoolId;
	private String schoolName;
	private long contactNo;
	private String emailId;
	private String address;
	
	@OneToOne
	private Schedule schedule;
	
	@OneToMany(mappedBy = "school")
	private List<AcademicProgram> academicPrograms=new ArrayList<>();

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", contactNo=" + contactNo + ", emailId="
				+ emailId + ", address=" + address + ", schedule=" + schedule + "]";
	}
	
	
}
