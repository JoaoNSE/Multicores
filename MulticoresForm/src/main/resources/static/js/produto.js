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
		listar: function(event) {
			
		}
		
	}
})

