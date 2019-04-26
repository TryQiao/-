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
           <%@ include file="header_employee.jsp"%>
			<%@ include file="left_employee.jsp"%>
        </nav>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">员工信息</h1>
                </div>
                <div class="check-div form-inline">
                    <div class="col-xs-4" style="height: 45px;padding-left: 30px;">
                   		<form  action="${basePath}/employee_employee/listEmployee" method="post" >
	                        <input type="text" name="employeeName" class="form-control input-sm" placeholder="输入员工姓名" value="${employeeName }">
	                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                    
                </div>
               
                
                 
                 <div class="col-md-12">
                       <div class="panel panel-default" style="margin-left:15px">
					      <!-- Default panel contents -->
					      <div class="panel-heading"># 其他员工</div>
					
					      <!-- Table -->
					      <table class="table">
					        <thead>
					          <tr>
					            <th>序号</th>
					            <th>编号</th>
					            <th>姓名</th>
					            <th>性别</th>
					            <th>职务</th>
					            <th>所属部门</th>
					            <th>其他</th>
					          </tr>
					        </thead>
					        <tbody>
					          <c:forEach items="${employees}" var="employeess" varStatus="status">
					          <c:if test="${employeess.employeeId ne employee.employeeId }">
					          <tr class="list-group-item-info">
					            <td>${page.recordStart+status.index+1}</td>
					            <td>${employeess.employeeId}</td>
					            <td>${employeess.employeeName}</td>
					            <td>${employeess.employeeSex}</td>
					            <td>${employeess.employeePost}</td>
					            <td>${employeess.departments.departmentName}</td>
					            <td><i class="fa fa-eye-slash " style="font-size:18px"></i></a></td>
					          </tr>
					          </c:if>
					          </c:forEach>
					        </tbody>
					      </table>
					    </div>
					    <div style="margin-left:15px">
					    	<%@ include file="page.jsp"%>
					    </div>
					    
                   </div>
           
            </div>
            </div>
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
