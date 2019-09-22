package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public abstract String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
