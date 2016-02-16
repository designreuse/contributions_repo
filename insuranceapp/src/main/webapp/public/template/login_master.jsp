<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="pt-BR">
<head>
        <title><spring:message  code="project.title" /></title>
        
          <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'  /> ">
	    <!-- Font Awesome -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css'  /> ">
	    <!-- Ionicons -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/ionicons.min.css'  /> ">
	    <!-- Theme style -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/AdminLTE.css'  /> ">
	    <!-- iCheck -->
	    <link rel="stylesheet" href="<c:url value='/resources/css/iCheck/square/blue.css'  /> ">
        <script src="<c:url value='/resources/js/lib/jQuery-2.1.4.min.js'  /> "></script>
	    <!-- iCheck -->
	    <script src="<c:url value='/resources/js/lib/icheck.min.js'/>"></script>
    </head>
    <body class="hold-transition login-page">
       

            <tiles:insertAttribute name="body" />
   


        <!--[if IE]>
            <script src="<c:url value='/resources/js/bootstrap.min.ie.js' />"></script>
        <![endif]-->
        <!--[if !IE]><!-->
            <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <!--<![endif]-->

    </body>
</html>