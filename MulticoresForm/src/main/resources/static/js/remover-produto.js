var data1 = {
		message: "deu certo",
		result: "",
		btnAcao: "Remover",
		prod: {
			nome:"",
			valor:""
		}
}

new Vue({
	el: "#app",
	data: data1,
	methods : {
		remover: function(event) {
			event.preventDefault();
			axios.post('/produtos', data1.prod)
			.then(function (response) {
				if (response.data.includes("redirect")) {
					window.location.replace("/login");
				}
			    data1.result =  response.data;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})
