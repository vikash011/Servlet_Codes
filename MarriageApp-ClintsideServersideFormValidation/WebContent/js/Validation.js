/**
 * Validation.js
 */


function validate(frm){
	
	alert("clint side...");
	
	//removing error messages
	document.getElementById("errName").innerHTML="";
	document.getElementById("errAge").innerHTML="";
	
	//reading input  form data
	 let name= frm.pname.value;
     let age= frm.page.value;
     let flag= true;
    

   //clint side form validation
      
    if(name==""){//name required
	   document.getElementById("errName").innerHTML="<i>Person Name is rquired</i>";
       flag=false;
       frm.pname.focus();
    }else if(name.length<5){//min length
	    doucment.getElementById("errName").innerHTML="<i>Person Name must have min 5 characters  </i>";
       flag=false;
      frm.pname.focus();
    }if(age==""){//age required
        document.getElementById("errAge").innerHTML="<i>Person Age is required</i>";
      flag=false;
      frm.page.focus();     
     }else if(isNAN(age)){//checking age value
	     document.getElementByid("errAge").innerHTML="<i>Person Age must be Numric</i>"
	     flag= false;
         frm.page.focus();
     }else if(age<1||age>125){//age between 1 to 125
	    document.getElementByid("errAge").innerHTML="<i>Person Age must be between 1 to 125</i>";
       flag=flase;
       frm.page.focus();
     }

      frm.vflag.value="yes";
      return flag;
}