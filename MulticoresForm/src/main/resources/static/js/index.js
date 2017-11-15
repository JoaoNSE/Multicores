var data1 = {
		message: "deu certo"
}

new Vue({
	el: "#app",
	data: data1,
	methods : {
		requisicao: function() {
			$.ajax({
				type : "POST",
			    url : '/sim',
			    success : function(data) {
			        data1.message = data
			    }
			});
		}
		
	}
})

