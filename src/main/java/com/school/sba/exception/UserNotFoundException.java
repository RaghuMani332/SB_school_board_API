package com.school.sba.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {

	private String message;
}
