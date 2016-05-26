<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table hor-center">
    <div class="row">
        <div class="cell">
            <table>
                <caption>Surveyor : Person(s)</caption>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Gender</th>
                        <th>DOB</th>
                   </tr>
                </thead>
                <tbody>
                <c:forEach items="${allPersons}" var="person">
                    <tr>
                        <td><a href="<c:url value='/personEdit/${person.id}' />" title="Edit : ${person.name}">${person.id}</a></td>                        
                        <td>${person.name}</td>                        
                        <td>${person.surname}</td>
                        <td>${person.gender}</td>
                        <td>${person.dob}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>       
    </div>                          
</div>