package com.school.sba.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.School;
import com.school.sba.entity.User;
import com.school.sba.enumuration.UserRole;
import com.school.sba.exception.InvalidUserException;
import com.school.sba.exception.SchoolAlreadyPresentForTheAdminException;
import com.school.sba.exception.UserNotFoundException;
import com.school.sba.repositary.SchoolRepositary;
import com.school.sba.repositary.UserRepositary;
import com.school.sba.requestdto.SchoolRequest;
import com.school.sba.responsedto.SchoolResponce;
import com.school.sba.responsedto.UserResponse;
import com.school.sba.service.SchoolService;
import com.school.sba.util.ResponseStructure;

@Service
public class SchoolServiceImpl implements SchoolService{
	
	@Autowired
	private UserRepositary userRepo;
	@Autowired
	private SchoolRepositary schoolRepo;

	@Autowired
	private ResponseStructure<SchoolResponce> responceStructure;
	
	@Override
	public ResponseEntity<ResponseStructure<SchoolResponce>> createSchool(int userId, SchoolRequest schoolRequest) {
		 User admin = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException("no user found"));
		if(admin.getUserRole()!=UserRole.ADMIN) {
			throw new InvalidUserException("Only ADMIN can create the school");
		}
		if(admin.getSchool()!=null)
		{
			throw new SchoolAlreadyPresentForTheAdminException("SCHOOL ALREADY PRESENT");
		}
	
		School school = schoolRepo.save(mapToSchool(schoolRequest));
		admin.setSchool(school);
		userRepo.save(admin);
		responceStructure.setData(mapToResponce(school));
		responceStructure.setMessage("Successfully created");
		responceStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<>(responceStructure, HttpStatus.CREATED);
		
	}

	private SchoolResponce mapToResponce(School school) {
		return SchoolResponce.builder().address(school.getAddress()).
		contactNo(school.getContactNo()).
		emailId(school.getEmailId()).
		schoolName(school.getSchoolName()).build();
	}

	private School mapToSchool(SchoolRequest schoolRequest) {
		return School.builder().address(schoolRequest.getAddress()).
		contactNo(schoolRequest.getContactNo()).
		emailId(schoolRequest.getEmailId()).
		schoolName(schoolRequest.getSchoolName()).build();
	}
	



}
