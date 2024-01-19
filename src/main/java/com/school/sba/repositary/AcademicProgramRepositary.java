package com.school.sba.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.sba.entity.AcademicProgram;
import com.school.sba.entity.School;

public interface AcademicProgramRepositary extends JpaRepository<AcademicProgram, Integer> {

//	List<AcademicProgram> findAllBySchool(School school);

	List<AcademicProgram> findAllBySchool(School school);

}
