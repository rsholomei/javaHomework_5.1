<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .Absolute-Center {
            margin: auto;
            position: absolute;
            top: 0; left: 0; bottom: 50%; right: 0;
        }
    </style>
    <style>
        .Absolute-Center.is-Responsive {
        width: 50%;
        height: 50%;
        min-width: 300px;
        max-width: 600px;
        padding: 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="Absolute-Center is-Responsive">
        <form action="/guestBook" method="post">
            <div class="form-group">
                <label for="name">Book name:</label>
                <input type="text" name="name" class="form-control" id="name">
            </div>
            <div class="form-group">
                <label for="message">Message:</label>
                <textarea name="message" class="form-control" id="message" rows="2"></textarea>
            </div>
            <div class="form-group">
                <label for="rating">Rating:</label>
                <select class="form-control" name="rating" id="rating">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

        <table class="table">
            <thead class="thead-inverse">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Message</th>
                    <th>Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items ="${guestBooks}" var="guestBook">
                <tr>
                    <td>${guestBook.id}</td>
                    <td>${guestBook.name}</td>
                    <td>${guestBook.message}</td>
                    <td>${guestBook.rating}</td>
                    <td>
                        <a href="/guestBook?action=delete&id=${guestBook.id}">Delete</a></dt>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
