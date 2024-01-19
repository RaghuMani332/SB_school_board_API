package com.school.sba.responsedto;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponce {

//	private LocalTime opensAt;
//	private LocalTime closesAt;
//	private int classHoursPerDay;
//	private Duration classHourLength;
//	private LocalTime breakTime;
//	private Duration breakLength;
//	private LocalTime lunchTime;
//	private Duration lunchLength;
	
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private int classHourLengthInMinutes;
	private LocalTime breakTime;
	private int breakLengthInMinutes;
	private LocalTime lunchTime;
	private int lunchLengthInMinutes;
	@Override
	public String toString() {
		return "ScheduleResponce [opensAt=" + opensAt + ", closesAt=" + closesAt + ", classHoursPerDay="
				+ classHoursPerDay + ", classHourLengthInMinutes=" + classHourLengthInMinutes + ", breakTime="
				+ breakTime + ", breakLengthInMinutes=" + breakLengthInMinutes + ", lunchTime=" + lunchTime
				+ ", lunchLengthInMinutes=" + lunchLengthInMinutes + "]";
	}
	
	
}
