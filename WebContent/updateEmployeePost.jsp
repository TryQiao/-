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
        <form action="${basePath }/employee/updateEmployeePost" method="post">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">编辑员工职务</h1>
	                
	            </div>
	            <div style="width: 1200px;padding-left:15px;">
	                <div class="form-group">
	                <div class="form-inline">
	                <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:30%;">
	                	<tr>
	                		<td>
	                			<label>编号:</label>
	                			<input class="form-control" value="${employees.employeeId }" style="width:60px;text-align:center" disabled="">
	                			<input name="employeeId" type="hidden" value="${employees.employeeId}">
	                			<input name="employeePwd" type="hidden" value="${employees.employeePwd}">
	                		</td>
	                	</tr>
	                	<tr>
	                		<td>
				                <label>姓名:</label>
				              <input class="form-control" value="${employees.employeeName }" name="employeeName" placeholder="输入姓名" style="width:130px ;text-align:center" disabled="">
				              <input type="hidden" name="employeeName" value="${employees.employeeName}"	>
				              <input class="form-control" type="hidden" value="${employees.employeeAge }" name="employeeAge" placeholder="Enter text" style="width:130px;text-align:center">
		               			<input type="hidden" name="employeeSex" value="${employees.employeeSex}"	>	
		               			 <input type="hidden" class="form-control" value="${employees.employeeBorn }" name="employeeBorn" placeholder="Enter text" style="width:130px;text-align:center" >	
				                <input type="hidden" class="form-control" value="${employees.employeeMarriage }" name="employeeMarriage" placeholder="Enter text" style="width:60px;text-align:center" >
				                <input type="hidden" class="form-control" value="${employees.employeePhone }" name="employeePhone" placeholder="Enter text" style="width:130px;text-align:center">
				                <input type="hidden" class="form-control" value="${employees.employeeAddress }" name="employeeAddress" placeholder="Enter text" style="width:130px;text-align:center" >
				                <input type="hidden" class="form-control" value="${employees.employeeStarttime }" name="employeeStarttime" placeholder="Enter text" style="width:130px;text-align:center">
				                <input type="hidden" class="form-control" value="${employees.employeeBz }" name="employeeBz" placeholder="Enter text" style="width:90%;text-align:center">               			
		                		<input type="hidden" name="departments.departmentId" value="${employees.departments.departmentId}">
		                	</td>
	                	</tr>
				        <tr>
				        	<td>
				        		<label>职务:</label>
				                <select class="form-control"  id="employeePost" name="employeePost" style="width:140px">
				               		  <option value="">-请选择-</option>
				                      <option value="部门经理" <c:if test="${employees.employeePost eq '部门经理' }">selected="selected"</c:if>>部门经理</option>
				                      <option value="部门副经理" <c:if test="${employees.employeePost eq '部门副经理' }">selected="selected"</c:if>>部门副经理</option>
				                      <option value="部门员工" <c:if test="${employees.employeePost eq '部门员工' }">selected="selected"</c:if>>部门员工</option>
			               		</select>
				        	</td>
				        </tr>       
	                	
		        	</table>
		        	</div>
	                 <input type="submit" class="btn btn-danger" value="保存"></input>
		             <a href="${basePath }/employee/listEmployeePost"><input type="button" class="btn btn-primary" value="返回"></input></a>
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