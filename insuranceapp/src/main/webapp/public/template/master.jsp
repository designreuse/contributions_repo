<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
 
  <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
  <title><spring:message  code="project.title" /></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width">        
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.5 -->
         <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' /> ">
	    <!-- Font Awesome -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' /> ">
	    <!-- Ionicons -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/ionicons.min.css' /> ">
	    <!-- Theme style -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/AdminLTE.css' /> ">
	    
	    <link rel="stylesheet" href="<c:url value='/resources/css/skins/_all-skins.min.css' /> ">
	    <!-- iCheck -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/iCheck/flat/blue.css' /> ">
	    
	    <!-- File Input css -->
        <link href="<c:url value='/resources/css/fileinput.min.css' /> " rel="stylesheet"/>
        
        <!-- Jquery UI Css -->
        <link href="<c:url value='/resources/css/jquery-ui-1.10.4.custom.min.css' /> " rel="stylesheet"/>
        
	   <script src="<c:url value='/resources/js/lib/jQuery-2.1.4.min.js' /> "></script>
	   <script src="<c:url value='/resources/js/lib/jquery-ui-1.10.4.custom.min.js' /> "></script>
	   <script src="<c:url value='/resources/js/lib/bootstrap.min.js' /> "></script>
	   
	   <script src="<c:url value='/resources/js/lib/jquery.spring-friendly.js' />  "></script>
	  
	  <script src="<c:url value='/resources/js/lib/jquery.ui.datepicker.js' /> "></script>
	  <script src="<c:url value='/resources/js/lib/fileinput.min.js' /> "></script>
	  
	  <script src="<c:url value='/resources/js/lib/app.min.js' /> "></script>
	  
	  <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables.bootstrap.min.css' />">
	  <script type="text/javascript" src="<c:url value='/resources/js/lib/jquery.dataTables.min.js' /> "></script>
	  
	  <script type="text/javascript" src="<c:url value='/resources/js/lib/dataTables.bootstrap.min.js' /> "></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">

      <div class="wrapper">
         <tiles:insertAttribute name="header" />
         <tiles:insertAttribute name="menu" />
         
           <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            <tiles:getAsString name="title"/>
          </h1>
          
        </section>

        <!-- Main content -->
        <section class="content">
            <tiles:insertAttribute name="body" />
        </section>
        </div>
      </div>
</body>
</html>