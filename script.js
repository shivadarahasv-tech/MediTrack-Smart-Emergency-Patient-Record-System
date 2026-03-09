let patients=[
{id:"MV101",name:"Ravi",blood:"O+",condition:"Diabetes",contact:"9876543210"},
{id:"MV102",name:"Anita",blood:"A+",condition:"Heart Patient",contact:"9876543222"},
{id:"MV103",name:"Kiran",blood:"B+",condition:"Asthma",contact:"9876543333"}
];

function display(data){

let table=document.getElementById("patientTable");

table.innerHTML=
`<tr>
<th>ID</th>
<th>Name</th>
<th>Blood Group</th>
<th>Condition</th>
<th>Contact</th>
</tr>`;

data.forEach(p=>{

table.innerHTML+=`
<tr>
<td>${p.id}</td>
<td>${p.name}</td>
<td>${p.blood}</td>
<td>${p.condition}</td>
<td>${p.contact}</td>
</tr>`;

});
}

function addPatient(){

let p={
id:document.getElementById("pid").value,
name:document.getElementById("name").value,
blood:document.getElementById("blood").value,
condition:document.getElementById("condition").value,
contact:document.getElementById("contact").value
};

patients.push(p);

display(patients);
}

function searchPatient(){

let id=document.getElementById("searchID").value;

let result=patients.filter(p=>p.id===id);

if(result.length>0)
display(result);
else
alert("Patient not found");

}

function sortPatients(){

patients.sort((a,b)=>a.name.localeCompare(b.name));

display(patients);

}

display(patients);