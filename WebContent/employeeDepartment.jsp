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
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">部门详情</h1>
                </div>
               <div class="check-div form-inline">
                    <div class="col-xs-3" style="padding: 15px;">
                    	<a href="${basePath}/employee/listEmployee" class="active"><i class="fa fa-reply  " style="font-size: 16px">返回员工信息</i></a>
                    </div>
                    
                </div>
                
                 <div class="col-lg-12">
                 </div>
                 <div class="panel-body">
                	 
                             <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:16%;">
	                	<tr>
	                	<td style="width:100px">
	                		<select class="form-control" style="-webkit-appearance:none;-moz-appearance:none;appearance:none;" disabled="">
			               		  <option value="" >-请选择-</option>
			                      <c:forEach var="dep" items="${deps}" >
		               		  <!-- 循环出角色列表,如果当前循环项与要修改的用户的角色ID相同,则默认选择该项 -->
		               		  	<option value="" <c:if test="${employees.departments.departmentId eq dep.departmentId }">selected="selected"</c:if>>${dep.departmentName}</option>
		               		  </c:forEach>
			                      
			               		</select>
			               		</td>
			               		</tr>
			               		<tr>
			               		<td>
	                		<select class="form-control" style="-webkit-appearance:none;-moz-appearance:none;appearance:none;"  disabled="">
			               		  <option value="">-请选择-</option>
			                      <c:forEach var="dep" items="${deps}" >
		               		  <!-- 循环出角色列表,如果当前循环项与要修改的用户的角色ID相同,则默认选择该项 -->
		               		  	<option value="" <c:if test="${employees.departments.departmentId eq dep.departmentId }">selected="selected"</c:if>>${dep.departmentNumber}</option>
		               		  </c:forEach>
			                      
			               		</select>
			               		</td>
	                	</tr>
	                	</table>
            </div>
            <div style="padding-left:15px">
            	<%-- <%@ include file="page.jsp"%> --%>
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
