package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.requestdto.SchoolRequest;
import com.school.sba.responsedto.SchoolResponce;
import com.school.sba.util.ResponseStructure;


public interface SchoolService {
	
	ResponseEntity<ResponseStructure<SchoolResponce>> createSchool(int userId,SchoolRequest schoolRequest);
}
