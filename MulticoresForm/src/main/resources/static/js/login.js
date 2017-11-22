var data1 = {
		message: "deu certo",
		result: "",
		user: {
			email:"",
			senha:""
		}
}

new Vue({
	el: "#app",
	data: data1,
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			axios.post('/login', data1.user)
			.then(function (response) {
				if (response.data.includes("redirect")) {
					window.location.replace("/");
				}
			    data1.result =  response.data;			   
		    	$("#email").val("")
		    	$("#senha").val("")
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})