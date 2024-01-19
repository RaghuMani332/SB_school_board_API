package com.school.sba.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.Subject;
import com.school.sba.exception.AcademicProgramNotFound;
import com.school.sba.repositary.AcademicProgramRepositary;
import com.school.sba.repositary.SubjectRepositary;
import com.school.sba.requestdto.SubjectRequest;
import com.school.sba.responsedto.AcademicProgramResponse;
import com.school.sba.responsedto.SchoolResponce;
import com.school.sba.responsedto.SubjectResponce;
import com.school.sba.service.SubjectService;
import com.school.sba.util.ResponseStructure;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepositary subjectRepo;

	@Autowired
	private AcademicProgramRepositary academicProgramRepo;

	@Autowired
	private ResponseStructure<AcademicProgramResponse> structure;

	@Autowired
	private AcademicProgramServiceImpl academicProgramServiceImpl;

	@Override
	public ResponseEntity<ResponseStructure<AcademicProgramResponse>> addSubject(SubjectRequest subjectRequest,
			int programId) {

		return academicProgramRepo.findById(programId).map(program -> {
			List<Subject> subjects = new ArrayList<Subject>();
			subjectRequest.getSubjects().forEach(name -> {

				subjects.add(subjectRepo.findBySubjectName(name).orElseGet(() -> subjectRepo.save(Subject.builder().subjectName(name).build())));

			});
			program.setSubjects(subjects);
			academicProgramRepo.save(program);
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Updated the Subject list to Academic Program");
			structure.setData(academicProgramServiceImpl.mapToResponce(program));
			return new ResponseEntity<ResponseStructure<AcademicProgramResponse>>(structure, HttpStatus.CREATED);

		}).orElseThrow(() -> new AcademicProgramNotFound("Academic program Not found for given id"));

	}
	 @Override
	    public ResponseEntity<ResponseStructure<AcademicProgramResponse>> updateSubject(SubjectRequest subjectRequest,int programId) {
		 	
		 return	academicProgramRepo.findById(programId).map(program->{
		 		program.getSubjects().clear();
		 		academicProgramRepo.save(program);
		 		return addSubject(subjectRequest, programId);
		 	}).orElseThrow(()->new AcademicProgramNotFound("Academic program not found for the id"));
		 
		 
//		 return null;
//	        return academicProgramRepo.findById(programId).map(program -> {
//	            subjectRequest.getSubjects().forEach(name -> {
//	                if (program.getSubjects().stream().noneMatch(subject -> subject.getSubjectName().equals(name))) {
//	                    // Subject is not associated, check if it exists in the database
//	                    Subject subject = subjectRepo.findBySubjectName(name)
//	                            .orElseGet(() -> subjectRepo.save(Subject.builder().subjectName(name).build()));
//
//	                    // Update the subject list of the Academic Program
//	                    program.getSubjects().add(subject);
//	                }
//	                // Subject is already associated, no action needed
//	            });
//
//	            // Save the updated Academic Program
//	            academicProgramRepo.save(program);
//
//	            structure.setStatus(HttpStatus.OK.value());
//	            structure.setMessage("Subjects updated successfully.");
//	            structure.setData(academicProgramServiceImpl.mapToResponce(program));
//	            return new ResponseEntity<ResponseStructure<AcademicProgramResponse>>(structure, HttpStatus.OK);
//
//	        }).orElseThrow(() -> new AcademicProgramNotFound("Academic program Not found for given id"));
	    }

}
