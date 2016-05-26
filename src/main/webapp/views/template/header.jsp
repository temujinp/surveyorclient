<div class="heading-table">
    <div class="heading-row">
        <div class="heading-username">
            ${sessionScope.userModel.role} : 
            <a href="${pageContext.request.contextPath}/userEdit/${sessionScope.userModel.id}" class="heading-link" title="Edit User : ${sessionScope.userModel.userName}">${sessionScope.userModel.userName}</a>
        </div>
        <div class="heading-main">
            Medical : Surveyor
        </div>
        <div class="heading-login">
            <a href="${pageContext.request.contextPath}/userLogin" class="heading-link" title="User : Logout">Logout</a>
        </div>              
    </div>
</div>
