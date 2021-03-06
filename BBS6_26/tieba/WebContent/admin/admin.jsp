<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page import="java.util. *,cn.edu.hainu.domain.Note" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"/>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>海大留言社区BBS后台管理</title>
  <link rel="stylesheet" href="<%=basePath%>/admin/layui/css/layui.css">
  <link rel="stylesheet" href="<%=basePath%>/admin/css/global.css">
  <link rel="stylesheet" href="<%=basePath%>/admin/icheck/minimal/red.css">
  <script type="text/javascript">
  function  check() {
	  var id=document.getElementsByName("id");
		var is=false;
		for (var i = 0; i < id.length; i++) {
			if (id[i].checked) {
				is=true
			}
		}
		if (!is) {
			return false;
		}
	var check=window.confirm("删除后无法恢复，确定吗？")
	return check;
}
  function checkdel() {
	  var check=window.confirm("删除后无法恢复，确定吗？")
		return check;
}
  function select() {
		var id=document.getElementsByName("id");
		var ids="";
		for (var i = 0; i < id.length; i++) {
			if(id[i].checked){
			ids=ids+"nid="+id[i].value+"&";	
			}
		}
		location.href="${pageContext.request.contextPath}/deleteNoteServlet?"+ids;
		
	}
  </script>
</head>
<body class="layui-layout-body">
<c:if test="${empty(admin)}">
  <script type="text/javascript">
      alert('非法访问');
      location.href='${pageContext.request.contextPath}/admin/login.jsp';
  </script>
</c:if>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">海大留言社区BBS后台管理</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
   
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://localhost:8080/images/1561385249.jpg" class="layui-nav-img">
          ${admin.aname}
        </a>
        
      </li>
      <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/quitAdminServlet">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item"><a href="admin/index.jsp">控制台</a></li>
        
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">留言管理</a>
          <dl class="layui-nav-child">
            <dd><a class="layui-this" href="admin/admin.jsp">留言列表</a></dd>
          </dl>
        </li>
        
        <li class="layui-nav-item">
                <a href="javascript:;">用户管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/admin/member.jsp">用户列表</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item ">
                <a href="javascript:;">评论管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="admin/comment.jsp">评论列表</a></dd>
                </dl>
            </li>
        
        
      </ul>
    </div>
  </div>
  
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
        <fieldset class="layui-elem-field">
            <legend>留言管理 - 留言列表</legend>
            <div class="layui-field-box">
               <form class="layui-form" action="${pageContext.request.contextPath}/adminSerachNoteServlet" method="get">
                <div class="layui-form-item" style="text-align:center;">
                  <div class="layui-inline">
                    <div class="layui-input-inline">
                      <input autocomplete="off" class="layui-input" placeholder="请输入帖子关键词" type="text" name="search_key" >
                    </div>
                  </div>
                  <div class="layui-inline" style="text-align:left;">
                    <div class="layui-input-inline">
                      <button class="layui-btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                  </div>
                </div>
              </form>          
              <hr>
              <div class="layui-btn-group">
                 <a class="layui-btn layui-btn-xs layui-btn-danger" href="javascript:select();"  onclick="return check()">
                            <i class="layui-icon">&#xe640;</i>删除选中
                          </a>
                  <button class="layui-btn layui-btn-xs dw-refresh">
                      <i class="layui-icon">&#x1002;</i>刷新
                  </button>
              </div>
              <hr>
              <table style="border:1px ;width: 100%;table-layout: fixed" border="1" >
                  <colgroup>
                      <col width="50">
                      <col width="100">
                      <col width="100">
                      <col width="200">
                      <col >
                      <col width="50">
                  </colgroup>
                  <thead>
                      <tr>
                      <th class="selectAll"><input type="checkbox"></th>
                      <th>作者</th>
                      <th>发布时间</th>
                      <th>主题</th>
                      <th>内容</th>
                      <th style="text-align:center;">操作</th>
                      </tr> 
                  </thead>
                  <tbody>
                  <c:forEach items="${requestScope.notes}" var="note" varStatus="s">
                   <tr>
                      <td align="center"><input type="checkbox" name="id" value="${note.nid}" ></td>
                      <td>${note.uname }</td>
                      <td>${note.time }</td>
                      <td>${note.topic }</td>
                      <td style="overflow: hidden;white-space:nowrap;word-break: keep-all;word-break: keep-all;text-overflow:ellipsis ;">${note.content}</td>
                      <td class="text-center">
                        <div class="layui-btn-group">
                          <a class="layui-btn layui-btn-xs layui-btn-normal" href="${pageContext.request.contextPath}/detailNoteServlet?nid=${note.nid}" ><i class="layui-icon">&#xe642;</i>查看</a>
                         
                          <a class="layui-btn layui-btn-xs layui-btn-danger" href="${pageContext.request.contextPath}/deleteNoteServlet?nid=${note.nid}" onclick=" return checkdel()">
                            <i class="layui-icon">&#xe640;</i>删除
                          </a>
                        </div>
                      </td>
                      </tr>
                  </c:forEach>
                     
                      
                     
                  </tbody>
              </table>
            </div>
        </fieldset>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>/admin/javascript/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/admin/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>/admin/icheck/icheck.js"></script>
<script type="text/javascript" src="<%=basePath%>/admin/javascript/dw.js"></script>
</body>
</html>