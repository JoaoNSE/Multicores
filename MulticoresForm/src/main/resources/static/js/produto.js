var data1 = {
		message: "deu certo",
		result: "",
		user: {
			nome:"",
			descricao:""
		}
}

new Vue({
	el: "#app",
	data: data1,
	mounted() {
		axios.post('/produtos')
		.then(function (response) {
		    data1.result =  response.data;
		  })
		  .catch(function (error) {
		    console.log(error);
		  });
	},
	methods : {
		removerProduto(produto){
			   let self = this;
			   swal({  title: "Você tem certeza?",
			           text: 'Deseja apagar ' + produto.nome,   
			           type: "warning",   
			           showCancelButton: true,   
			           confirmButtonColor: "#DD6B50",   
			           cancelButtonText: "Cancelar",
			           confirmButtonText: "Sim, pode apagar!",
			           showLoaderOnConfirm: true,   
			           closeOnConfirm: false }, function(){   
			        	   axios.post('/produtos/'+produto.id+'/remover')
			   			.then(function (response) {
			                         swal("Cervejaria removida!")
			                         self.loadBreweries()
			            })
			            window.location.replace("/produtos");
			        });
			       },
		alterarProduto(id){
			    	   window.location.replace("/produtos/"+id+"/update");
			       }
		
	}
})

