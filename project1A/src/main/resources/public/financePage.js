/**
 * 
 */
 
 
 /**
 * 
 */
 
var FmNumber = 0; 
 
 
 //public Employees(int employeeId, int employeeNumber, String username, String password, String name) {
 function Finance(name, financeNumber){
    this.name = name;
    this.financeNumber = financeNumber;
    
}
//public Reimbursement(int reimbursementId, int rembursementNumber, int employeeId, String reimursementType,
//			String approveStatus, double amount, String description, Timestamp timestamp) {
		
 function Reimbursement(reimbursementId, reimbursementNumber, employeeId, reimbursementType, approveStatus, amount, description, timeStamp){
	this.reimbursementId = reimbursementId;
	this.reimbursementNumber = reimbursementNumber;
	this.employeeId = employeeId;
	this.reimbursementType = reimbursementType;
	this.approveStatus = approveStatus;
	this.amount = amount;
	this.description = description;
	this.timestamp = timeStamp;
}
 
 
function addRow(aReimbursement){
    // let fakeObject = {id: 1, "name":"bob", age:12, birth_year:"fake birth year"};


    //Append this onto my table, 
    let tableBody = document.getElementById("TableBody");

    //Creating a table row
    let tableRow = document.createElement("tr");

    //Create the columns
    let RNumberColumn = document.createElement("td");
    let FNumberColumn = document.createElement("td");
    let ReimTypeColumn = document.createElement("td");
    let ApproveStatusColumn = document.createElement("td");
    let AmountColumn = document.createElement("td");
    let DescriptionColumn = document.createElement("td");
    let TimeColumn = document.createElement("td");


    //assigning the "text value" to our columns 
//Reimbursement(index.reimbursementId, index.rembursementNumber, 
//index.employeeId, index.reimursementType, index.approveStatus, index.amount, index.description, index.timestamp)
    
    RNumberColumn.innerText = aReimbursement.reimbursementNumber;
    FNumberColumn.innerText = aReimbursement.employeeId;
    ReimTypeColumn.innerText = aReimbursement.reimbursementType;
    ApproveStatusColumn.innerText = aReimbursement.approveStatus;
    AmountColumn.innerText = aReimbursement.amount;
    DescriptionColumn.innerText = aReimbursement.description;
    TimeColumn.innerText =aReimbursement.timestamp;
    


    //attach the columns to our newly created row 
    tableRow.appendChild(RNumberColumn );
    tableRow.appendChild(FNumberColumn);
    tableRow.appendChild(ReimTypeColumn);
    tableRow.appendChild(ApproveStatusColumn);
    tableRow.appendChild(AmountColumn);
    tableRow.appendChild(DescriptionColumn);
    tableRow.appendChild(TimeColumn);

    //attach the row itself to the table
    tableBody.appendChild(tableRow);

 }
 
 function getAllTickets(){
	//console.log("add all the rows in the table for employee en: "+ emNumber);
	//var empolyNumber = empolyeesNumber;
	let xhttp = new XMLHttpRequest();
	//let employeesNumber;
	xhttp.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 200){
	
		let responseObject = JSON.parse(this.responseText);

        //console.log("the response text: "+this.responseText);
        //console.log("the responseObject: "+responseObject);
        //console.log(responseObject.name);
        //console.log(responseObject.employeeNumber);
        //console.log(responseObject.types[0].type.name);
        //console.log(responseObject.sprites.front_shiny);
            //We want to turn this into something our DOMManipulation function expects. 
            //A pokemon with, name, image, and type. 

 for(let index in responseObject){
	//console.log("the index");
   // console.log(index);
    
    let reimbursementObject = new Reimbursement(responseObject[index].reimbursementId, responseObject[index].rembursementNumber, responseObject[index].employeeId, responseObject[index].reimursementType, responseObject[index].approveStatus, responseObject[index].amount, responseObject[index].description, responseObject[index].timeStamp);
		
		//console.log("reimbursementId: " +responseObject[index].reimbursementId);
		//console.log("reimbursementNumber: " +responseObject[index].rembursementNumber);
		//console.log("employeeId: " +responseObject[index].employeeId);
		//console.log("reimbursementType: " +responseObject[index].reimursementType);
		//console.log("approveStatus: " +responseObject[index].approveStatus);
		//console.log("amount: " +responseObject[index].amount);
		//console.log("description: " +responseObject[index].description);
		//console.log("timestamp: " +responseObject[index].timeStamp);
		//console.log("the object");
		//console.log(reimbursementObject);
		
		//console.log("the en: "+emNumber);
		addRow(reimbursementObject);
    

}
 
 
        
        
        
           
        }
        
    }
    
    xhttp.open("GET", "http://localhost:7001/getAllReimbursements");

    xhttp.send();
	
	
}




function setNameAndNumber(finance){
	document.getElementById("financename").innerText = finance.name;
	document.getElementById("financeNumber").innerText = finance.financeNumber;
	
	//console.log("Employee Name Should Be Here");
	//console.log("Employee Number Should Be Here: "+ employees.employeeNumber);
	// FmNumber = finance.financeNumber;
	
	//console.log("Employee Number: "+ en);
	 //getAllEmployeeTickets(en); 
}



function getFinance() {
	
	let xhttp = new XMLHttpRequest();
	//var employeeNumber;
	xhttp.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 200){
	
		let responseObject = JSON.parse(this.responseText);

            
        //console.log(responseObject);
        //console.log(responseObject.name);
        //console.log(responseObject.financeNumber);
        //console.log(responseObject.types[0].type.name);
        //console.log(responseObject.sprites.front_shiny);
            //We want to turn this into something our DOMManipulation function expects. 
            //A pokemon with, name, image, and type. 

        let financeObject = new Finance(responseObject.name,
                            responseObject.financeNumber);
		
        setNameAndNumber(financeObject);
        
        //FmNumber = financeObject.employeeNumber;
        
        //console.log("getN en: "+employeeObject.employeeNumber);
        //console.log("getN var en: "+emNumber);
        
         
        }
        
    }
    
    xhttp.open("GET", "http://localhost:7001/finance");

    xhttp.send();
    
    //console.log("getN var en return: "+emNumber);
    
    //return employeeNumber;
	
}
 
 window.onload = function() {
	//console.log("about to call finance");
	getFinance();
	//	console.log("after call to finance");
	//console.log(" wnen: "+en);
	//setNameAndNumber();
  getAllTickets();
}

function getAllApprove(Status){
	//console.log("add all the rows in the table for employee en: "+ emNumber);
	//var empolyNumber = empolyeesNumber;
	let xhttp = new XMLHttpRequest();
	//let employeesNumber;
	xhttp.onreadystatechange = function(){
	
	if(this.readyState == 4 && this.status == 200){
	
	let tableBody = document.getElementById("TableBody");
	
	console.log("TableBody");
	console.log(tableBody.delete);
	

	
	
		let responseObject = JSON.parse(this.responseText);

        console.log("the response text: "+this.responseText);
        console.log("the responseObject: "+responseObject);
        //console.log(responseObject.name);
        //console.log(responseObject.employeeNumber);
        //console.log(responseObject.types[0].type.name);
        //console.log(responseObject.sprites.front_shiny);
            //We want to turn this into something our DOMManipulation function expects. 
            //A pokemon with, name, image, and type. 

 for(let index in responseObject){
	//console.log("the index");
   // console.log(index);
    
    let reimbursementObject = new Reimbursement(responseObject[index].reimbursementId, responseObject[index].rembursementNumber, responseObject[index].employeeId, responseObject[index].reimursementType, responseObject[index].approveStatus, responseObject[index].amount, responseObject[index].description, responseObject[index].timeStamp);
		
		console.log("reimbursementId: " +responseObject[index].reimbursementId);
		console.log("reimbursementNumber: " +responseObject[index].rembursementNumber);
		console.log("employeeId: " +responseObject[index].employeeId);
		console.log("reimbursementType: " +responseObject[index].reimursementType);
		console.log("approveStatus: " +responseObject[index].approveStatus);
		console.log("amount: " +responseObject[index].amount);
		console.log("description: " +responseObject[index].description);
		console.log("timestamp: " +responseObject[index].timeStamp);
		console.log("the object");
		console.log(reimbursementObject);
		
		//console.log("the en: "+emNumber);
		console.log("Status: "+Status);
		if(Status != "ALL"){
			if(responseObject[index].approveStatus == Status){
				addRow(reimbursementObject);
			}
		}
		else{
			addRow(reimbursementObject);
		}
		//addRow(reimbursementObject);
    

}
 
 
        
        
        
           
        }
        
    }
    
    xhttp.open("GET", "http://localhost:7001/getAllReimbursements");

    xhttp.send();
	
	
}


let contact = document.querySelectorAll('input[name="myradio"]');
                                  // or '.your_radio_class_name'

for (let i = 0; i < contact.length; i++) {
  contact[i].addEventListener("change", function() {
    let val = this.value; // this == the clicked radio,
    console.log(val);
    filter(val)
  });
}


function filter(value){
	if(value == "A"){
		getAllApprove("APPROVED");
	}
	else if(value == "R"){
		getAllApprove("REJECTED");
	}
	else if(value == "P"){
		getAllApprove("PENDING");
	}
	else {
		getAllApprove("ALL");
	}
}

