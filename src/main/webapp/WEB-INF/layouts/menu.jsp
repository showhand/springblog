<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div id="menu">
    <script type="text/javascript">
        $(function () {
            $('#dialog-hint').dialog({
                                         autoOpen: false,
                                         height: 140,
                                         modal: true
                                     });

            $('#hintLink').click(function () {
                $('#dialog-hint').dialog('open');
            });
        });
    </script>

    <spring:message code="label_please_login_to_post_entries" var="labelPostEntries"/>
    <spring:message code="label_new_blog_posting" var="labelNewPostEntry"/>
    <spring:message code="label_user_maintenance" var="labelUserMaintenance"/>
    <spring:url var="loginUrl" value="/login"/>
    <spring:message code="label_login" var="labelLogin"/>
    <spring:message code="label_username" var="labelUserName"/>
    <spring:message code="label_password" var="labelPassword"/>
    <spring:message code="label_login_hint" var="labelLoginHint"/>

    <shiro:authenticated>
        <a href="/springblog/blogs?form"><h4>${labelNewPostEntry}</h4></a>
    </shiro:authenticated>

    <shiro:notAuthenticated>
        <h4>${labelPostEntries}</h4>

        <%
            String
                    error =
                    (String) request.getAttribute(
                            FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
            if (error != null) {
        %>
        <div class="alert alert-error input-medium controls">
            <button class="close" data-dismiss="alert">×</button>
            登录失败，请重试.
        </div>
        <%
            }
        %>

        <div id="login">
            <form name="loginForm" action="${loginUrl}" method="post">
                <table>
                    <caption align="left">${labelLogin}:</caption>
                    <tr>
                        <td>${labelUserName}:</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>${labelPassword}:</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input name="submit" type="submit"
                                                              value="${labelLogin}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><a href="javascript:void(0);"
                                                          id="hintLink">${labelLoginHint}</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </shiro:notAuthenticated>

    <shiro:hasRole name="ROLE_ADMIN">
        <a href="javascript:alert('Sorry! Function not yet implemented.');">
            <h4>${labelUserMaintenance}</h4></a>
    </shiro:hasRole>

    <div id="dialog-hint" title="Login Default Users">
        <table>
            <tr>
                <td>Normal user:</td>
                <td>user/user</td>
            </tr>
            <tr>
                <td>Admin user:</td>
                <td>admin/admin</td>
            </tr>
        </table>
    </div>

</div>
