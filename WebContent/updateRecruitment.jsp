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
        <form action="${basePath }/recruitment/updateRecruitment" method="post" enctype = "multipart/form-data">
        <div id="page-wrapper" >
	            <div class="row">
	                <div class="col-lg-12">
	                    <h1 class="page-header">编辑招聘信息</h1>
	                
	            </div>
	            <div style="padding-left:15px">
	            
	             <div class="table-responsive table-bordered" style="width:40%;">
                   <table class="table">
                   		<tr>
                   			<td>
                   				<div class="form-inline">
				                	<label>编号:</label>
				                	<input class="form-control" id="disabledInput" type="text" name="recruitmentId" placeholder="Enter text" value="${recruitments.recruitmentId }" style="width:80px" disabled="">
				                	<input name="recruitmentId" type="hidden" value="${recruitments.recruitmentId}">
				                	<label>标题:</label>
			                		<input class="form-control" name="recruitmentTitle" placeholder="输入标题" value="${recruitments.recruitmentTitle }" style="width:200px">
		                		</div>
		                	</td>
	                	</tr>
	                	<tr>
	                		<td>
		                		<label>图片:&nbsp;&nbsp;</label>
		                		<img src="${basePath}/${recruitments.recruitmentImage}">
			                  	<input type="hidden" name="recruitmentImage" value="${recruitments.recruitmentImage }">
			                    <input class="form-control form-control-sm" name="recruitmentImg" type="file" style="width:230px">
	                		</td>
	                	</tr>
	                	<tr>
	                		<td>
	                			<label>内容:</label>
                        		<textarea class="form-control" name="recruitmentContent" placeholder="输入发布的相关信息" rows="6" >${recruitments.recruitmentContent }</textarea>
	                		</td>
	                	</tr>
		                <tr>
		                	<td>
		                		<div class="form-inline">
			                		<label>发布时间:</label>
			                		<input class="form-control" name="recruitmentDate" placeholder="输入时间" value="${recruitments.recruitmentDate }" style="width:180px">
		                		</div>
		                	</td>
		                </tr>
		               </table>
	                </div>
	                 <input type="submit" class="btn btn-danger" value="保存"></input>
		             <a href="${basePath }/recruitment/listRecruitment"><input type="button" class="btn btn-primary" value="返回"></input></a>
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