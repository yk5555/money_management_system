<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${record != null}">
                <h2>日報　詳細ページ</h2>

                <table>
                    <tbody>

                        <tr>
                            <th>日付</th>
                            <td><fmt:formatDate value="${record.record_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>

                         <tr>
                            <th>金額</th>
                            <td>
                                <pre><c:out value="${record.money}円" /></pre>
                           </td>
                        </tr>

                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${record.title}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${record.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${record.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.login_person.id == record.person.id}">
                    <p><a href="<c:url value="/records/edit?id=${record.id}" />">編集</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/records/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>