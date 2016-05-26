<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Surveyor : No Permission</title>
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
            <table class="table">
                <tr>
                    <td colspan="2" class="titleCell">
                        Surveyor : ${message}
                    </td>
                </tr>
                <tr>
                    <td class="labelcell">
                        Login :
                    </td>
                    <td>
                        <a href="userLogin">Back to login</a>
                    </td>
                </tr>
            </table>
    
    </body>
</html>        