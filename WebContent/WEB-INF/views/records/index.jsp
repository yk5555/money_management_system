<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>一覧</h2>
        <table id="record_list">
            <tbody>
                <tr>
                    <th class="record_date">日付</th>
                    <th class="record_title">タイトル</th>
                     <th class="record_money">金額</th>
                    <th class="record_action">操作</th>
                </tr>
                <c:forEach var="record" items="${records}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="record_date"><fmt:formatDate value='${record.record_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="record_title">${record.title}</td>
                        <td class="record_money">${record.money}</td>
                        <td class="record_action"><a href="<c:url value='/records/show?id=${record.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${records_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((records_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/records/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p><a href="<c:url value='/records/new' />">新規登録</a></p>

    </c:param>
</c:import>