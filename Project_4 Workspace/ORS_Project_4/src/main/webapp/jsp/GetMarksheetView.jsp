<%@page import="in.co.rays.proj4.controller.GetMarksheetCtl"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="Header.jsp"%>

    <jsp:useBean id="bean" class="in.co.rays.proj4.bean.MarksheetBean"
        scope="request"></jsp:useBean>

    <center>
        <h1>Get Marksheet</h1>

        <font color="red"> <%=ServletUtility.getErrorMessage(request)%>
        </font>

        <H2>
            <font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
            </font>
        </H2>

        <form action="<%=ORSView.GET_MARKSHEET_CTL%>" method="post">

            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <table>
                <label>RollNo :</label>&emsp;
                <input type="text" name="rollNo"
                    value="<%=ServletUtility.getParameter("rollNo", request)%>">&emsp;
                <input type="submit" name="operation" value="<%=GetMarksheetCtl.OP_GO%>">
                <br>
                <font color="red"><%=ServletUtility.getErrorMessage("rollNo", request)%></font>

                <%
                    if (bean.getRollno() != null && bean.getRollno().trim().length() > 0) {
                %>

                <tr>
                    <td>Rollno :</td>
                    <td><%=DataUtility.getStringData(bean.getRollno())%></td>
                </tr>
                <tr>
                    <td>Name :</td>
                    <td><%=DataUtility.getStringData(bean.getStudentname())%></td>
                </tr>
                <tr>
                    <td>Physics :</td>
                    <td><%=DataUtility.getStringData(bean.getPhysics())%></td>
                </tr>
                <tr>
                    <td>Chemistry :</td>
                    <td><%=DataUtility.getStringData(bean.getChemistry())%></td>
                </tr>
                <tr>
                    <td>Maths :</td>
                    <td><%=DataUtility.getStringData(bean.getMaths())%></td>

                </tr>
                <tr>
                    </td>
                </tr>
            </table>
            <%
                }
            %>
        </form>
    </center>
    <%@ include file="Footer.jsp"%>
</body>
</html>