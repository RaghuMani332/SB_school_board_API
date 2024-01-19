package com.school.sba.requestdto;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
	private List<String> subjects;
}
