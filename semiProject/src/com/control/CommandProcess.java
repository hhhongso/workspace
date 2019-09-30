package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface CommandProcess {
	public abstract String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
//	public abstract String checkRemember(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Throwable; 
}
