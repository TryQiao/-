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
                    <h1 class="page-header">培训信息</h1>
                </div>
                <div class="check-div form-inline">
                    
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-left: 30px;">
                   		<form  action="${basePath}/train_employee/listTrain" method="post" >
	                        <input type="text" name="trainTitle" class="form-control input-sm" placeholder="输入培训主题" value="${trainTitle }">
	                        <i class="fa fa-ellipsis-h"></i>
	                        &nbsp;<input type="text" name="trainMan" class="form-control " placeholder="输入讲师" value="${trainMan }">
	                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                    
                </div>
               
               
                
                 <div class="col-lg-11">
                 <c:forEach items="${trains}" var="train" varStatus="status">
                 	<div class="col-lg-4">
	                    <div class="panel panel-primary">
	                        <div class="panel-body">
	                            <!-- Nav tabs -->
	                            <ul class="nav nav-tabs ">
	                                <li class="active"><a href="#home" data-toggle="tab" aria-expanded="true" style="color:#337AB7">主题:${train.trainTitle}</a>
	                                </li>
	                            </ul>
	                            <div class="tab-content" style="height:80px">
	                                <div class="tab-pane fade active in" id="home">
	                                    <h4>讲师:${train.trainMan}</h4>
	                                    <h5>培训内容:${train.trainAim}</h5>
	                                    <p><h5>参加人员:${train.trainJoin}</h5>
						           		</p>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- /.panel-body -->
	                        <div class="panel-footer" style="height:60px">
                           		 培训地点:${train.trainAddress}<br/>
						                            培训时间:${train.trainTime}
                        	</div>
	                    </div>
	                    <!-- /.panel -->
                	</div>
                 </c:forEach>
                 </div>
                 <div style="margin-left:30px">
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
