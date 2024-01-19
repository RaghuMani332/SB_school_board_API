package com.school.sba.responsedto;

import java.time.LocalTime;

import com.school.sba.enumuration.ProgramType;
import com.school.sba.requestdto.AcademicProgramRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class AcademicProgramResponse {

	private String programName;
	private LocalTime programBeginsAt;
	private LocalTime programEndsAt;
	private ProgramType programType;
}
