<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="header">
    <spring:url var="banner" value="/resources/images/springblog-logo.jpg"/>
    <spring:url var="buildwith" value="/resources/images/build-with.jpg"/>
    <spring:url var="home" value="/blogs"/>
    <spring:message code="button_home" var="home_label" htmlEscape="false"/>

    <spring:message code="label_login" var="labelLogin"/>
    <spring:message code="label_logout" var="labelLogout"/>
    <spring:message code="label_welcome" var="labelWelcome"/>

    <spring:url var="logoutUrl" value="/logout"/>

    <div id="appname">
        <a href="${home}" name="${fn:escapeXml(home_label)}"
           title="${fn:escapeXml(home_label)}"> <img src="${banner}"/>
        </a>
    </div>
    <div id="banner">
        <img src="${buildwith}"/>
    </div>

    <div id="userinfo">
        <shiro:authenticated>${labelWelcome}
            <shiro:principal/>
            <br/>
            <a href="${logoutUrl}">${labelLogout}</a>
        </shiro:authenticated>
    </div>

</div>
