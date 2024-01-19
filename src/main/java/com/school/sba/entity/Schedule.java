package com.school.sba.entity;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scheduleId;
	private LocalTime opensAt;
	private LocalTime closesAt;
	private int classHoursPerDay;
	private Duration classHourLength;
	private LocalTime breakTime;
	private Duration breakLength;
	private LocalTime lunchTime;
	private Duration lunchLength;
	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", opensAt=" + opensAt + ", closesAt=" + closesAt
				+ ", classHoursPerDay=" + classHoursPerDay + ", classHourLength=" + classHourLength + ", breakTime="
				+ breakTime + ", breakLength=" + breakLength + ", lunchTime=" + lunchTime + ", lunchLength="
				+ lunchLength + "]";
	}
	
	
	
	
}
