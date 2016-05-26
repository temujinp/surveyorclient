<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Surveyor : Login</title>
    </head>
    <body>    
    <style>
        .table{
            background-color: #bbd2df;
            border-width: 2px;
            border-color: #000000;
            border-radius: 10px;
            padding: 5px;
            border-radius: 10px;
            position:fixed;
            top:50%;
            left:50%;
            transform: translate(-50%, -50%);
        }
        input {
            border-radius: 5px;
            padding-left: 2px;
        }
        .labelcell { 
            display: table-cell; 
            padding: 5px;
            text-align: right;
            width: 50%;
        }            
        .titleCell { 
            display: table-cell; 
            text-align : center;
            font-weight: bold;
            background-color: #679BB7;
            padding: 4px;
            border-radius: 10px;
            color:#FFFFFF;                
        } 
    </style>
        <form:form method="post" action="${pageContext.request.contextPath}/userLogin" modelAttribute="userModel" id="userLogin" commandName="userModel">
            <table class="table">
                <tr>
                    <td colspan="2" class="titleCell">
                        Surveyor : Login
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${not empty message}">
                            <div id="message" style="color:red;font-weight: bold;">${message}</div>	
                        </c:if>
                    </td>
                </tr>                
                <tr>
                    <td class="labelcell">
                        Username :
                    </td>
                    <td>
                        <form:input path="userName" size="10" /><FONT color="red"><form:errors path="userName" /></FONT>
                    </td>
                </tr>
                <tr>
                    <td class="labelcell">
                        Password :
                    </td>
                    <td>
                        <form:password  path="password" size="10" /><FONT color="red"><form:errors path="password" /></FONT>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Login" />
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2">
                    <br/>
                    <br/>
            <table>
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Password</th>                        
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>joe</td>                        
                        <td>pwd1</td>                        
                        <td>ADMIN</td>
                    </tr>
                    <tr>
                        <td>ed</td>                        
                        <td>pwd2</td>                        
                        <td>SUPER</td>
                    </tr>
                    <tr>
                        <td>mary</td>                        
                        <td>pwd3</td>                        
                        <td>WORKER</td>
                    </tr>
                    <tr>
                        <td>jane</td>                        
                        <td>pwd4</td>                        
                        <td>AUDITOR</td>
                    </tr>
                </tbody>
            </table>       
                        
                        
                    </td>
                </tr>
                
            </table>
        </form:form>
    
    
    </body>
</html>