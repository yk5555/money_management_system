<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>貯金管理システム</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
<body>
        <div id="wrapper">
            <div id="header">
                <div id="header_menu">
                    <h1><a href="<c:url value='/' />">自己紹介ページ</a></h1>&nbsp;&nbsp;&nbsp;

                    <h1><a href="<c:url value='/money' />">貯金管理システム</a></h1>&nbsp;&nbsp;&nbsp;

                    <c:if test="${sessionScope.login_person != null}">
                        <c:if test="${sessionScope.login_person.admin_flag == 1}">
                            <a href="<c:url value='/persons/index' />">会員管理</a>&nbsp;
                        </c:if>
                        <a href="<c:url value='/records/index' />">貯金管理</a>&nbsp;
                    </c:if>
                </div>
                <c:if test="${sessionScope.login_person != null}">
                <c:if test="${requestScope['javax.servlet.forward.servlet_path'] != '/' && requestScope['javax.servlet.forward.servlet_path'] != '/index.html'}">
                    <div id="person_name">
                        <c:out value="${sessionScope.login_person.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                        <a href="<c:url value='/logout' />">ログアウト</a>
                    </div>
                    </c:if>
                </c:if>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Yuichi Kawazoe.
            </div>
        </div>
    </body>
</html>