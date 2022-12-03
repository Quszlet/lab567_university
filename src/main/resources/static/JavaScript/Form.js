async function Registration(){

    var formElem = document.getElementById("form_regist");
    var span = document.getElementsByName("registration");
    let height_form =  465;
    for (let i = 0; i < span.length; i++){

        if (formElem[i].value === ""){
            span[i].style.display = "block";
            formElem.style.height =  `${height_form += 10}px`;
        } else {
            span[i].style.display = "none";
            formElem.style.height =  `${height_form}px`;
        }
    }

    
    formElem.onsubmit = async (e) => {
        e.preventDefault();
        var div_regist = document.getElementById("access_regist");
        formElem.style.height =  `${height_form += 25}px`;
        div_regist.style.display = "block";
        let check = await SendJSONRegistration();
        console.log(check);
        if (check) {
           
        } else {

        }
        
    }
}

async function Login(){

    var formElem = document.getElementById("form_login");
    var span = document.getElementsByName("login_span");
    let height_form =  285;
    let check_input = true;

    for (let i = 0; i < span.length; i++){

        if (formElem[i].value === ""){
            span[i].style.display = "block";
            formElem.style.height =  `${height_form += 10}px`;
            check_input = false;
        } else {
            span[i].style.display = "none";
            formElem.style.height =  `${height_form}px`;
        }
    }
    console.log(check_input);
    
    formElem.onsubmit = async (er) => {
        er.preventDefault();
        /*
        let check = await SendJSONRegistration();
        console.log(check);
        
        
        if (check) {
            window.location.href = 'newpage.html';
        } else {

        }
        */
    }
}