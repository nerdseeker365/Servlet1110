

<h1 style="color:red;text-align:center"> Naukri.com Regsration Form No:1</h1>

<form action="controller" method="POST">
   name :: <input type="text" name="name"> <br>
   Adress:: <input type="text" name="addrs"> <br>
   age:: <input type="text" name="age"> <br>
      <input type="hidden" name="formNo" value="form1">
     <input type="Submit"  value="continue">
</form>
<br>
request count  ::  <%=application.getAttribute("reqCount") %>
