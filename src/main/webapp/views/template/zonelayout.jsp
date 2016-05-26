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
            div {
                border : 0px; 
            }
            #north    { 
                margin:0;  
                padding:0em;  
            }        
            #south    { 
                margin:0;  
                padding:0em;  
            }        
            #east     { 
                margin:0;  
                padding:0em;  
                width:6em; 
                height:40em; 
                float:right; 
                margin-right:0em }        
            #west     { 
                margin:0;  
                padding:0em;  
                width:6em; 
                height:40em; 
                float:left; 
                margin-left:0em }        
            #center   { 
                margin:0;  
                padding:0em;  
                padding-bottom:0em; 
            }        
            #center:after    { 
                content:' '; 
                clear:both; 
                display:block; 
                height:0; 
                overflow:hidden 
            }    
            
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
            }            
                        
            .ver-center {
                margin-top: auto;
                margin-bottom: auto;
            }                    
            .ver-nav{
                margin-top: 2px;
                padding-left: 5px;
                border-width: 0px;                
                width: 100%;
                height :98%;
                padding-top: 5px;
                padding-bottom: 5px;
                border-radius: 10px;
                background-color: #bbd2df;                
            }
            .ver-link{
                font-weight:bold;
                margin: 5px;
            }              
            
            .hor-center {
                margin-left: auto;
                margin-right: auto;
            }            
            .hor-nav{
                border-width: 0px;
                width: 100%;
                padding-top: 5px;
                padding-bottom: 5px;
                border-radius: 10px;
                text-align :center;
            }            
            .hor-link{
                padding-left: 5px;
                padding-right: 5px;
                padding-top: 5px;
                padding-bottom: 5px;                
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
            
            
            
            .heading-table{
                display: table; 
                width: 99%;
                border-width: 0px;
                border-color: transparent;
                background-color: #679BB7; 
                padding: 10px;
                border-radius: 10px;
                margin: 0px;                    
            }
            .heading-row{
                display: table-row; 
                padding: 2px;     
                border-width: 0px;
                border-color: transparent;                
            }
            .heading-main{
                display: table-cell; 
                padding: 2px;    
                font-weight:bold;
                font-size: 20px;
                text-align:center;
                color:#FFFFFF;
                border-width: 0px;
                border-color: transparent;                
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
                border-width: 0px;
                border-color: transparent;                
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
                border-width: 0px;
                border-color: transparent;                
            }     
            .heading-link{
                font-weight:bold;
                size:20px;
                color:#FFFFFF;                
            }            
             
            .footer{
                background-color: #679BB7; 
                padding: 10px;
                border-radius: 10px;
                margin: 2px;
                clear: both;
                color:#FFFFFF;
                text-align: center;
            }            
            
            .labelcell { 
                display: table-cell; 
                padding: 2px;
                text-align: right;
                width: 50%;
                border-width: 0px;
                border-color: transparent;                
            }            
            .titleCell { 
                display: table-cell; 
                text-align : center;
                font-weight: bold;
                background-color: #679BB7;
                padding: 4px;
                border-radius: 10px;
                color:#FFFFFF;       
                border-width: 0px;
                border-color: transparent;                
            }            
            
            .table { 
                display: table; 
                border-width: 0px;
                border-color: transparent;                
            }
            .row { 
                display: table-row; 
                padding: 2px;
                border-width: 0px;
                border-color: transparent;                
            }
            .cell { 
                display: table-cell; 
                padding: 2px;
                border-width: 0px;
                border-color: transparent;                
            }
            
            .transparent{
                background-color: transparent;
                border-color: transparent;
            }         
            
            caption{
                text-align : center;
                font-weight: bold;
                background-color: #679BB7;
                padding: 4px;
                border-radius: 10px;
                color:#FFFFFF;       
                border-width: 0px;
                border-color: transparent;                 
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
            <div id="north">
                <tiles:insertAttribute name="header" />
            </div>
            <div id="east">
                <tiles:insertAttribute name="nav-right" />                        
            </div>
            <div id="west">
                <tiles:insertAttribute name="nav-left" />
            </div>
            <div id="center">
                <div class="table hor-center">
                    <div class="row">
                        <div class="cell">
                            <h3>${requestScope.pageTitle}</h3>
                            ${crudLinks}
                        </div>
                    </div> 
                    <div class="row">
                        <div class="cell">
                            <tiles:insertAttribute name="body" />
                        </div>                                    
                    </div>
                </div>
            </div>
            <div id="south">
                <tiles:insertAttribute name="footer" />                    
            </div>                
        </div>
    </body>
</html>