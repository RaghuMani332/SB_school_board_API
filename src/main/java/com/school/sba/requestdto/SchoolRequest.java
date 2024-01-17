package com.school.sba.requestdto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class SchoolRequest {

	private String schoolName;
	private long contactNo;
	private String emailId;
	private String address;
}
