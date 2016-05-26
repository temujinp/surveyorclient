<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" action="${pageContext.request.contextPath}/userCreate" modelAttribute="userModel" id="userCreate">
<div class="table hor-center">
    <div class="row">
        <div class="titleCell">
            Surveyor : User Creation
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
                        <form:input path="userName" />
                        <FONT color="red"><form:errors path="userName" /></FONT>
                    </div>
                </div>
                <div class="row">
                    <div class="labelcell">
                        Password :
                    </div>
                    <div class="cell">
                        <form:password  path="password" />
                        <FONT color="red"><form:errors path="password" /></FONT>
                    </div>
                </div>
                <div class="row">
                    <div class="labelcell">
                        Password (confirm) :
                    </div>
                    <div class="cell">
                        <form:password  path="passwordconfirm" />
                        <FONT color="red"><form:errors path="passwordconfirm" /></FONT>
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        Role : 
                    </div>
                    <div class="cell">
                        <form:select path="role" items="${allRoles}" multiple="false" itemValue="id" itemLabel="name"/>
                        <FONT color="red"><form:errors path="role" /></FONT>
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        Name :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="name" id="name"/>
                        <FONT color="red"><form:errors path="name" /></FONT>
                    </div>
                </div>                                
                <div class="row">
                    <div class="labelcell">
                        Surname :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="surname" id="surname"/>
                        <FONT color="red"><form:errors path="surname" /></FONT>
                    </div>
                </div>                
                <div class="row">
                    <div class="labelcell">
                        E-mail :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="email" id="email"/>
                        <FONT color="red"><form:errors path="email" /></FONT>
                    </div>
                </div>                                
                <div class="row">
                    <div class="labelcell">
                        Phone :
                    </div>
                    <div class="cell">
                        <form:input type="text" path="phone" id="phone"/>
                        <FONT color="red"><form:errors path="phone" /></FONT>
                    </div>
                </div>                                                
                <div class="row">
                    <div class="labelcell">
                        Change Password <input type="checkbox" name="changePassword" value="true" />
                    </div>
                    <div class="cell">
                        <input type="submit" value="Update"  id="update" />
                    </div>
                </div>                        
            </div>
        </div>       
    </div>                          
</div>                         
</form:form>
