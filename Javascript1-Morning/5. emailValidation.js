function myFunction() {
    var element = document.getElementById("myForm").elements
    var obj ={};
    for(var i = 0 ; i < element.length ; i++){
        var item = element.item(i);
        obj[item.name] = item.value;
    }
    document.getElementById("formData").innerHTML = JSON.stringify(obj);
    var inputText=document.getElementById("email").value;
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(re.test(inputText)===false){
        alert("invalid email");
        return false;
    }
    return true;
}