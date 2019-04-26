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
                    <h1 class="page-header">招聘信息</h1>
                </div>
                <div class="check-div form-inline">
                   
                    <div class="col-xs-3" style="height: 35px;">
                   		 <a href="${basePath}/addRecruitment.jsp" class="active"><i class="glyphicon glyphicon-plus  " style="font-size: 16px">发布新招聘信息</i></a>
                    </div>
                    <div class="col-xs-4" style="width: 100%;height: 45px;padding-left: 15px;">
                   		<form  action="${basePath}/recruitment/listRecruitment" method="post" >
	                        <input type="text" name="recruitmentTitle" class="form-control input-sm" placeholder="输入招聘标题" value="${recruitmentTitle }">
	                        <button type="submit" class="btn btn-primary btn-sm">查询</button>
                        </form>
                    </div>
                     
                </div>
               
                
                 <div class="col-lg-12">
                 </div>
                 <div class="panel-body">
                	 
                            <table  class="table table-striped table-bordered table-hover" id="dataTables-example" style="width:100%;text-align:center;">
                            
                                <thead>
                                    <tr>
                                    	<td >序号</td>
                                      	<td width="100px">信息编号</td>
										<td >标题</td>
										<!-- <td>图片</td> -->
										<td width="230px">内容</td>
										<td >时间</td>                
										<td >操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${recruitments}" var="recruitment" varStatus="status">
                                    <tr class="odd gradeX">
                                    	<td>${page.recordStart+status.index+1}</td>
                                        <td>${recruitment.recruitmentId}</td>
						           		<td>${recruitment.recruitmentTitle}</td>
						           		<%-- <td><img src="${basePath}/${recruitment.recruitmentImage}"></td> --%>
						           		<td id="content" style="width:230px;display:block;overflow:hidden; white-space:nowrap; text-overflow:ellipsis">${recruitment.recruitmentContent}</td>
						           		<td>${recruitment.recruitmentDate}</td>
						           		<td>
						           			<a href="${basePath}/recruitment/deleteRecruitment?recruitmentId=${recruitment.recruitmentId}" class="active"><i  class="fa fa-trash-o fa-fw" style="font-size: 20px;color:red"></i></a>
						           			<a href="${basePath}/recruitment/findRecruitment?recruitmentId=${recruitment.recruitmentId}" class="active"><i class="fa fa-gear fa-fw" style="font-size: 20px"></i></a>
						           		</td>
						           		
						           		
                                    </tr>
                                 </c:forEach>
                                 <%-- <c:forEach items="${recruitments}" var="recruitment" varStatus="status">
                                 <tr><td><pre><a id="content">${recruitment.recruitmentContent}</a></pre></td></tr>
                                 </c:forEach> --%>
                                     </tbody>
                            </table>
                            
            </div>
            <div style="padding-left:15px">
            	<%@ include file="page.jsp"%>
            </div>
           
            </div>
            </div>
</div>


	<script type="text/javascript">
	function toTextarea(str){
	    var reg=new RegExp("<br>","g");
	    var regSpace=new RegExp("&nbsp;","g");
	    
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
