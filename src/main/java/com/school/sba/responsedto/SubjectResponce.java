package com.school.sba.responsedto;

import java.util.List;

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
public class SubjectResponce {
	private List<String> subjects;
}
