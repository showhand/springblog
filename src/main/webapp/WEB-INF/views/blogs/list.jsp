<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>任务管理</title>
</head>

<body>
<div>
    <spring:message code="label_blog_posting_entries" var="labelBlogPostingEntries"/>
    <spring:message code="label_post_date" var="labelPostDate"/>
    <spring:message code="label_subject" var="labelSubject"/>
    <spring:message code="label_body" var="labelBody"/>
    <spring:message code="label_category" var="labelCategory"/>
    <spring:message code="label_sub_category" var="labelSubCategory"/>
    <spring:message code="label_post_by" var="labelPostBy"/>
    <spring:message code="label_from_post_date" var="labelFromPostDate"/>
    <spring:message code="label_to_post_date" var="labelToPostDate"/>

    <script type="text/javascript">
        $(function () {
            $("#list").jqGrid({
                                  url: '/springblog/blogs/listgrid',
                                  datatype: 'json',
                                  mtype: 'GET',
                                  colNames: ['${labelPostDate}', '${labelSubject}', '${labelBody}',
                                             '${labelCategory}', '${labelSubCategory}',
                                             '${labelPostBy}'],
                                  colModel: [
                                      {name: 'postDateString', index: 'postDate', width: 85, align: 'center'},
                                      {name: 'subject', index: 'subject', width: 115},
                                      {name: 'shortBody', index: 'shortBody', width: 240, sortable: false},
                                      {name: 'categoryId', index: 'categoryId', width: 80, align: 'center'},
                                      {name: 'subCategoryId', index: 'subCategoryId', width: 80, align: 'center', sortable: false},
                                      {name: 'createdBy', index: 'createdBy', width: 80, sortable: false}
                                  ],
                                  jsonReader: {
                                      root: "entryData",
                                      page: "currentPage",
                                      total: "totalPages",
                                      records: "totalRecords",
                                      repeatitems: false,
                                      id: "id"
                                  },
                                  pager: '#pager',
                                  rowNum: 10,
                                  rowList: [10, 20, 30],
                                  sortname: 'postDateString',
                                  sortorder: 'desc',
                                  viewrecords: true,
                                  gridview: true,
                                  height: 450,
                                  caption: '${labelBlogPostingEntries}',
                                  onSelectRow: function (id) {
                                      document.location.href = "/springblog/blogs/" + id;
                                  }
                              });

            $('#mysearch').jqGrid('filterGrid', '#list', {
                filterModel: [
                    {label: '${labelSubject}', name: 'subject'},
                    {label: '${labelCategory}', name: 'categoryId', stype: 'select', surl: '/springblog/categories/listforsearch'},
                    {label: '${labelFromPostDate}', name: 'fromPostDate', stype: 'text'},
                    {label: '${labelToPostDate}', name: 'toPostDate', stype: 'text'}
                ],
                formtype: 'vertical',
                enableSearch: true,
                enableClear: true,
                autosearch: false
            });

            $('#sg_fromPostDate').datepicker({ dateFormat: 'yy-mm-dd' });
            $('#sg_toPostDate').datepicker({ dateFormat: 'yy-mm-dd' });

        });

    </script>

    <div id="mysearch"><br/></div>
    <br/>

    <div>
        <table id="list">
            <tr>
                <td/>
            </tr>
        </table>
    </div>
    <div id="pager"></div>

</div>
</body>
</html>