package com.school.sba.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.sba.entity.AcademicProgram;
import com.school.sba.entity.Schedule;
import com.school.sba.entity.School;
import java.util.*;

public interface SchoolRepositary extends JpaRepository<School, Integer>{

	 Schedule findScheduleBySchoolId(int schoolId);
//	 List<AcademicProgram> findAllAcademicProgramsBySchoolId(int schoolId);
	 
}
