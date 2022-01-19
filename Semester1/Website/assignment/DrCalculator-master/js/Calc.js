//interest
document.getElementById("interestsub").addEventListener("click", function(event){
  event.preventDefault()
});


function simpleInterest() {
    
    
    var principal = 0;
var interestRate = 0;
var timesCompounded = 0;
var termOfLoan = 0;
    var amount = 0;
    
  var principal = parseFloat(document.getElementById("principal").value);
  var interestRate = parseFloat(document.getElementById("interest").value);
  interestRate = interestRate / 100;
  var termOfLoan = parseFloat(document.getElementById("term").value);
  var simpleInt = principal * interestRate * termOfLoan;
  var amount = (principal + simpleInt).toFixed(2);
  document.getElementById("answer1").innerHTML ="Answer: ㅤㅤㅤㅤ"+ "Interest: €" + simpleInt.toFixed(2);
    document.getElementById("answer2").innerHTML ="Answer: ㅤㅤㅤㅤ"+ "Total plus interest: €" + amount;
    return false;
}

//area of triangle
function triangle() {
    
    let area = 0;
 let base = document.getElementById("base").value;
            let height = document.getElementById("height").value;
area = base * height / 2;
    document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+  area.toFixed(2)+ "cm";
    return false;
}

            
//area of circle
function circle() {
    let area = 0
 let radius = document.getElementById("radius").value;
            area = Math.PI * radius * radius;
document.getElementById("answer").innerHTML = "Answer: ㅤㅤㅤㅤ"+ area.toFixed(4) + "cm";
return false;
}


 //celcius to far
 function cToF() 
{
  var celcius = parseFloat(document.getElementById("celcius").value)
  var cToFahr = celcius * 9 / 5 + 32;
  var message = celcius+'\xB0C is ' + cToFahr.toFixed(2) + ' \xB0F.';
    document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ message;
}


//far to cel
function fToC() 
{
    let fahrenheit = document.getElementById("far").value;
  var fTemp = fahrenheit;
  var fToCel = (fTemp - 32) * 5 / 9;
  var message = fTemp+'\xB0F is ' + fToCel.toFixed(2) + '\xB0C.';
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ message;
}

//volumetric mass
function density(){
 var mass = parseFloat(document.getElementById("mass").value);
  var volume = parseFloat(document.getElementById("volume").value);
  var density = (mass / volume).toFixed(3)
  document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ density+" Kg/L";
}

function volume() {
  var mass = parseFloat(document.getElementById("mass").value);
  var density = parseFloat(document.getElementById("density").value);
  var volume = (mass / density).toFixed(3)
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ density+" m3";
}

function mass() {
 
  var volume = parseFloat(document.getElementById("volume").value);
    var density = parseFloat(document.getElementById("density").value);
  
    var mass = (density * volume).toFixed(3)
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ mass + " Kg";
 
}

function momentum() {
  var mass = parseFloat(document.getElementById("mass").value);
  var velocity = parseFloat(document.getElementById("velocity").value);
  var momentum =( mass * velocity).toFixed(3)
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ momentum + " Kg m/s";
  
}

function grass() {
  var sq = parseFloat(document.getElementById("squarefoot").value);
  var ans = (sq * 3000).toFixed(3)
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ ans + " blades of grass";
}

function catbmi() {
  var ribs = parseFloat(document.getElementById("ribs").value);
  var leg = parseFloat(document.getElementById("leg").value);
  var bmi = (((ribs / 0.7062) - leg) / 0.9156).toFixed(4)
  document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ bmi + " BMI";
  
}

function dogbmi() {
   var weight = parseFloat(document.getElementById("weight").value);
  var height = parseFloat(document.getElementById("height").value);
  var bmi = (weight / height).toFixed(4)
   document.getElementById("answer").innerHTML ="Answer: ㅤㅤㅤㅤ"+ bmi + " BMI";
}
