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
        <h2>自己紹介</h2>
        <img src="photo.png" title="自己紹介">
        <h3>生年月日　1991年7月16日</h3>
        <h3>氏名　川添　裕一</h3>
        <h3>mail　ykhandball7@gmail.com</h3>
        <br>
        <h3>川添裕一と申します。現在、福岡在住29歳です。TechaAcademyにてjavaコースを学び簡単なWebアプリケーションの構築までできるようになりました。</h3>
        <br>
        <h3>私は、昔から機械などに触る事が好きで、中でもパソコンは情報が常に入って来るところや様々な事に活用できる利便性、
        世の中に新しいコンテンツを提供するところに興味を抱かれ、ITやネットなどの情報分野が好きになりました。大学でもその分野について学び、
        いつかはIT業界で仕事についてみたいと考えていました。これからIT社会がどんどん広がっていく上で、私は、プログラミングはなくてはならないスキルになると思っています。
        プログラミングを通して、ものづくりをして、様々な人々の手助けや、社会貢献をしていきたいと思い、IT業界を目指すことを決めました。</h3>
        <br>
    </c:param>
</c:import>