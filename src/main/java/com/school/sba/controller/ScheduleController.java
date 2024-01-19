package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.requestdto.ScheduleRequest;
import com.school.sba.responsedto.ScheduleResponce;
import com.school.sba.service.ScheduleService;
import com.school.sba.util.ResponseStructure;

@RestController
public class ScheduleController {

	@Autowired
	private ScheduleService service;
	
//	@PostMapping("/schools/{schoolId}/schedules")
//	public ResponseEntity<ResponseStructure<ScheduleResponce>> addSchedule(@RequestBody ScheduleRequest request,@PathVariable int schoolId)
//	{
//		System.out.println("responce");
//		return service.createSchedule(request, schoolId);
//	}
	@PostMapping("/schools/{schoolId}/schedules")//cha gpt
	public ResponseEntity<ResponseStructure<ScheduleResponce>> addSchedule(@RequestBody ScheduleRequest request, @PathVariable int schoolId) {
	    System.out.println("Received request for schoolId: " + schoolId);
	    System.out.println("Request body: " + request);

	    ResponseEntity<ResponseStructure<ScheduleResponce>> responseEntity = service.createSchedule(request, schoolId);

	    System.out.println("Response status code: " + responseEntity.getStatusCodeValue());
	    System.out.println("Response body: " + responseEntity.getBody());

	    return responseEntity;
	}
	@GetMapping("/schools/{schoolId}/schedules")
	public ResponseEntity<ResponseStructure<ScheduleResponce>> findSchedule(@PathVariable int schoolId){
		return service.findScheduleBySchool(schoolId);
	}
	@PutMapping("/schedules/{scheduleId}")
	public ResponseEntity<ResponseStructure<ScheduleResponce>> updateSchedule(@PathVariable int scheduleId,@RequestBody ScheduleRequest request){
		System.out.println("update schedule");
		return service.updateSchedule(scheduleId,request);
	}
}
