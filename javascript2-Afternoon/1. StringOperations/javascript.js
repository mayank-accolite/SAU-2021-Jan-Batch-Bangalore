function result() {
    var str = document.getElementById("input").value;
    const re = /^[A-Za-z]+$/;
    if (re.test(str) === false) {
        alert("invalid input");
        return false;
    }
    console.log(str);
    document.getElementById("p1").innerHTML = str.length;
    console.log(str.length);
    document.getElementById("p2").innerHTML = str.toUpperCase()
    console.log(str.toUpperCase);
    document.getElementById("p3").innerHTML = str.toLowerCase();
    console.log(str.toLowerCase);
    var s = str.toLowerCase();
    var strConsonants = "";
    var strVowels = "";
    var i;
    for (i in s) {
        if (s.charAt(i) == "a" || s.charAt(i) == "e" || s.charAt(i) == "i" || s.charAt(i) == "o" || s.charAt(i) == "u")
            strVowels += str.charAt(i) + ", ";
        else
            strConsonants += s.charAt(i) + ", ";
    }
    console.log(strVowels);
    document.getElementById("p4").innerHTML = strVowels;
    console.log(strConsonants); 
    document.getElementById("p5").innerHTML = strConsonants;

    return true;
}