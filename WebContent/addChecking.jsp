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
       <form action="${basePath }/checking/addCheckings" method="post">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">添加考勤</h1>
	                
	            </div>
	            
	            <div style="width: 1200px;padding-left:15px">
	                <div class="form-group">
	                <div class="form-inline">
	                <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:40%;">
	                	<tr>
	                		<td>
			                	  <label>员工姓名:</label>
					                <select class="form-control form-control-sm" name="py.payId" style="width:100px">
				               		  <option value="">-请选择-</option>
				               		  <c:forEach var="pay" items="${pays}" >
				               		  	<option value="${pay.payId}">${pay.empl.employeeName}</option>
				               		  </c:forEach>
				               		</select>
		                		 
		                	</td>
	                	</tr>
	                	<tr>
		                	<td>
		                		<label>上班时间:</label>
				                <input class="form-control" name="checkingStart" placeholder="输入上班时间" style="width:230px;text-align:center">
		                	</td>
	                	</tr>
	                	<tr>
	                		<td>
	                			<label>考勤情况:</label>
					                <select class="form-control " id="checkingType" name="checkingType" style="width:100px">
				               		  <option value="">-请选择-</option>
				                      <option value="迟到">迟到</option>
				                      <option value="早退">早退</option>
				                      <option value="正常上班">正常上班</option>
	               					</select>
				                <label>金额:</label>
				                <input class="form-control" name="checkingMoney" placeholder="输入金额" style="width:130px;text-align:center" >	
		               		</td>
	                	</tr>
	                	<tr>
	                		<td>
				               
			                    <label>下班时间:</label>
				                <input class="form-control" name="checkingEnd" placeholder="输入下班时间" style="width:260px;text-align:center" >
		                	</td>
	                	</tr>
	                	<tr>
	                		<td>
	                			 <label>记录人:</label>
				                <input class="form-control" name="checkingRecorder" value="${manager.managerName }" style="width:180px;text-align:center" disabled="">
	                			 <input name="checkingRecorder" type="hidden" value="${manager.managerName}">
	                		</td>
	                	</tr>
		        	</table>
		        	</div>
	                 <input type="submit" class="btn btn-danger" value="添加"></input>
		             <a href="${basePath }/checking/listChecking"><input type="button" class="btn btn-primary" value="返回"></input></a>
            	</div>
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