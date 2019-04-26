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
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                    <h1 class="page-header">主页</h1>
                </div>
                <!-- /.col-lg-12 -->
                <div class="col-lg-11">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-gears fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>管理员数</div>
                                    <div class="huge">${countManager}</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/manager/listManager">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6" >
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>员工人数</div>
                                    <div class="huge">${countEmployee }</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/employee/listEmployee">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>部门数</div>
                                    <div class="huge">${countDepartment}</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/department/listDepartment">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <!-- </div>
                <div class="col-lg-11"> -->
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tags fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>招聘条数</div>
                                    <div class="huge">${countRecruitment}</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/recruitment/listRecruitment">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-pencil fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>培训数</div>
                                    <div class="huge">${countTrain}</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/train/listTrain">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading" style="color:#337AB7">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-send-o fa-4x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                	<div>请假条数</div>
                                    <div class="huge">${countLeaving}</div>
                                    
                                </div>
                            </div>
                        </div>
                        <a href="${basePath }/leaving/listLeaving">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                </div>
            </div>
            </div>
</div>
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
