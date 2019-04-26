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
                    <h1 class="page-header">培训信息</h1>
                </div>
                <div class="check-div form-inline">
                    <div class="col-xs-3" style="height: 35px;">
                    <a href="${basePath}/addTrain.jsp" class="active"><i class="glyphicon glyphicon-plus  " style="font-size: 16px">新增</i></a>
                    </div>
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-left: 15px;">
                   		<form  action="${basePath}/train/listTrain" method="post" >
	                        <input type="text" name="trainTitle" class="form-control input-sm" placeholder="输入培训主题" value="${trainTitle }">
	                        <i class="fa fa-ellipsis-h"></i>
	                        &nbsp;<input type="text" name="trainMan" class="form-control " placeholder="输入讲师" value="${trainMan }">
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
                                      	<td >编号</td>
										<td >讲师</td>
										<td >主题</td>
										<td width="140px">培训目的</td>
										<td >培训时间</td>                
										<td >培训地点</td>  
										<td >培训人员</td>              
										<td >操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${trains}" var="train" varStatus="status">
                                    <tr class="odd gradeX">
                                    	<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${page.recordStart+status.index+1}</td>
                                        <td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainId}</td>
						           		<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainMan}</td>
						           		<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainTitle}</td>
						           		<td style="width:140px;display:block;overflow:hidden; white-space:nowrap; text-overflow:ellipsis">${train.trainAim}</td>
						           		<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainTime}</td>
						           		<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainAddress}</td>
						           		<td onclick="location.href='${basePath}/train/findTrain?trainId=${train.trainId}'" style="cursor:pointer" >${train.trainJoin}</td>
						           		<td>
						           			<a href="${basePath}/train/deleteTrain?trainId=${train.trainId}" class="active"><i  class="fa fa-trash-o fa-fw" style="font-size: 20px;color:red"></i></a>
<%-- 						           			<a href="${basePath}/train/findTrain?trainId=${train.trainId}" class="active"><i class="fa fa-gear fa-fw" style="font-size: 20px"></i></a>
 --%>						           		</td>
						           		
						           		
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
