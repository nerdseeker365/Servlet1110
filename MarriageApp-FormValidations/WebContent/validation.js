      
function validate(frm){
    	    // change vflag to yes indicating client side form validations are done
    	      frm.vflag.value="yes";
              // empty old error messages
              document.getElementById("nameErr").innerHTML="";
              document.getElementById("ageErr").innerHTML="";
             //read form data
             var  name=frm.pname.value;
             var  age=frm.page.value;
             
             //write client side form validation logic
             if(name==""){
                document.getElementById("nameErr").innerHTML="person name is required";
                  frm.pname.focus();
                  return false;
             }
             
             if(age==""){
                document.getElementById("ageErr").innerHTML="person age is required";
                frm.page.focus();
                  return false;
             }
             else if(isNaN(age)){
                  document.getElementById("ageErr").innerHTML="person age should be numeric value";
                frm.page.focus();
                frm.page.value="";
                  return false;
             }
             else if(age<=0 || age>125){
                  document.getElementById("ageErr").innerHTML="person age must be in the range of 1 through 125";
                frm.page.focus();
                frm.page.value="";
                  return false;
             }
             return true;
         }//function