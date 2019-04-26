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
	           <%@ include file="header_employee.jsp"%>
				<%@ include file="left_employee.jsp"%>
	        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">关于系统</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-7" style="font-size:15px;color::#337AB7">
                		本系统是一个简单的员工进行相关个人信息管理和查看一些公司内部信息的管理系统<br>
                	 	功能大体可分为：个人信息查看与修改、其他员工信息查看、招聘信息查看、培训信息查看、薪资信息查看五个大模块。<br>
	                	<i class="fa fa-wrench fa-fw"></i>个人信息查看与修改模块:<br>&nbsp;&nbsp;&nbsp;该模块主要用于对个人的信息进行查看与修改;<br/>
	                	<i class="fa fa-table fa-fw"></i>其他员工信息查看模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对公司其他员工简单的信息进行查看;<br/>
	                	<i class="fa fa-edit fa-fw"></i>招聘信息查看模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对公司的招聘信息进行查看;<br/>
                		<i class="fa fa-book fa-fw"></i>培训信息查看模块:<br>&nbsp;&nbsp;&nbsp;该模块主要对近期公司的培训计划、培训时间以及人员等等进行查看;<br/>
	                	<i class="fa fa-stack-overflow fa-fw"></i>薪资信息查看模块:<br>
			            &nbsp;&nbsp;&nbsp;  该模块对个人薪酬信息,同时对奖惩情况进行查看。<br>
			            <i class="fa fa-files-o fa-fw"></i>其他:信息反馈<br>&nbsp;&nbsp;&nbsp;该模块提供员工对自己薪资信息错误向管理员提出修改等反馈信息，
                			
                	
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
