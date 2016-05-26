<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" modelAttribute="userModel" id="userEdit">
<div class="table hor-center">
    <div class="row">
        <div class="titleCell">
            Surveyor : User Viewing
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
                        Username :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="userName" size="10" cssClass="transparent" />
                    </div>
                </div>
                <div class="row">
                    <div class="labelcell">
                        Role : 
                    </div>
                    <div class="cell">
                        <form:input type="text" path="role" size="10" cssClass="transparent" />
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        Name :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="name" size="10" cssClass="transparent" />
                    </div>
                </div>                                
                <div class="row">
                    <div class="labelcell">
                        Surname :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="surname" size="10" cssClass="transparent" />
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        E-mail :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="email" size="10" cssClass="transparent" />
                    </div>
                </div>                                
                <div class="row">
                    <div class="labelcell">
                        Phone :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="phone" size="10" cssClass="transparent" />
                    </div>
                </div>                                                
            </div>
        </div>       
    </div>                          
</div>             
</form:form>
