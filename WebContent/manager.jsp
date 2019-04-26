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
                    <h1 class="page-header">管理员信息</h1>
                </div>
                <div class="check-div form-inline">
                    <div class="col-xs-3" >
	                    <c:if test="${manager.managerName eq 'admin'}">
	                    <a href="${basePath}/addManager.jsp" class="active"><i class="glyphicon glyphicon-plus  " style="font-size: 16px">添加</i></a>
	                    </c:if>
                    </div>
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-top:5px">
                   		<form  action="${basePath}/manager/listManager" method="post" >
	                        <input type="text" name="managerName" class="form-control input-sm" placeholder="输入管理员姓名" value="${managerName }">
	                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                    
                </div>
               
                
                 <div class="col-lg-12">
                 </div>
                 <div class="panel-body">
                	 
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example" style="text-align:center">
                            
                                <thead>
                                    <tr >
                                    	<td >序号</td>
                                      	<td >管理员编号</td>
										<td >姓名</td>
										<td >电话</td>
										<td >性别</td>                
										<td >密码</td>               
										<td >操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${managers}" var="manager" varStatus="status">
                                    <tr class="odd gradeX">
                                    	<td>${page.recordStart+status.index+1}</td>
                                        <td>${manager.managerId}</td>
						           		<td>${manager.managerName}</td>
						           		<td>${manager.managerPhone}</td>
						           		<td>${manager.managerSex}</td>
						           		<td><i class="fa fa-eye-slash"></i>
						           		</td>
						           		<td>
						           		<c:if test="${manager.managerName ne 'admin'}">
						           			<a href="${basePath}/manager/deleteManager?managerId=${manager.managerId}" class="active"><i  class="fa fa-trash-o fa-fw" style="font-size: 20px;color:red"></i></a>
						           		</c:if>
						           		<c:if test="${manager.managerName eq 'admin'}">
						           			不可操作
						           		</c:if>
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
