<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
</head>
<body>
<div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search" style="color:#337AB7">
                            
                                &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                <i class="glyphicon glyphicon-user" style="font-size: 18px">${employee.employeeName }</i>
                            
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="/Hrms/index_employee.jsp"><i class="fa fa-dashboard fa-fw"></i> 主页</a>
                        </li>
                        <li>
                            <a href="${basePath}/employee_employee/detailEmployee?employeeId=${employee.employeeId}"><i class="fa fa-wrench fa-fw"></i>个人信息查看与修改</a>
                        </li>
                        <%-- <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>部门<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${basePath }/department/listDepartment">部门信息</a>
                                </li>
                                <li>
                                    <a href="${basePath}/addDepartment.jsp">部门添加</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li> --%>
                        <li>
                            <a href="${basePath }/employee_employee/listEmployee"><i class="fa fa-table fa-fw"></i> 其他员工信息查看</a>
                        </li>
                        <li>
                            <a href="${basePath }/recruitment_employee/listRecruitment"><i class="fa fa-edit fa-fw"></i> 招聘信息查看</a>
                        </li>
                     	<li>
                            <a href="${basePath }/train_employee/listTrain"><i class="fa fa-book fa-fw"></i> 培训信息查看</a>
                        </li>
                        <li>
                            <a href="${basePath}/pay_employee/listPay"><i class="fa fa-bar-chart-o fa-fw"></i>薪资信息查看</a>
                        </li>
                        <%-- <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>薪资管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${basePath }/reward/listReward">奖惩信息</a>
                                </li>
                                <li>
                                    <a href="${basePath}/addDepartment.jsp">薪资信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>--%>
                         <li>
                            <a href="${basePath }/leaving_employee/listLeaving"><i class="fa fa-calendar-o"></i> 请假信息</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 其他<span class="fa  fa-angle-down" style="padding-left:158px"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${basePath }/feedback_employee/listFeedback">信息反馈</a>
                                </li>
                                <li>
                                    <a href="${basePath }/about_employee.jsp">关于系统</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
</body>
</html>