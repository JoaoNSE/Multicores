
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
	mounted() {
		var id = window.location.href;
		id = id.split("/");
		id = id[4];
		alert(id);
		/*axios.post('/getProdutoSelecionado', {
			param1: id;
		}).then(function(response) {
			data1.produto = response.data;
		});*/
		
	    axios.post('/getProdutoSelecionado/'+id)
	    .then(function(response) {
			data1.produto = response.data;
		});
	  },
	methods : {
		cadastrar: function(event) {
			event.preventDefault();
			axios.post('/produtos/cadastrar', data1.produto)
			.then(function (response) {
				if (response.data.includes("redirect")) {
					window.location.replace("/produtos");
				}
			    data1.result =  response.data;
			  })
			  .catch(function (error) {
			    console.log(error);
			  });
			
		}
		
	}
})

