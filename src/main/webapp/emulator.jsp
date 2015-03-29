<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Эмулятор магазина</title>
    <script type="text/javascript" src="js/jquery/jquery-2.1.3.js"></script>
    <script>
        $(function () {
            $("#nextStep").click(function () {
                $("#shop").load("nextStep");
            });
            $("#shop").load("shop.jsp");
        });
    </script>
</head>
<body>
<h1>Магазин</h1>
<button id="nextStep">Следующий шаг</button>
<div id="shop"></div>
</body>
</html>
