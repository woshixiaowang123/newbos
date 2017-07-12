<%--<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.js"></script>
	<script>
	     function isOnlyChecked(){
	    	 var checkBoxArray = document.getElementsByName('id');
				var count=0;
				for(var index=0; index<checkBoxArray.length; index++) {
					if (checkBoxArray[index].checked) {
						count++;
					}	
				}
			//jquery
			//var count = $("[input name='id']:checked").size();
			if(count==1)
				return true;
			else
				return false;
	     }
	     function toView(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('deptAction_toview','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	     //实现更新
	     function toUpdate(){
	    	 if(isOnlyChecked()){
	    		 formSubmit('deptAction_toupdate','_self');
	    	 }else{
	    		 alert("请先选择一项并且只能选择一项，再进行操作！");
	    	 }
	     }
	</script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="javascript:toView()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('deptAction_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('deptAction_delete','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    部门列表
  </div> 
  </div>
  </div>
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">编号</td>
		<td class="tableHeader">上级</td>
		<td class="tableHeader">名称</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
    ${links }
	
	<c:forEach items="${results }" var="dept"  varStatus="st">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="checkbox" name="id" value="${dept.id }"/></td>
			<td>${st.count }</td>
			<td>${dept.id }</td>
			<td>${dept.parent.deptname }</td>
			<td><a href="deptAction_toview?id=${dept.id }">${dept.deptname }</a></td>
		</tr>
   </c:forEach>
	</tbody>
</table>--%>





<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- 导入jquery核心类库 -->
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<!-- 导入easyui类库 -->
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
	<link rel="stylesheet" type="text/css"
		  href="${pageContext.request.contextPath }/css/default.css">
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
	<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
	<script
			src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
			type="text/javascript"></script>
	<script type="text/javascript">
        // 工具栏
        var toolbar = [ {
            id : 'button-view',
            text : '查看',
            iconCls : 'icon-search',
            handler : doView
        }, {
            id : 'button-add',
            text : '新增',
            iconCls : 'icon-add',
            handler : doAdd
        }, {
            id : 'button-delete',
            text : '删除',
            iconCls : 'icon-cancel',
            handler : doDelete
        },{
            id : 'button-update',
            text : '修改',
            iconCls : 'icon-cancel',
            handler : doUpdate
        }
		];
        //定义冻结列
        var frozenColumns = [ [ {
            field : 'id',
            checkbox : true,
            rowspan : 2
        }, {
            field : 'username',
            title : '名称',
            width : 80,
            rowspan : 2
        } ] ];


        // 定义标题栏
        var columns = [ [ {
                field : 'gender',
                title : '性别',
                width : 60,
                rowspan : 2,
                align : 'center'
            }, {
                field : 'birthdayStr',
                title : '生日',
                width : 120,
                rowspan : 2,
                align : 'center'
            }, {
                title : '其他信息',
                colspan : 2
            }, {
                field : 'telephone',
                title : '电话',
                width : 800,
                rowspan : 2
            } ] ]
        ;
        $(function(){
            // 初始化 datagrid
            // 创建grid
            $('#grid').datagrid( {
                iconCls : 'icon-forward',
                fit : true,
                border : false,
                rownumbers : true,
                striped : true,
                toolbar : toolbar,
                url : "${pageContext.request.contextPath}/userAction_list.action",
                idField : 'id',
                frozenColumns : frozenColumns,
                columns : columns,
                onClickRow : onClickRow,
                onDblClickRow : doDblClickRow,


                pageList: [10,20,30],
                pagination : true,
                striped : true,
                singleSelect: true,
                rownumbers : true,
                fit : true // 占满容器
            });

            $("body").css({visibility:"visible"});

        });




        function isOnlyChecked(){
            var checkBoxArray = document.getElementsByName('id');
            var count=0;
            for(var index=0; index<checkBoxArray.length; index++) {
                if (checkBoxArray[index].checked) {
                    count++;
                }
            }
            //jquery
            //var count = $("[input name='id']:checked").size();
            if(count==1)
                return true;
            else
                return false;
        }
        function toView(){
            if(isOnlyChecked()){
                formSubmit('deptAction_toview','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }
        //实现更新
        function doAdd(){
            if(isOnlyChecked()){
                formSubmit('deptAction_toupdate','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function doUpdate(){
            if(isOnlyChecked()){
                formSubmit('deptAction_toupdate','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

	</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
<div region="center" border="false">
	<table id="grid"></table>
</div>
</body>
</html>