package com.nkb.calci;

public class DivException extends Exception {
	private String detail;
	DivException(String a) {
		detail=a;
	}
	public String toString() {
		return detail;
	}
}
