package com.school.sba.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.sba.requestdto.AcademicProgramRequest;
import com.school.sba.responsedto.AcademicProgramResponse;
import com.school.sba.util.ResponseStructure;

public interface AcademicProgramService {

	ResponseEntity<ResponseStructure<AcademicProgramResponse>> addProgram(int id, AcademicProgramRequest program);

//	ResponseEntity<ResponseStructure<AcademicProgramResponse>> findAllProgram(int schoolId);
	ResponseEntity<ResponseStructure<List<AcademicProgramResponse>>> findAllProgram(int schoolId);

}
