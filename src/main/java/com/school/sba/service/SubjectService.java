package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.requestdto.SchoolRequest;
import com.school.sba.requestdto.SubjectRequest;
import com.school.sba.responsedto.AcademicProgramResponse;
import com.school.sba.responsedto.SchoolResponce;
import com.school.sba.responsedto.SubjectResponce;
import com.school.sba.util.ResponseStructure;

public interface SubjectService {
//	ResponseEntity<ResponseStructure<SubjectResponce>> addSubject(int programId,SubjectRequest subjectRequest);

	ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubject(SubjectRequest subjectRequest, int programId);
	ResponseEntity<ResponseStructure<AcademicProgramResponse>> updateSubject(SubjectRequest subjectRequest, int programId);
}
