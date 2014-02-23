<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div>
    <spring:message code="label_blog_new" var="labelBlogNew"/>
    <spring:message code="label_blog_update" var="labelBlogUpdate"/>

    <spring:eval expression="entry.id == null ? labelBlogNew:labelBlogUpdate" var="formTitle"/>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#categoryId').change(function () {
                var selectedCategoryId = $('#categoryId').val();
                //alert('Handler for .change() called.: ' + selectedCategoryId);
                $.getJSON('/springblog/categories/listallchild/' + selectedCategoryId,
                          function (data) {
                              var options = '<option value=""></option>';
                              $.each(data, function (i, item) {
                                  //alert("Item name: " + item['categoryId'])
                                  options += '<option value="';
                                  options += item['categoryId'];
                                  options += '">';
                                  options += item['categoryId'];
                                  options += '</option>';
                              });
                              //alert("Options: " + options);
                              $("select#subCategoryId").html(options);
                          });
            });
        });
    </script>

    <h1>${formTitle}</h1>

    <div id="blogEntry">
        <form:form modelAttribute="entry" id="blogEntryForm" method="post">

            <c:if test="${not empty message}">
                <div id="message" class="${message.type}">${message.message}</div>
            </c:if>

            <form:label path="subject">
                Subject*
            </form:label>
            <form:input path="subject"/>
            <div>
                <form:errors path="subject" cssClass="error"/>
            </div>
            <p/>

            <form:label path="categoryId">
                Category*
            </form:label>
            <form:select path="categoryId">
                <c:forEach items="${categories}" var="category">
                    <c:choose>
                        <c:when test="${category.categoryId == entry.categoryId}">
                            <option value="${category.categoryId}"
                                    selected="true">${category.categoryId}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${category.categoryId}">${category.categoryId}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <form:errors path="categoryId" cssClass="error"/>
            <p/>

            <form:label path="subCategoryId">
                Sub-Category
            </form:label>
            <form:select path="subCategoryId">
                <option value=""></option>
                <c:forEach items="${subCategories}" var="subCategory">
                    <c:choose>
                        <c:when test="${subCategory.categoryId == entry.subCategoryId}">
                            <option value="${subCategory.categoryId}"
                                    selected="true">${subCategory.categoryId}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${subCategory.categoryId}">${subCategory.categoryId}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <form:errors path="subCategoryId" cssClass="error"/>
            <p/>

            <form:label path="body">
                Body*
            </form:label>
            <form:textarea cols="60" rows="8" path="body" id="entryBody"/>
            <script type="text/javascript">
                CKEDITOR.replace('entryBody', {
                    toolbar: 'Basic',
                    uiColor: '#CCCCCC'
                });
            </script>
            <div>
                <form:errors path="body" cssClass="error"/>
            </div>
            <p/>

            <form:hidden path="postDate"/>
            <form:hidden path="createdBy"/>
            <form:hidden path="createdDate"/>
            <form:hidden path="version"/>

            <button type="submit"
                    class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only">
                <span class="ui-button-text">Save</span>
            </button>

        </form:form>
    </div>

</div>
