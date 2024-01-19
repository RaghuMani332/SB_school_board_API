package com.school.sba.requestdto;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.school.sba.enumuration.ProgramType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AcademicProgramRequest {
	private String programName;
	private LocalTime programBeginsAt;
	private LocalTime programEndsAt;
	private ProgramType programType;

}
