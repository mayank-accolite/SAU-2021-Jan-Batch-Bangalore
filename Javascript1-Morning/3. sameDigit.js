function sameDigit(num) {
    var temp = num % 10;
    while (num!==0) {
      if (num % 10 !== temp) 
      return false;
      num = Math.floor(num / 10);
    }
    return true
  }
  
  console.log(sameDigit(1234));