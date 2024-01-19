package com.school.sba.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.AcademicProgram;
import com.school.sba.entity.School;
import com.school.sba.exception.SchoolNotFoundException;
import com.school.sba.repositary.AcademicProgramRepositary;
import com.school.sba.repositary.SchoolRepositary;
import com.school.sba.requestdto.AcademicProgramRequest;
import com.school.sba.responsedto.AcademicProgramResponse;
import com.school.sba.service.AcademicProgramService;
import com.school.sba.util.ResponseStructure;

@Service
public class AcademicProgramServiceImpl implements AcademicProgramService{

	@Autowired
	private SchoolRepositary schoolRepo;
	
	@Autowired
	private AcademicProgramRepositary academicRepo;
	
	@Autowired
	private ResponseStructure<AcademicProgramResponse> responce;
	
	@Override
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addProgram(int id,AcademicProgramRequest program) {
		School school = schoolRepo.findById(id).orElseThrow(()->new SchoolNotFoundException("School Not Found In Data Base"));
		System.out.println(school+"/////////////////////////");
		AcademicProgram academicProgram = academicRepo.save(mapToEntity(program,school));
		school.getAcademicPrograms().add(academicProgram);
		
		System.out.println("savedddddd"+schoolRepo.save(school));
		responce.setMessage("SAVED SUCCESSFULLY");
		responce.setStatus(HttpStatus.CREATED.value());
		responce.setData(mapToResponce(academicProgram));
		return new ResponseEntity<ResponseStructure<AcademicProgramResponse>>(responce,HttpStatus.CREATED);
	}

	public AcademicProgramResponse mapToResponce(AcademicProgram academicProgram) {
		// TODO Auto-generated method stub
		return AcademicProgramResponse.builder()
		.programBeginsAt(academicProgram.getProgramBeginsAt())
		.programEndsAt(academicProgram.getProgramEndsAt())
		.programName(academicProgram.getProgramName())
		.programType(academicProgram.getProgramType())
		.build();
	}

	private AcademicProgram mapToEntity(AcademicProgramRequest program, School school) {
		return AcademicProgram.builder().programType(program.getProgramType())
		.programName(program.getProgramName())
		.programBeginsAt(program.getProgramBeginsAt())
		.programEndsAt(program.getProgramEndsAt())
		.school(school)
		.build();
	}

//	@Override
//	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> findAllProgram(int schoolId) {
//		// TODO Auto-generated method stub
//		
//		System.out.println(schoolRepo.findAllAcademicProgramsBySchoolId(schoolId));
//		return null;
//	}
	@Override
	public ResponseEntity<ResponseStructure<List<AcademicProgramResponse>>> findAllProgram(int schoolId) {
	    School school = schoolRepo.findById(schoolId)
	            .orElseThrow(() -> new SchoolNotFoundException("School Not Found In Database"));

	    List<AcademicProgram> academicPrograms = academicRepo.findAllBySchool(school);


	    System.out.println("HERE");
	    
	    ResponseStructure<List<AcademicProgramResponse>> responce= new ResponseStructure<>();

	    responce.setMessage("Found academic programs successfully");
	    responce.setStatus(HttpStatus.OK.value());
	    responce.setData(mapToResponce(academicPrograms));

	    return new ResponseEntity<>(responce, HttpStatus.OK);
	}

	private List<AcademicProgramResponse> mapToResponce(List<AcademicProgram> academicPrograms) {
		// TODO Auto-generated method stub
		ArrayList<AcademicProgramResponse> al = new ArrayList();
		for (AcademicProgram ap : academicPrograms) {
			
			al.add(mapToResponce(ap));
		}
		 
		return al;
	}


}
