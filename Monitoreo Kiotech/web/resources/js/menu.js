//ANIMACIÓN DEL MENÚ CON CSS
$(document).ready(function(){

  $('ul.tabs li a:first').addClass('active');
  $('.secciones article').hide();
  $('.secciones article:first').show();

  $('ul.tabs li a').click(function(){
    $('ul.tabs li a').removeClass('active');
    $(this).addClass('active');
    $('.secciones article').hide();

    var activeTab = $(this).attr('href');
    $(activeTab).show();
    $('ul.minitab li a:first').addClass('active2');
    $('.secciones2 article').hide();
    //$('#t1').show();
    $('.secciones2 article:first').show();
    return false;
  });

  $('ul.minitab li a').click(function(){
    $('ul.minitab li a').removeClass('active2');
    $(this).addClass('active2');
    $('.secciones2 article').hide();

    var activeTab2 = $(this).attr('href');
    $(activeTab2).show();
    return false;
  });
   $('ul.mtab li a').click(function(){
    $('ul.mtab li a').removeClass('active2');
    $(this).addClass('active2');
    $('.secciones2 article').hide();

    var activeTab2 = $(this).attr('href');
    $(activeTab2).show();
    return false;
  });
});
