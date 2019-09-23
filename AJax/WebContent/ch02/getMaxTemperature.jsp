<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
double[] maxTemp = {25.0, 22.8, 19.7, 31.5};

for(int i = 0; i < maxTemp.length; i++){
	out.print(maxTemp[i]);
	
	if(i < maxTemp.length - 1) {
		out.print(",");
	}
}
%>
