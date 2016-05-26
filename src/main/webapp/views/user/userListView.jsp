<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table hor-center">
    <div class="row">
        <div class="cell">
            <table>
                <caption>Surveyor : User(s)</caption>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Role</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${allUsers}" var="user">
                    <tr>
                        <td><a href="<c:url value='/userView/${user.id}' />" title="View : ${user.userName}">${user.id}</a></td>                        
                        <td>${user.userName}</td>                        
                        <td>${user.role}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>       
    </div>                          
</div>