$(document).ready(function(){
	$('.mainu li:has(ul)').click(function(e){
		e.preventDefault();

		if ($(this).hasClass('activado')){
			$(this).removeClass('activado');
			$(this).children('ul').slideUp();
		} else {
			$('.mainu li ul').slideUp();
			$('.mainu li').removeClass('activado');
			$(this).addClass('activado');
			$(this).children('ul').slideDown();
		}
	});

	$('.btn-mainu').click(function(){
		$('.contenedor-mainu .mainu').slideToggle();
	});

	$(window).resize(function(){
		if ($(document).width() > 450){
			$('.contenedor-mainu .mainu').css({'display' : 'block'});
		}

		if ($(document).width() < 450){
			$('.contenedor-mainu .mainu').css({'display' : 'none'});
			$('.mainu li ul').slideUp();
			$('.mainu li').removeClass('activado');
		}
	});

	$('.mainu li ul li a').click(function(){
		window.location.href = $(this).attr("href");
	});
});
