<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>主页</title>
	<c:set var="basePath" value="${pageContext.request.contextPath}"/>
    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	           <%@ include file="header.jsp"%>
				<%@ include file="left.jsp"%>
	        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">关于系统</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-7" style="font-size:15px;">
                		<!-- <div style="color:#337AB7"></div> -->
                		本系统是一个简单的对公司内部一些相关信息进行管理的人力资源管理系统<br>
                	 	功能大体可分为：管理员、员工信息管理、部门管理、招聘管理、培训管理、薪资管理六个大模块。<br>
	                	<i class="fa fa-wrench fa-fw"></i>管理员模块:<br>&nbsp;&nbsp;&nbsp;该模块主要用于对管理员的信息进行管理;<br/>
	                	<i class="fa fa-table fa-fw"></i>员工信息管理模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对员工信息库,同时还可以对员工的职务进行管理;<br/>
	                	<i class="fa fa-bar-chart-o fa-fw"></i>部门管理模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对部门进行管理;<br/>
	                	<i class="fa fa-edit fa-fw"></i>招聘管理模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对公司的招聘信息进行管理;<br/>
                		<i class="fa fa-book fa-fw"></i>培训管理模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对公司的培训计划、培训时间以及人员等等进行管理;<br/>
	                	<i class="fa fa-stack-overflow fa-fw"></i>薪资管理模块:该模块分为两小模块<br>
			            &nbsp;&nbsp;&nbsp;  第一个小模块是对公司员工的奖惩信息进行管理，从而有助于对员工的薪资信息的管理;<br>
			            &nbsp;&nbsp;&nbsp;  第二个模块对员工薪酬信息进行管理。<br>
			            <i class="fa fa-files-o fa-fw"></i>其他:员工反馈信息<br>&nbsp;&nbsp;&nbsp;提供对员工反馈的部分错误信息的状态修改
                			
                	
                </div>
            </div>
            </div>
</div>
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
