
var data1 = {
		message: "deu certo",
		result: "",
		btnAcao: "Cadastrar",
		user: {
			nome:"",
			sobrenome:"",
			email:"",
			senha:"",
			cpf:"",
			endereco:"",
			nomePai:"",
			nomeMae:"",
			instituicaoEnsino:"",
			validade:""
		}
}

new Vue({
	el: "#app",
	data: data1,
	mounted() {
	    $('#validade').datepicker().on(
	      'changeDate', () => { data1.user.validade = $('#validade').val() }
	    )
	  },
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			data1.user.validade = $("#validade").val()
			console.log(data1.user.validade);
			console.log(data1.user);
			axios.post('/usuarios', data1.user)
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

