<%-- 
    Document   : weeklytimetable
    Created on : Jun 27, 2022, 11:13:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="dava" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week timetable</title>
    </head>
    <body>
        <form action="timetable" method="POST">
            <%-- display array of campus. --%> 
            <%-- choose campus. --%> 
            <%-- type name lecture. --%> 
            Campus: <select name="campus">
                <dava:forEach items="${requestScope.campusList}" var="aCampus">
                    <option value="${aCampus}"
                            <%-- set initial value --%>
                            <dava:if test = "${aCampus eq param.campus}">
                                selected
                            </dava:if>

                            >${aCampus}</option>
                </dava:forEach>
            </select><br/>
            <%-- choose week. (like choose campus)--%> 
            Week: <select name="numberOfWeek">
                <dava:forEach items="${requestScope.weekList}" var="aWeekly">
                    <option value="${aWeekly.no}"
                            <%-- set initial value --%>
                            <dava:if test = "${aWeekly.getNo() == param.numberOfWeek}">
                                selected
                            </dava:if>

                            >${aWeekly.toString()}</option>
                </dava:forEach>
            </select><br/>
            Lecturer: <input type="text" name ="lecture" value="${param.lecture}"/>
            <input type="submit" value="View"/>
        </form>
<%--print date--%>  
        
<%--print 8 slot--%> 
        <%--print slot number--%>
        <br/><p>Slot 1: </p>
        <dava:forEach items="${requestScope.slot1}" var="aCouse">
            <%--print a lesson--%>
            <p>   ${aCouse}</p>
        </dava:forEach>
            
        <br/><p>Slot 2: </p>
        <dava:forEach items="${requestScope.slot2}" var="aCouse">
            <%--print a lesson--%>
            <p>   ${aCouse}</p>
        </dava:forEach>
        
        <br/><p>Slot 3: </p>
        <dava:forEach items="${requestScope.slot3}" var="aCouse">
            <%--print a lesson--%>
            <%--CHANGE LESSON TO A LINK TO SERVLET that is responsible for do attendance--%>
            <p><a href ="attendanceForACouse?id=${aCouse.id}&group=${aCouse.group}&course=${aCouse.couse}&instructor=${aCouse.instructor}
                  &slot=${aCouse.slot}&room=${aCouse.room}&date=${aCouse.date}" target="_blank">   ${aCouse}</a></p>
        </dava:forEach>
            
        <br/><p>Slot 7: </p>
        <dava:forEach items="${requestScope.slot7}" var="aCouse">
            <%--print a lesson--%>
            <p>   ${aCouse}</p>
        </dava:forEach>
    </body>
</html>
