
var data1 = {
		message: "deu certo",
		result: "",
		btnAcao: "Cadastrar",
		produto: {
			nome:"",
			valor:""
		}
}

new Vue({
	el: "#app",
	data: data1,
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			axios.post('/produtos/cadastrar', data1.produto)
			.then(function (response) {
				if (response.data.includes("redirect")) {
					window.location.replace("/produtosAdmin");
				}
			    data1.result =  response.data;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})

