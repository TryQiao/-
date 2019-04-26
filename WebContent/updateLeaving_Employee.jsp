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
        <form action="${basePath }/leaving_employee/updateLeaving" method="post">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">编辑请假信息</h1>
	                
	            </div>
	                <div class="form-group" style="padding-left:15px">
	                <div class="form-inline">
		                <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:40%;">
		                 <tr>
			                <td>
			                	<input name="leavingId" type="hidden" value="${leavings.leavingId}">
			                	<label>姓名:</label>
						                <input class="form-control" name="LeavingName" placeholder="Enter text" value="${leavings.leavingName }" style="width:120px;text-align:center" disabled="">
						                <input name="leavingName" type="hidden" value="${leavings.leavingName}">
<%-- 						                <input name="leavingType"  value="${leavings.leavingType}">
 --%>						                <label>类型:</label>
						                <select class="form-control" id="leavingType" name="leavingType" style="width:100px">
					               		  <option value="">-请选择-</option>
					                      <option value="事假" <c:if test="${leavings.leavingType eq '事假' }">selected="selected"</c:if>>事假</option>
					                      <option value="病假" <c:if test="${leavings.leavingType eq '病假' }">selected="selected"</c:if>>病假</option>
					                      <option value="带薪假" <c:if test="${leavings.leavingType eq '带薪假' }">selected="selected"</c:if>>带薪假</option>
					               		</select>
			                	<tr>
				                	<td>
				                		<label>请假详细原因:</label>
								        <input class="form-control" name="leavingReason" placeholder="输入详细请假原因" value="${leavings.leavingReason }" style="width:260px;text-align:center" >
						                </td>
			                	</tr>
						       <tr>
							       <td>
							       	<label>时间:</label>
				                	<input class="form-control" name="leavingTime" placeholder="输入请假时间" value="${leavings.leavingTime }" style="width:160px;text-align:center">
							       </td>
						       </tr>
	               		</table>
 					</div>
 					<input type="submit" class="btn btn-danger" value="保存"></input>
		             <a href="${basePath }/leaving_employee/listLeaving"><input type="button" class="btn btn-primary" value="返回"></input></a>
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