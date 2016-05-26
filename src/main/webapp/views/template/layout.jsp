<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="author" content="Temujin Penlington" />
        <meta name="company" content="Business Surveyor" />
        <meta name="abstract" content="Business Surveyor" />
        <title>
            <tiles:insertAttribute name="title" ignore="true" />
        </title>
        <tiles:insertAttribute name="stylecss" />    
        <tiles:insertAttribute name="scriptjs" />        
        <style type="text/css">
            body{
                font: 12px verdana, sans-serif; 
                margin: 0px;
            }
            header{
                background-color: #679BB7; 
                padding: 10px;
                border-radius: 10px;
                margin: 2px;
            }
            header h1{
                font-size: 18px; 
                margin: 10px 0;
            }
            .container{
                width: 100%;
                background-color: #f0f0f0; 
            }
            .nav-left{
                float: left; 
                width: 10%; 
                height:100%;
                min-height: 100%;
                background-color: #bbd2df;
                margin: 2px;
                border-radius: 10px;
            }
            .nav-left nav{
                padding: 10px;
                width: 10%;
                border-radius: 10px;
            }
            .nav-right{
                float: right; 
                width: 10%; 
                height:100%;
                min-height: 100%;
                background-color: #bbd2df;
                margin: 2px;
                border-radius: 10px;
            }
            .nav-right nav{
                padding: 10px;
                width: 10%;
                border-radius: 10px;
            }
            .content{
                float: left;
                width: 80%;
                min-height: 170px;
            }
            .content section{
                padding: 10px;
            }
            section h2{
                font-size: 16px; 
                margin: 0px;
            }
            .clearfix:after{
                content: ".";
                display: block;
                height: 0;
                clear: both;
                visibility: hidden;
            }
            footer{
                background-color: #679BB7; 
                padding: 10px;
                border-radius: 10px;
                margin: 2px;
                clear: both;
                color:#FFFFFF;
                text-align: center;
            }
            
            .ver-center {
                margin-top: auto;
                margin-bottom: auto;
            }                    
            .ver-nav{
                margin-top: 2px;
                border-width: 2px;
                border-color: #000000;
                
                width:100%;
                padding-top: 5px;
                padding-bottom: 5px;
                border-radius: 10px;
            }
            .ver-link{
                padding-bottom: 5px;      
                font-weight:bold;
            }          
            
            .hor-center {
                margin-left: auto;
                margin-right: auto;
            }
            .hor-nav{
                border-width: 2px;
                border-color: #000000;
                width:100%;
                padding-top: 5px;
                padding-bottom: 5px;
                border-radius: 10px;
            }            
            .hor-link{
                padding-left: 5px;
                padding-right: 5px;
                padding-top: 5px;
                padding-bottom: 5px;                
            } 
            
            .heading-table{
                display: table; 
                width:100%;
                border-width: 2px;
                border-color: #FFFFFF
            }
            .heading-row{
                display: table-row; 
                padding: 2px;                
            }
            .heading-main{
                display: table-cell; 
                padding: 2px;    
                font-weight:bold;
                font-size: 20px;
                text-align:center;
                color:#FFFFFF;
            }                        
            .heading-username{
                display: table-cell; 
                padding: 2px;       
                width:20%;
                padding:5px;
                text-align:left;
                font-weight:bold;
                size:20px;
                color:#FFFFFF;
            }            
            .heading-login{
                display: table-cell; 
                padding: 2px;       
                width:20%;
                padding:5px;
                text-align:right;
                font-weight:bold;
                size:20px;
                color:#FFFFFF;
            }     
            .heading-link{
                font-weight:bold;
                size:20px;
                color:#FFFFFF;                
            }
            
            .table { 
                display: table; 
            }
            .row { 
                display: table-row; 
                padding: 2px;
            }
            .cell { 
                display: table-cell; 
                padding: 2px;
            }
            
            .labelcell { 
                display: table-cell; 
                padding: 2px;
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
            
            th {
                background-color: #bbd2df;
                padding: 2px;
            }
            input {
                border-radius: 5px;
                padding-left: 2px;
            }
            select {
                border-radius: 5px;
                padding-left: 2px;
            }          
            .transparent{
                background-color: transparent;
                border-color: transparent;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <header>
                <tiles:insertAttribute name="header" />
            </header>
            <div>
                <div class="nav-left">
                    <nav>
                        <tiles:insertAttribute name="nav-left" />
                    </nav>
                </div>
                <div class="content">
                    <section>
                        <div class="table hor-center">
                            <div class="row">
                                <div class="cell">
                                    <h3>${requestScope.pageTitle}</h3>
                                    ${links}
                                </div>
                            </div> 
                            <div class="row">
                                <div class="cell">
                                    <tiles:insertAttribute name="body" />
                                </div>                                    
                            </div>
                        </div>
                    </section>
                </div>
                <div>
                    <nav>
                        <tiles:insertAttribute name="nav-right" />                        
                    </nav>
                </div>                            
            </div>
            <footer>
                <tiles:insertAttribute name="footer" />
            </footer>
        </div>
    </body>
</html>