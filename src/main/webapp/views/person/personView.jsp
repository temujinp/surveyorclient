<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" action="${pageContext.request.contextPath}/userCreate" modelAttribute="personModel" id="personCreate">
<div class="table hor-center">
    <div class="row">
        <div class="titleCell">
            Surveyor : Person Viewing
        </div>
    </div>
    <div class="row">
        <div class="cell" style="color:red;font-weight: bold;">
            <c:if test="${not empty message}">
                ${message}
            </c:if>
        </div>
    </div>              
    <div class="row">
        <div class="cell">
            <div class="table hor-center">
                <div class="row">
                    <div class="labelcell">
                        Name :
                    </div>
                    <div class="cell">
                        <form:input path="name" id="name" cssClass="transparent" />
                    </div>
                </div>
                <div class="row">
                    <div class="labelcell">
                        Surname :
                    </div>
                    <div class="cell">
                        <form:input  path="surname" id="surname" cssClass="transparent" />
                    </div>
                </div>
                <div class="row">
                    <div class="labelcell">
                        Gender : 
                    </div>
                    <div class="cell">
                        <form:input  path="gender" id="gender" cssClass="transparent" />
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        Date Of Birth :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="dob" id="dob" cssClass="transparent" />
                    </div>
                </div>                                
            </div>
        </div>       
    </div>                          
</div>                         
</form:form>
