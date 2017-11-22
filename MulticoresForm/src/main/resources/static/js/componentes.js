Vue.component('app-header', {
	template: '\
		<div>\
		<nav class="navbar navbar-inverse">\
			<div class="container-fluid">\
				<div class="navbar-header">\
		      		<a class="navbar-brand" href="#">Multicores Formatura</a>\
				</div>\
				<ul class="nav navbar-nav">\
		            <li><a href="/">Home</a></li>\
					<li><a href="/sobre">Sobre a Empresa</a></li>\
					<li><a href="#">Eventos</a></li>\
					<li><a href="/produtos">Produtos</a></li>\
					<li><a href="#">Login</a></li>\
					<li><a href="#">Fale Conosco</a></li>\
		        </ul>\
			</div>\
		</nav>\
	</div>'
})

Vue.component('app-footer', {
	template: '\
		<div class="navbar-fixed-bottom">\
		<p class="text-center-footer">2017 - Multicores Formatura.</p>\
	</div>'
})