function caseChange(str) {
    var ans = "";
    for (let i = 0; i < str.length; i++) {
        if (/[a-z]/.test(str[i])) 
        ans += str[i].toUpperCase();
        else 
        ans += str[i].toLowerCase();
    }
    return ans;
}

console.log(caseChange("w3resource"));
