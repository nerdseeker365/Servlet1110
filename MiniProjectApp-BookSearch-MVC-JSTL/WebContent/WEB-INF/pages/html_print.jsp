<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center">Books Beloging to
	category ${param.category }</h1>
<c:choose>
	<c:when test="${!empty listDTO }">
		<table border="1" width="100%">
			<tr>
				<th>BookId</th>
				<th>BookName</th>
				<th>Author</th>
				<th>Price</th>
				<th>Status</th>
				<th>category</th>
			</tr>
			<c:forEach var="dto" items="${listDTO}">
			     <tr>
			        <td>${dto.bookId}  </td>
			        <td>${dto.bookName}  </td>
			        <td>${dto.author}  </td>
			        <td>${dto.price}  </td>
			        <td>${dto.status}  </td>
			        <td>${dto.category}  </td>
			     </tr>
			</c:forEach>
	</c:when>
	<c:otherwise>
	      <b> no records found</b>
	</c:otherwise>
</c:choose>



<br>
<br>
<a href="searchPage"><img src='images/home.png'></a>

<a href="JavaScript:showPrint()"><img src='images/print.png'></a>

<script language="JavaScript">
	function showPrint() {
		frames.focus();
		frames.print();
	}
</script>


