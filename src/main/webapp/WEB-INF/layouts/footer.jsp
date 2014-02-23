<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div id="footer">
    <spring:url value="/blogs" var="homeUrl"/>

    <spring:message code="label_home" var="labelHome"/>
    <spring:message code="label_locale_en" var="labelEn"/>
    <spring:message code="label_local_zh" var="labelZh"/>

	<span>
        <a href="${homeUrl}">${labelHome}</a> |
        <a href="${homeUrl}?lang=en">${labelEn}</a> |
        <a href="${homeUrl}?lang=zh">${labelZh}</a>
	</span>

    <spring:message code="global_sponsored" htmlEscape="false"
                    var="sponsored"/>
	<span style="padding-right: 0"> <a href="http://spring.io"
                                       title="${fn:escapeXml(sponsored)}">${fn:escapeXml(sponsored)}
	</span>
</div>
