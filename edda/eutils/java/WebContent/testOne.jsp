<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="org.json.simple.JSONValue"%>
<%
	for (Enumeration<String> parameterNameEnumeration = request.getParameterNames(); parameterNameEnumeration.hasMoreElements();) {
	   System.out.println("Parameter Name: " + parameterNameEnumeration.nextElement());	   
	}
    String jsonStringParameter = request.getParameter("jsonData");
   if (jsonStringParameter != null) {
	   JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonStringParameter);
	   System.out.println("Parameter = " + jsonObject);
   }
%>

