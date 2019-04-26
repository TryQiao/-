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
    <link href="/Hrms/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/Hrms/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/Hrms/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/Hrms/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/Hrms/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
        <form action="${basePath }/train/addTrain" method="post">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">添加培训信息</h1>
	                
	            </div>
	            <div class="form-inline" style="width:600px;padding-left:15px">
	                
	                <table class="table" id="dataTables-example">
	                <tr>
	                	<td>
		                <label>讲师:</label>
		                <input class="form-control" name="trainMan" placeholder="输入讲师" style="width:120px;text-align:center">
		                <label>主题:</label>
		                <input class="form-control" name="trainTitle" placeholder="输入培训主题不可重复" style="width:200px;text-align:center">
		                </td>
	                </tr>
	                <tr>
	                	<td>
		                <label>培训时间:</label>
		                <input class="form-control" name="trainTime" placeholder="输入培训时间" style="width:180px;text-align:center">
		                <label>培训地点:</label>
		                <input class="form-control" name="trainAddress" placeholder="输入培训地点" style="width:230px;text-align:center">
		                </td>
	                </tr>
	                <tr>
	                	<td>
		                <label>培训目的:</label>
		                <input class="form-control" name="trainAim" placeholder="输入培训目的" style="width:280px;text-align:center">
		                </td>
		            </tr>
	                <tr>
	                	<td>
		                <label>培训人员:</label>
		                <input class="form-control" name="trainJoin" placeholder="输入参加培训人员" style="width:280px;text-align:center">
		                </td>
		            </tr>
		            <tr>
	                	<td>
	                	<input type="submit" class="btn btn-danger" value="添加"></input>
		             	<a href="${basePath }/train/listTrain"><input type="button" class="btn btn-primary" value="返回"></input></a>
	                	</td>
		            </tr>
		                </table>
	                </div>
	                 
            </div>
            </div>
            </form>
</div>
    <!-- jQuery -->
    <script src="/Hrms/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/Hrms/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/Hrms/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/Hrms/vendor/raphael/raphael.min.js"></script>
    <script src="/Hrms/vendor/morrisjs/morris.min.js"></script>
    <script src="/Hrms/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/Hrms/dist/js/sb-admin-2.js"></script>

</body>

</html>