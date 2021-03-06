<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>

    <spring:theme code="styleSheet" var="app_css"/>
    <spring:url value="/${app_css}" var="app_css_url"/>

    <spring:url value="/resources/spring/Spring.js" var="spring_url"/>
    <spring:url value="/resources/scripts/jquery-1.7.1.js" var="jquery_url"/>
    <spring:url value="/resources/scripts/jquery-ui-1.8.16.custom.min.js" var="jquery_ui_url"/>

    <spring:url value="/resources/styles/custom-theme/jquery-ui-1.8.16.custom.css"
                var="jquery_ui_theme_css"/>

    <spring:url value="/resources/jqgrid/css/ui.jqgrid.css" var="jqgrid_css"/>

    <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_theme_css}"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${jqgrid_css}"/>

    <!-- Get the user local from the page context (it was set by Spring MVC's locale resolver) -->
    <c:set var="userLocale">
        <c:set var="plocale">${pageContext.response.locale}</c:set>
        <c:out value="${fn:replace(plocale, '_', '-')}" default="en"/>
    </c:set>

    <!-- CKEditor -->
    <script type="text/javascript" src="/springblog/resources/ckeditor/ckeditor.js"><!-- /
    required
    for FF3 and
    Opera --></script>
    <script type="text/javascript" src="/springblog/resources/ckeditor/adapters/jquery.js"><!-- /
    required
    for FF3 and
    Opera --></script>

    <script src="${spring_url}" type="text/javascript"><!-- /
    required
    for FF3 and
    Opera --></script>
    <script src="${jquery_url}" type="text/javascript"><!-- /
    required
    for FF3 and
    Opera --></script>
    <script src="${jquery_ui_url}" type="text/javascript"><!-- /
    required
    for FF3 and
    Opera --></script>

    <!-- jqGrid -->
    <script type="text/javascript"
            src="/springblog/resources/jqgrid/js/i18n/grid.locale-en.js"><!-- /
    required
    for FF3 and
    Opera --></script>
    <script type="text/javascript" src="/springblog/resources/jqgrid/js/jquery.jqGrid.min.js"><!-- /
    required
    for FF3 and
    Opera --></script>

    <script type="text/javascript">
        alert("Hello 123");
        $(function () {
            alert("Hello");
            $("#list").jqGrid({
                                  url: '/springblog/blogs/listgrid',
                                  datatype: 'json',
                                  mtype: 'GET',
                                  colModel: [
                                      {name: 'subject', label: 'Subject', index: 'subject', width: 55},
                                      {name: 'shortBody', label: 'Body', index: 'shortBody', width: 90},
                                      {name: 'categoryId', label: 'Category', index: 'categoryId', width: 80, align: 'right'},
                                      {name: 'subCategoryId', label: 'Sub-Category', index: 'subCategoryId', width: 80, align: 'right'},
                                      {name: 'postDateString', label: 'Post Date', index: 'postDateString', width: 80, align: 'right'},
                                      {name: 'createdBy', label: 'Post By', index: 'createdBy', width: 80, sortable: false}
                                  ],
                                  jsonReader: {
                                      root: "entryData",
                                      page: "currentPage",
                                      total: "totalPages",
                                      records: "totalRecords",
                                      repeatitems: false,
                                      id: "0"
                                  },
                                  pager: '#pager',
                                  rowNum: 10,
                                  rowList: [10, 20, 30],
                                  sortname: 'id',
                                  sortorder: 'desc',
                                  viewrecords: true,
                                  gridview: true,
                                  caption: 'Blog Posting Entries',
                                  beforeRequest: function () {
                                      alert('Before request');
                                  }
                              });
        });
    </script>

    <spring:message code="application_name" var="app_name" htmlEscape="false"/>
    <title><spring:message code="welcome_h3" arguments="${app_name}"/></title>
</head>

<body class="tundra spring">
<h1>Hello</h1>

<table id="list">
    <tr>
        <td/>
    </tr>
</table>
<div id="pager"></div>

</body>
</html>
