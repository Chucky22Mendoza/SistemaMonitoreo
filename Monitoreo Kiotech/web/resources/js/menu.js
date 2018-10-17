$(document).ready(function(){
  $('#abrirMenu').click(function () {
    $('#sidebar').show(800);
    $('#sidebar').addClass('slideInLeft');
    $('#abrirMenu').css({
        'visibility': 'hidden'
    });
  });
  $('#cerrarMenu').click(function () {
    $('#sidebar').slideUp(800);
    $('#abrirMenu').css({
        'visibility': 'visible'
    });
  });

  $("html").click(function(){
    $('#sidebar').slideUp(800);
    $('#abrirMenu').css({
        'visibility': 'visible'
    });
  });

  $("#sidebar").click(function(e){
     e.stopPropagation();
  });

  $("#abrirMenu").click(function(e){
     e.stopPropagation();
  });

  $('.menu li:has(ul)').click(function(e){
    e.preventDefault();

    if($(this).hasClass('activado')){
      $(this).removeClass('activado');
      $(this).children('ul').slideToggle();
    }else{
      $('.menu li ul').slideUp();
      $('.menu li').removeClass('activado');
      $(this).addClass('activado');
      $(this).children('ul').slideDown();

    }
  });

  $('.menu li ul li a').click(function(){
    window.location.href = $(this).attr('href');
  });

});
