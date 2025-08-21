<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>My JSP Page</title>
</head>
<body>
    <h1>Hello, JSP!</h1>
    <p>This is a simple JSP page.</p>

    <form action="addAlien" method="post">
        Enter Your Id: <input type="text" name="aid" />
        Enter Your Name: <input type="text" name="aname" />
        <input type="submit" />
    </form>

    <form action="getAlien" method="get">
        Enter Your Id: <input type="text" name="aid" />
        <input type="submit" />
    </form>

    <form action="getAlienByName" method="get">
        Enter Your Name: <input type="text" name="aname" />
        <input type="submit" />
    </form>
</body>
</html>