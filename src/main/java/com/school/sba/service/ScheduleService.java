package com.school.sba.service;

import org.springframework.http.ResponseEntity;

import com.school.sba.requestdto.ScheduleRequest;
import com.school.sba.requestdto.SchoolRequest;
import com.school.sba.responsedto.ScheduleResponce;
import com.school.sba.responsedto.SchoolResponce;
import com.school.sba.util.ResponseStructure;

public interface ScheduleService {
	ResponseEntity<ResponseStructure<ScheduleResponce>> createSchedule(ScheduleRequest scheduleRequest,int id);

	ResponseEntity<ResponseStructure<ScheduleResponce>> findScheduleBySchool(int schoolId);

	ResponseEntity<ResponseStructure<ScheduleResponce>> updateSchedule(int scheduleId, ScheduleRequest request);

}
