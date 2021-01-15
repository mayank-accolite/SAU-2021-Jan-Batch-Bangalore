function student() {

    this.firstName = "MAYANK";
    this.lastName = "BANDIL";
    this.gender = "MALE";
    this.rollno = "171114100";
    this.dob = "27/07/1999";
    this.occupation="";
    
    this.setFirstName = function (name) {
        this.firstName = name;
    }
    this.setLastName = function (name) {
        this.lastName = name;
    }
    this.setrollno = function (num) {
        this.rollno = num;
    }
    this.setDOB=function(date)
    {
        this.dob=date;
    }
    this.setoccupation = function (occupatio) {
        this.occupation = occupatio;
    }
    this.info = function () {
        console.log(this.firstName + "\n" + this.lastName + "\n" + this.gender + "\n" + this.rollno + "\n" + this.dob + "\n" + this.occupation);
    }

}

var person1 = new student();
var person2;

function occ() {
    person1.setoccupation(document.getElementById("occupation").value);
    person1.info();
}

function stud() {
    person2=new student();
    person2.setFirstName(document.getElementById("firstName").value);    
    person2.setLastName(document.getElementById("lastName").value);    
    person2.setrollno(document.getElementById("rollno").value);    
    person2.setoccupation(document.getElementById("occup").value);    
    person2.setDOB(document.getElementById("dob").value);
    person2.info()
}

function details() {
    var roll_no=document.getElementById("details").value;
    if(roll_no==person1.rollno) person1.info();
    if(roll_no==person2.rollno) person2.info();
    

}







