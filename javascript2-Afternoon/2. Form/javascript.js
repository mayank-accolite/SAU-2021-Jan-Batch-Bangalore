function myFunction() {
    var element = document.getElementById("myForm").elements
    var inputText = document.getElementById("email").value;
    const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (re.test(inputText) === false) {
        alert("invalid email");
        return false;
    }


    var str = document.getElementById("firstName").value;
    const ree = /^[A-Za-z]+$/;
    if (ree.test(str) === false) {
        alert("invalid FirstName");
        return false;
    }


    var strr = document.getElementById("lastName").value;
    const reee = /^[A-Za-z]+$/;
    if (reee.test(strr) === false) {
        alert("invalid LastName");
        return false;
    }


    var ele = document.getElementsByName('gender');

    for (i = 0; i < ele.length; i++) {
        if (ele[i].checked) {
            var obj = {};
            for (var i = 0; i < element.length; i++) {
                var item = element.item(i);
                obj[item.name] = item.value;
            }
            var s=JSON.stringify(obj);
            
            document.getElementById("formData").innerHTML = JSON.stringify(obj);
            return true;
        }

    }
    alert("Select Gender");
    return false;


}