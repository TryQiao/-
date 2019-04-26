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
        <form action="${basePath }/employee/updateEmployee" method="post">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">编辑员工信息</h1>
	                
	            </div>
	            <div style="width: 1200px;padding-left:15px">
	                <div class="form-group">
	                <div class="form-inline">
	                <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:60%;">
	                	<tr>
	                		<td>
	                			<label>编号:</label>
	                			<input class="form-control" value="${employees.employeeId }" style="width:60px;text-align:center" disabled="">
	                			<input name="employeeId" type="hidden" value="${employees.employeeId}">
	                			<input name="employeePwd" type="hidden" value="${employees.employeePwd}">
	                			<input name="employeePost" type="hidden" value="${employees.employeePost}">
	                		</td>
	                	</tr>
	                	<tr>
	                		<td>
				                <label>姓名:</label>
				              <input class="form-control" value="${employees.employeeName }" name="employeeName" placeholder="输入姓名" style="width:130px ;text-align:center" >
				                <label>年龄:</label>
				              <input class="form-control" value="${employees.employeeAge }" name="employeeAge" placeholder="输入年龄" style="width:130px;text-align:center">
		               			<label>性别:</label>
				                <select class="form-control"  id="employeeSex" name="employeeSex" style="width:100px">
				               		  <option value="">-请选择-</option>
				                      <option value="男" <c:if test="${employees.employeeSex eq '男' }">selected="selected"</c:if>>男</option>
				                      <option value="女" <c:if test="${employees.employeeSex eq '女' }">selected="selected"</c:if>>女</option>
			               		</select>
		                	</td>
	                	</tr>
	                	<tr>
	                		<td>
				                <label>出生日期:</label>
				                <input class="form-control" value="${employees.employeeBorn }" name="employeeBorn" placeholder="输入出生日期" style="width:130px;text-align:center" >	
				                <label>婚姻状况:</label>
				                 <select class="form-control"  id="employeeMarriage" name="employeeMarriage" style="width:100px">
				               		  <option value="">-请选择-</option>
				                      <option value="未婚" <c:if test="${employees.employeeMarriage eq '未婚' }">selected="selected"</c:if>>未婚</option>
				                      <option value="已婚" <c:if test="${employees.employeeMarriage eq '已婚' }">selected="selected"</c:if>>已婚</option>
			               		</select>
		               		</td>
	                	</tr>
	                	<tr>
	                		<td>
				                <label>电话:</label>
				                <input class="form-control" value="${employees.employeePhone }" name="employeePhone" placeholder="输入电话" style="width:130px;text-align:center">
			                    <label>地址:</label>
				                <input class="form-control" value="${employees.employeeAddress }" name="employeeAddress" placeholder="输入地址" style="width:130px;text-align:center" >
				                <label>开始工作时间:</label>
				                <input class="form-control" value="${employees.employeeStarttime }" name="employeeStarttime" placeholder="输入工作时间" style="width:130px;text-align:center">
		                	</td>
	                	</tr>
	                	<tr>
	                		<td>
				                <label>备注:</label>
				                <input class="form-control" value="${employees.employeeBz }" name="employeeBz" placeholder="备注" style="width:90%;text-align:center">
		        			</td>
	                	</tr>
	                	<tr>
	                		<td>
			                	<label>部门</label>
				                <select class="form-control" class="form-control"  name="departments.departmentId" style="width:100px">
			               		  <option value="">-请选择-</option>
			                      <c:forEach var="dep" items="${deps}" >
		               		  <!-- 循环出角色列表,如果当前循环项与要修改的用户的角色ID相同,则默认选择该项 -->
		               		  	<option value="${dep.departmentId}" <c:if test="${employees.departments.departmentId eq dep.departmentId }">selected="selected"</c:if>>${dep.departmentName}</option>
		               		  </c:forEach>
			                      
			               		</select>
	               			</td>
	                	</tr>
		        	</table>
		        	</div>
	                 <input type="submit" class="btn btn-danger" value="保存"></input>
		             <a href="${basePath }/employee/listEmployee"><input type="button" class="btn btn-primary" value="返回"></input></a>
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