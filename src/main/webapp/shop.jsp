<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<c:set var="shop" value="${sessionScope.shop}"/>
<table>
    <c:forEach var="cash" items="${shop.cashes}">
        <tr>
            <td>
                <img src="img/cash.png" width="50" height="50"/>
                <div style="text-align: center">${cash.productivity}</div>
            </td>
            <c:forEach var="customer" items="${cash.queue}">
                <c:set var="color" value="; color: black"/>
                <c:if test="${customer eq sessionScope.newCustomer}">
                    <c:set var="color" value="; color: red"/>
                </c:if>
                <td>
                    <img src="img/${customer.code}.png" width="50" height="50"/>
                    <div style="text-align: center${color}">${customer.products}</div>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>