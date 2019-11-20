<%@ page language="java" import="java.util.*,com.nt.dto.BookDTO" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
      //read request param, request attribute vlaues
        String  category=request.getParameter("category");
        List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("listDTO");
        
        response.setContentType("application/ms-excel");
        response.addHeader("Content-Disposition","attachment;fileName=books.xls");
        
     %>
     <h1 style="color:red;text-align:center">Books Beloging to category <%=category %> </h1>
     
     <table border="1" width="100%" >
        <tr>
          <th>BookId</th><th>BookName</th><th>Author</th><th>Price</th><th>Status</th><th>category</th>
        </tr>
        
        <%
           if(listDTO!=null){
               for(BookDTO dto:listDTO){  %>
             <tr>
               <td><%=dto.getBookId() %>  </td>
               <td><%=dto.getBookName() %>  </td>
               <td><%=dto.getAuthor() %>  </td>
               <td><%=dto.getPrice() %>  </td>
               <td><%=dto.getStatus() %>  </td>
               <td><%=dto.getCategory() %>  </td>
             </tr>
        <%   } %>
              </table>
           <%} //if
             else{  %>
                    <h1 style='color:red;text-align:center'>No books Found </h1>
               <%}     
            %>   
            
  <br><br>
   
               
   