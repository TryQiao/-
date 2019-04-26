<%@ page language="java" import="com.hrms.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/Hrms/jquery/jquery-3.3.1.min.js""></script>
<script type="text/javascript">
	$(function(){
		var pageIndex=${requestScope.page.pageIndex};
		var pageCount=${requestScope.page.pageCount};
		if(pageIndex==1)
			{
				$("#prePage").hide();
			}
		else
			{
			$("#prePage").show();
			}
		
		if(pageIndex==pageCount)
			{
				$("#nextPage").hide();
			}
		else
			{
			$("#nextPage").show();
			}
	})
</script>
<style type="text/css">
	a:hover{
	 color:red;  /*鼠标放上去有下划线*/
	}
</style>
</head>
<body>
<ul class="pagination">
<li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="${requestScope.page.url}?pageIndex=${requestScope.page.pageIndex-1}" id="prePage">上一页</a></li>
<li><span>共${requestScope.page.totalCount}条</span></li>
<li><span>当前页码:${requestScope.page.pageIndex}</span></li>
<li><span >共${requestScope.page.pageCount}页</span></li>
<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="${requestScope.page.url}?pageIndex=${requestScope.page.pageIndex+1}" id="nextPage">下一页</a></li>
</ul>




</body>
</html>