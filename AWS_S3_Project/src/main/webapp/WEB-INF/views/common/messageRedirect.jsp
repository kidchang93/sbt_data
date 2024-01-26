<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty params.data}">
    <form id="redirectForm" action="${params.redirectUri}" method="${params.method}" style="display: none;">
        <c:forEach var="entry" items="${params.data}">
            <input type="hidden" name="${entry.key}" value="${entry.value}" />
        </c:forEach>
    </form>
</c:if>
</body>
<script>
    window.onload = () => {
        const message = `[[ ${params.message} ]]`;
        if (message) {
            alert(message);
        }

        const form = document.getElementById('redirectForm');
        if (form) {
            form.submit();
            return false;
        }

        const redirectUri = [[ `${params.redirectUri}` ]];
        location.href = redirectUri;
    }
</script>
</html>
