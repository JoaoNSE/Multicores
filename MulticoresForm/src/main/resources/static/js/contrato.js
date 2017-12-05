
var data1 = {
		message: "deu certo",
		result: "",
		btnAcao: "Simular Contrato",
		user: {
			id:"",
			nome:"",
			sobrenome:"",
			email:"",
			cpf:"",
			endereco:"",
			nomePai:"",
			nomeMae:"",
			instituicaoEnsino:"",
			validade:""
		},
		produtos: [],
		produtosSel: [],
		pSel: {
			nome:"Produtos"
		},
		valorTotal: 0
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
			
		},
		removeProduto: function(index, event) {
			event.preventDefault();
			this.produtosSel.splice(index, 1);
		},
		adicionaProduto: function(event) {
			event.preventDefault();
			this.produtosSel.push(data1.pSel);
		},
		selecionaProduto: function(produto) {
			data1.pSel = produto;
		},
		calculaTotal: function() {
			data1.valorTotal = 0;
			for (i = 0, len = data1.produtosSel.length; i < len; i++) {
			    data1.valorTotal += data1.produtosSel[i].qtd*data1.produtosSel[i].valor
			} 
		}
		
	}
})

