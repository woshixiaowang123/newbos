<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../baselist.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>

<body>
<form name="icform" method="post">

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="view"><a href="#"
                                         onclick="javascript:toView()">查看</a></li>
                        <li id="new"><a href="#"
                                        onclick="formSubmit('moduleAction_tocreate','_self');this.blur();">新增</a></li>
                        <li id="update"><a href="#" onclick="javascript:toupdate()">修改</a>
                        </li>
                        <li id="delete"><a href="#"
                                           onclick="javascript:dele()">删除</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <div class="textbox" id="centerTextbox">
        <div class="textbox-header">
            <div class="textbox-inner-header">
                <div class="textbox-title">
                    模块列表
                </div>
            </div>
        </div>

        <div>

            <script type="application/javascript">
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
//            formSubmit('roleAction_toview','_self');this.blur();
                        formSubmit('moduleAction_toview','_self');
                    }else{
                        alert("请先选择一项并且只能选择一项，再进行操作！");
                    }
                }

                function toupdate(){
                    if(isOnlyChecked()){
//            formSubmit('roleAction_toview','_self');this.blur();
                        formSubmit('moduleAction_toupdate','_self');
                    }else{
                        alert("请先选择一项并且只能选择一项，再进行操作！");
                    }
                }

                function dele(){
                    if(isOnlyChecked()){
//            formSubmit('roleAction_toview','_self');this.blur();
                        formSubmit('moduleAction_delete','_self');
                    }else{
                        alert("请先选择一项并且只能选择一项，再进行操作！");
                    }
                }


            </script>


            <div class="eXtremeTable">
                <table id="ec_table" class="tableRegion" width="98%">
                    <thead>
                    <tr>
                        <td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
                        <td class="tableHeader">序号</td>
                        <td class="tableHeader">模块名</td>
                        <td class="tableHeader">层数</td>
                        <td class="tableHeader">权限标识</td>
                        <td class="tableHeader">链接</td>
                        <td class="tableHeader">类型</td>
                        <td class="tableHeader">从属</td>
                        <td class="tableHeader">状态</td>
                    </tr>
                    </thead>
                    <tbody class="tableBody">
                    ${links }
                    <c:forEach items="${results}" var="o" varStatus="status">
                        <tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'"
                            align="left">
                            <td><input type="checkbox" name="id" value="${o.id}"/></td>
                            <td>${status.index+1}</td>
                            <td><a href="moduleAction_toview?id=${o.id}">${o.name}</a></td>
                            <td>${o.layerNum}</td>
                            <td>${o.cpermission}</td>
                            <td>${o.curl}</td>
                            <td>
                                <c:if test="${o.ctype =='0'}">主菜单</c:if>
                                <c:if test="${o.ctype =='1'}">左侧菜单</c:if>
                                <c:if test="${o.ctype =='2'}">按钮</c:if>
                                <c:if test="${o.ctype =='3'}">链接</c:if>
                                <c:if test="${o.ctype =='4'}">状态</c:if>
                            </td>
                            <td>${o.belong}</td>
                            <td>
                                <c:if test="${o.state =='1'}">启用</c:if>
                                <c:if test="${o.state =='0'}">停用</c:if>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>


</form>
</body>
</html>

