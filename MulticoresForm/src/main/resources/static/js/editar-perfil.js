
var data1 = {
		message: "deu certo",
		result: "",
		btnAcao: "Alterar",
		user: {
			id:"",
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
	    axios.post('/getUserLogado').then(function(response) {
			data1.user = response.data;
		});
	  },
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			data1.user.validade = $("#validade").val()
			var uri = "";
			uri = "/usuarios";
			axios.post(uri, data1.user)
			.then(function (response) {
			    data1.result =  response.data;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})

