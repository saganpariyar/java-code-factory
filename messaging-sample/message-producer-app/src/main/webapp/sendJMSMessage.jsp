<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>

<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%@ page import="sample.domain.TradeRequest"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		
		<title>Send JMS Message</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


	</head>
	<%
		//final String quantityString = request.getParameter("quantity");
		//final long quantity = Long.getLong(quantityString).longValue();
		try {

			 // Get the spring context and the service beans
			ServletContext servletContext =this.getServletContext();		
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
			final sample.JMSMessageProducer messageProducer = (sample.JMSMessageProducer) wac.getBean(sample.JMSMessageProducer.class);
			out.println("messageProducer is " + messageProducer + " \n" + " about to send JMS message at " + Calendar.getInstance().getTime().toString());
			
			TradeRequest tradeRequest = new TradeRequest();
			messageProducer.persistAndSendMessage(tradeRequest);
			
			out.println("Done sending tradeRequest \n" + tradeRequest);
		
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
	
	%>
	<body>
	 <%
	 	out.println("done");
	  %>
		<br>
	</body>
</html>