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
                    <h1 class="page-header">薪资信息</h1>
                </div>
                <div class="check-div form-inline">
                    <div class="col-xs-2" style="padding-left: 15px;">
                    <a href="${basePath}/pay/addPayPage" class="active"><i class="glyphicon glyphicon-plus  " style="font-size: 16px">添加</i></a>
                    </div>
                    <div class="col-xs-6" style="height: 45px;">
                   		<form  action="${basePath}/pay/listPay" method="post" >
<%--                    			<input type="text" name="payId" class="form-control " placeholder="输入编号" value="${payId }">
 --%>                   			<label>员工姓名:&nbsp;&nbsp;</label>
					                <select class="form-control form-control-sm" name="payId" style="width:100px">
				               		  <option value="">-请选择-</option>
				               		  <c:forEach var="pay" items="${pays}" >
				               		  	<option value="${pay.payId}">${pay.empl.employeeName}</option>
				               		  </c:forEach>
				               		</select>
                   			<!-- <i class="fa fa-ellipsis-h"></i> -->
                   			&nbsp;or &nbsp;<input type="text" name="payBaseMoney" class="form-control " placeholder="输入基本工资" value="${payBaseMoney }">
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
                                      	<td >员工</td> 
										<td >基本工资</td>
										<td >补助</td>
										<td >奖惩总计</td>
										<td >考勤总计</td>
										<td >实际工资</td>
										<td >操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pays}" var="pay" varStatus="status">
                                	<c:set var="sum" value="0"/>
                                	<c:set var="sum2" value="0"/>
                                    <tr class="odd gradeX">
                                    	<td>${page.recordStart+status.index+1}</td>
                                        <td>${pay.payId}</td>
                                        <td>${pay.empl.employeeName}</td>
						           		<td>${pay.payBaseMoney}</td>
						           		<td>${pay.paySupply}</td>
						           		<td><c:forEach items="${pay.rw}" var="payrw" varStatus="status"><c:set var="sum" value="${sum+ payrw.rewardMoney}"/></c:forEach>
						           			
						           			<c:if test="${sum < 0 }"><a href="${basePath}/reward/listRewardPerson?pay.payId=${pay.payId}" style="color:red; text-decoration:none">${sum }</a>
									        </c:if>
									        <c:if test="${sum >= 0 }"><a href="${basePath}/reward/listRewardPerson?pay.payId=${pay.payId}" style="color:green; text-decoration:none">${sum }</a>
									        </c:if>
						           		</td>
						           		<td><c:forEach items="${pay.ck}" var="payck" varStatus="status"><c:set var="sum2" value="${sum2+ payck.checkingMoney}"/></c:forEach>
						           			
						           			<c:if test="${sum2 < 0 }"><a href="${basePath}/checking/listCheckingPerson?py.payId=${pay.payId}" style="color:red; text-decoration:none">${sum2 }</a>
									        </c:if>
									        <c:if test="${sum2 >= 0 }"><a href="${basePath}/checking/listCheckingPerson?py.payId=${pay.payId}" style="color:green; text-decoration:none">${sum2 }</a>
									        </c:if>
						           		</td>
						           		<td>${pay.payBaseMoney+sum+pay.paySupply+sum2}</td>
						           		<td>
						           			<a href="${basePath}/pay/deletePay?payId=${pay.payId}" class="active"><i  class="fa fa-trash-o fa-fw" style="font-size: 20px;color:red"></i></a>
						           			<a href="${basePath}/pay/findPay?payId=${pay.payId}" class="active"><i class="fa fa-gear fa-fw" style="font-size: 20px"></i></a>
						           			
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
