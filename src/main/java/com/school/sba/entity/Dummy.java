package com.school.sba.entity;

import java.io.Console;
import java.time.LocalTime;
import java.time.ZoneId;

public class Dummy {
	public static void main(String[] args) {
		System.out.println(LocalTime.now());
		System.out.println(LocalTime.now(ZoneId.of("Asia/Kolkata")));
		System.out.println(LocalTime.of(23, 20));
		System.out.println(LocalTime.ofSecondOfDay(86399));
		var a=55;
		var b='1'-'0';
		int c=a+b;
		System.out.println(c);
	}
}
