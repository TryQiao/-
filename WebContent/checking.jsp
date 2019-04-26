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
                    <h1 class="page-header">考勤信息</h1>
                </div>
                <div class="check-div form-inline">
                     <div class="col-xs-2" style="padding-left: 15px;">
                    <a href="${basePath}/checking/addCheckingPage" class="active"><i class="glyphicon glyphicon-plus  " style="font-size: 16px">添加</i></a>
                    </div>
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-left: 15px;">
                   		<form  action="${basePath}/checking/listChecking" method="post" >
                   			<label>姓名:</label>
                   			  <input type="text" name="checkingName" class="form-control input-sm" placeholder="输入姓名" value="${checkingName }" style="width:120px">
				            
	                        <label style ="padding-left:26px">考勤类型:</label>
	                        <select class="form-control form-control-sm" id="checkingType" name="checkingType">
			               		  <option value="">-请选择-</option>
			                      <option value="迟到" <c:if test="${checkingType eq '迟到'}">selected</c:if>>迟到</option>
			                      <option value="早退" <c:if test="${checkingType eq '早退'}">selected</c:if>>早退</option>
			                      <option value="正常上班" <c:if test="${checkingType eq '正常上班'}">selected</c:if>>正常上班</option>
			                </select>
			                <%-- <label style="padding-left:30px">请假详细原因:</label>
			                <input type="text" name="leavingReason" class="form-control input-sm" placeholder="输入请假原因" value="${leavingReason }">
	                         --%>
	                         <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                    
                </div>
               
                
                 <div class="col-lg-12">
                 </div>
                 <div class="panel-body">
                	 
                            <table class="table mb-0">
                      <thead class="bg-light">
                        <tr>
                          <th scope="col" class="border-0">序号</th>
                          <th scope="col" class="border-0">姓名</th>
                          <th scope="col" class="border-0">考勤情况</th>
                          <th scope="col" class="border-0">上班时间</th>
                          <th scope="col" class="border-0">下班时间</th>
                          <th scope="col" class="border-0">金额</th>
                          <th scope="col" class="border-0">记录人</th>
                          <th scope="col" class="border-0">操作</th>
                        </tr>
                      </thead>
                      <tbody>
                      
                      <c:forEach items="${checkings}" var="checking" varStatus="status">
                        <tr>
                          <td>${page.recordStart+status.index+1}</td>
                          <td>${checking.py.empl.employeeName}</td>
                          <td>${checking.checkingType}</td>
                          <td>${checking.checkingStart}</td>
                          <td>${checking.checkingEnd}</td>
                          <td style="padding-left:20px">${checking.checkingMoney}</td>
                          <td>${checking.checkingRecorder}</td>
                          <td>
						    <a href="${basePath}/checking/deleteChecking?checkingId=${checking.checkingId}" class="active"><i  class="fa fa-trash-o fa-fw" style="font-size: 20px;color:red"></i></a>
						  	<a href="${basePath}/reward/findReward?rewardId=${reward.rewardId}" class="active"><i class="fa fa-gear fa-fw" style="font-size: 20px"></i></a>
						  </td>
                        </tr>
                       </c:forEach>
                      </tbody>
                    </table>
            </div>
            <div style="padding-left:15px">
           <%@ include file="page.jsp"%>
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
