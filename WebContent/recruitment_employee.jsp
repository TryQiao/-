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
                    <h1 class="page-header">招聘信息</h1>
                </div>
                <div class="check-div form-inline">
                   
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-left: 30px;">
                   		<form  action="${basePath}/recruitment_employee/listRecruitment" method="post" >
	                        <input type="text" name="recruitmentTitle" class="form-control input-sm" placeholder="输入招聘标题" value="${recruitmentTitle }">
	                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                     
                </div>
               
                <div class="col-lg-12">
                 <c:forEach items="${recruitments}" var="recruitment" varStatus="status">
                 	<div class="col-lg-4">
	                    <div class="panel panel-primary" >
	                     <div class="panel-body">
	                            <!-- Nav tabs -->
	                            <ul class="nav nav-tabs ">
	                                <li class="active"><a href="#home" data-toggle="tab" aria-expanded="true" style="color:#337AB7">标题:${recruitment.recruitmentTitle}</a>
	                                </li>
	                            </ul>
	                             <div class="tab-pane fade active in" id="home" style="height:200px;margin-top:5px">
	                             	<div class="tab-pane fade active in" id="home" style="margin-left:15px">
	                             	<img src="${basePath}/${recruitment.recruitmentImage}">
	                             	</div>
	                             	
	                                <div class="tab-pane fade active in" id="home" style="margin-top:5px">
	                                    <pre id="content" style="height:120px">${recruitment.recruitmentContent}</pre>
	                                </div>
	                            </div>
	                      </div>
	                       <!-- /.panel-body -->
	                        <div class="panel-footer" style="height:45px;margin-top:40px">
                           		 发布时间: ${recruitment.recruitmentDate}
                        	</div>
	                    </div>
                	</div>
                	</c:forEach>
				    <div class="col-lg-12">             
           				<%@ include file="page.jsp"%>
            		</div>
            </div>
</div>


	<script type="text/javascript">
	function toTextarea(str){
	    var reg=new RegExp("<br>","g");
	    var regSpace=new RegExp(" ","g");
	    str = str.replace(reg,"\n");
	    str = str.replace(regSpace," ");
	    
	    return str;
	}
	 $('#id').html(data);
	 $('#text').val(toTextarea(data));
	</script>
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
