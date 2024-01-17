package com.school.sba.responsedto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchoolResponce {
	private String schoolName;
	private long contactNo;
	private String emailId;
	private String address;
}
