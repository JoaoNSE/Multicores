
var data1 = {
		message: "deu certo",
		result: "",
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
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			var json =  JSON.stringify($('#userForm').serializeArray());
			console.log(data1.user);
			axios.post('/usuarios', data1.user)
			.then(function (response) {
			    data1.result =  response.data;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})

