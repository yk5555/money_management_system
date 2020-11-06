<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2><c:out value="${sessionScope.login_person.name}" />さん　貯金管理システムへようこそ</h2>
        <h2>現在の貯金額　${records_money}円です</h2>
        <h3>【直近の記録】</h3>
        <table id="record_list">
            <tbody>
                <tr>
                    <th class="record_date">日付</th>
                    <th class="record_money">金額</th>
                    <th class="record_title">内容</th>
                    <th class="record_action">詳細</th>
                </tr>
                <c:forEach var="record" items="${records}" varStatus="status">
                    <tr class="row${status.count % 2}">

                        <td class="record_date"><fmt:formatDate value='${record.record_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="record_money">${record.money}</td>
                        <td class="record_title">${record.title}</td>
                        <td class="record_action"><a href="<c:url value='/records/show?id=${record.id}' />">詳細確認</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


        <p><a href="<c:url value='/records/new' />">新規登録</a></p>
    </c:param>
</c:import>