<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<div>
    <h1>Blog Comment</h1>

    <div id="blogInfo">
        <h3>For blog entry subject: ${entry.subject}</h3>
    </div>

    <div id="blogComment">
        <form:form modelAttribute="comment" id="blogCommentForm" method="post">

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

            <form:label path="body">
                Body*
            </form:label>
            <form:textarea cols="60" rows="8" path="body" id="commentBody"/>
            <script type="text/javascript">
                CKEDITOR.replace('commentBody', {
                    toolbar: 'Basic',
                    uiColor: '#CCCCCC'
                });
            </script>
            <div>
                <form:errors path="body" cssClass="error"/>
            </div>
            <p/>

            <form:label path="replyTo">
                Reply To
            </form:label>
            <form:select path="replyTo">
                <option value=""></option>
                <c:forEach items="${replyTos}" var="replyTo">
                    <c:choose>
                        <c:when test="${replyTo == comment.replyTo}">
                            <option value="${replyTo}" selected="true">${replyTo}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${replyTo}">${replyTo}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
            <div>
                <form:errors path="replyTo" cssClass="error"/>
            </div>
            <p/>

            <form:hidden path="postDate"/>
            <form:hidden path="postBy"/>
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
