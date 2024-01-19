package com.school.sba.requestdto;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleRequest {
	
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private int classHourLengthInMinutes;
	private LocalTime breakTime;
	private int breakLengthInMinutes;
	private LocalTime lunchTime;
	private int lunchLengthInMinutes;
	
	
}
