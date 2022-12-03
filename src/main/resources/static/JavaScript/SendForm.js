async function SendJSONRegistration(){
    formElem = getFormRegis();
	delete formElem.confirm_password;
    formElem = JSON.stringify(formElem);
	
    let response = await fetch('http://localhost:8080/auth/registration', {
        method: 'POST',
        body: formElem,
        headers: {"Content-Type": "application/json;charset=utf8"}
    });
    let result = await response.json();
    console.log(result.message);

    if (response.ok){
		return true;
	} else return false;
    
}

async function SendJSONLogin(){
	let formElem = document.getElementById("form_login");

    let url = "http://localhost:8080/registration"
	let response = await fetch(url, {
	    method: 'GET'
	});

    if (response.ok) { // если HTTP-статус в диапазоне 200-299
      // получаем тело ответа (см. про этот метод ниже)
      let json = await response.json();
      alert(json)
    } else {
      alert("Ошибка HTTP: " + response.status);
    }
}

function getFormRegis(){
	let form = document.getElementById("form_regist");
	var data = {
		login: form.elements.type_login.value,
		first_name: form.elements.type_name.value,
		last_name: form.elements.type_surname.value,
		password: form.elements.type_password.value,
		confirm_password: form.elements.confirm_password.value,
		email: form.elements.type_email.value,
		role: "USER",
		status : "ACTIVE"
	};
	return data;
}

/*
function checkForm(data){
	let check = true;
	for (let elem in data){
		if (data[elem] === ""){
			check = false;
			break;
		}
	}
	return check;
}*/