package com.school.sba.serviceimpl;

import java.time.Duration;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.Schedule;
import com.school.sba.entity.School;
import com.school.sba.exception.ScheduleIsPresent;
import com.school.sba.exception.ScheduleNotFoundById;
import com.school.sba.exception.ScheduleNotFoundExcepttion;
import com.school.sba.exception.SchoolNotFoundException;
import com.school.sba.repositary.ScheduleRepositary;
import com.school.sba.repositary.SchoolRepositary;
import com.school.sba.requestdto.ScheduleRequest;
import com.school.sba.responsedto.ScheduleResponce;
import com.school.sba.service.ScheduleService;
import com.school.sba.util.ResponseStructure;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private SchoolRepositary schoolRepo;

	@Autowired
	private ResponseStructure<ScheduleResponce> responceStructure;
	
	@Autowired
	private ScheduleRepositary scheduleRepo;

	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponce>> createSchedule(ScheduleRequest scheduleRequest,int id) {
		
		School school = schoolRepo.findById(id).orElseThrow(()->new SchoolNotFoundException("create a schoolfirst"));
			if(school.getSchedule()==null)
			{
				Schedule schedule = scheduleRepo.save(mapToSchedule(scheduleRequest));
				school.setSchedule(schedule);
				school=schoolRepo.save(school);
				responceStructure.setData(mapToResponce(schedule));
				responceStructure.setMessage("Schedule Createdhh SucessFully");
				responceStructure.setStatus(HttpStatus.CREATED.value());
			}
			else
			{
				throw new ScheduleIsPresent("Schedule is already present for the school");
			}
			System.out.println(responceStructure+"___________________________________");
			return new ResponseEntity<ResponseStructure<ScheduleResponce>>(responceStructure,HttpStatus.CREATED);
	}
	
	
//	@Override //chat gpt code
//	public ResponseEntity<ResponseStructure<ScheduleResponce>> createSchedule(ScheduleRequest scheduleRequest, int id) {
//	    try {
//	        School school = schoolRepo.findById(id).orElseThrow(() -> new SchoolNotFoundException("Create a school first"));
//	        
//	        if (school.getSchedule() == null) {
//	            Schedule schedule = scheduleRepo.save(mapToSchedule(scheduleRequest));
//	            school.setSchedule(schedule);
//	            school = schoolRepo.save(school);
//	            
//	            ScheduleResponce response = mapToResponce(schedule);
//	            
//	            responceStructure.setData(response);
//	            responceStructure.setMessage("Schedule Created Successfully");
//	            responceStructure.setStatus(HttpStatus.CREATED.value());
//	            
//	            System.out.println(responceStructure + "___________________________________");
//	            
//	            return new ResponseEntity<>(responceStructure, HttpStatus.CREATED);
//	        } else {
//	            throw new ScheduleIsPresent("Schedule is already present for the school");
//	        }
//	    } catch (Exception e) {
//	        // Handle exceptions and log them
//	        e.printStackTrace(); // Replace with proper logging
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}


	private ScheduleResponce mapToResponce(Schedule save) {
		return ScheduleResponce.builder()
				.opensAt(save.getOpensAt())
				.closesAt(save.getClosesAt())
				.classHourLengthInMinutes((int)save.getClassHourLength().toMinutes())
				.classHoursPerDay(save.getClassHoursPerDay())
				.breakTime(save.getBreakTime())
				.breakLengthInMinutes((int)save.getBreakLength().toMinutes())
				.lunchTime(save.getLunchTime())
				.lunchLengthInMinutes((int)save.getLunchLength().toMinutes())
				.build();
	}

	private Schedule mapToSchedule(ScheduleRequest scheduleRequest) {
		return Schedule.builder()
		.opensAt(scheduleRequest.getOpensAt())
		.closesAt(scheduleRequest.getClosesAt())
		.classHourLength( Duration.ofSeconds(scheduleRequest.getClassHourLengthInMinutes()*60))
		.classHoursPerDay(scheduleRequest.getClassHoursPerDay())
		.breakTime(scheduleRequest.getBreakTime())
		.breakLength(Duration.ofSeconds(scheduleRequest.getBreakLengthInMinutes()*60))
		.lunchTime(scheduleRequest.getLunchTime())
		.lunchLength(Duration.ofSeconds(scheduleRequest.getLunchLengthInMinutes()*60))
		.build();
		
	}


	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponce>> findScheduleBySchool(int schoolId) {
		// TODO Auto-generated method stub
		School school=schoolRepo.findById(schoolId).orElseThrow(()->new SchoolNotFoundException("School Not Found With this ID"));
//		Schedule schedule=scheduleRepo.findById(school.getSchedule()).orElseThrow(()->new ScheduleNotFoundExcepttion("No schedule found"));
		 Schedule schedule=school.getSchedule();
		responceStructure.setData(mapToResponce(schedule));
		responceStructure.setMessage("THIS IS THEttt SCHEDULE");
		responceStructure.setStatus(HttpStatus.OK.value());
		System.err.println(responceStructure);
		System.out.println(school.getSchedule());
		return new ResponseEntity<ResponseStructure<ScheduleResponce>>(responceStructure,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseStructure<ScheduleResponce>> updateSchedule(int scheduleId, ScheduleRequest request) {
		Schedule schedule=scheduleRepo.findById(scheduleId).orElseThrow(()-> new ScheduleNotFoundById("Can't find any schedule in the given ID"));
	    if (Objects.nonNull(request.getOpensAt())) {
	        schedule.setOpensAt(request.getOpensAt());
	    }
	    if (Objects.nonNull(request.getClosesAt())) {
	        schedule.setClosesAt(request.getClosesAt());
	    }
	    if (Objects.nonNull(request.getBreakTime())) {
	        schedule.setBreakTime(request.getBreakTime());
	    }
	    if (Objects.nonNull(request.getBreakLengthInMinutes())) {
	        schedule.setBreakLength(Duration.ofMinutes(request.getBreakLengthInMinutes()));
	    }
	    if (Objects.nonNull(request.getClassHoursPerDay())) {
	        schedule.setClassHoursPerDay(request.getClassHoursPerDay());
	    }
	    if (Objects.nonNull(request.getClassHourLengthInMinutes())) {
	        schedule.setClassHourLength(Duration.ofMinutes(request.getClassHourLengthInMinutes()));
	    } else {
	        schedule.setClassHourLength(null);
	    }
	    if (Objects.nonNull(request.getLunchTime())) {
	        schedule.setLunchTime(request.getLunchTime());
	    }
	    if (Objects.nonNull(request.getLunchLengthInMinutes())) {
	        schedule.setLunchLength(Duration.ofMinutes(request.getLunchLengthInMinutes()));
	    } else {
	        schedule.setLunchLength(null);
	    }
		scheduleRepo.save(schedule);
		responceStructure.setStatus(HttpStatus.ACCEPTED.value());
		responceStructure.setMessage("Schedule updated");
		responceStructure.setData(mapToResponce(schedule));
		return new ResponseEntity<ResponseStructure<ScheduleResponce>>(responceStructure,HttpStatus.ACCEPTED);
	}

}
