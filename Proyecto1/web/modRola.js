var rolDel = function(){
     $(".delus").click(function(event){
     $(this.parentNode.parentNode).hide("slow");
     $.get(this.getAttribute("href"),{});
     event.preventDefault();
   });
};

var rolCre = function(){
    $("#creRola").click(function(event){
    $.post("cancionCreacion.jsp", {nomSon: $("#nomSon").val(), anio: $("#anio").val(), nomArt:$("#nomArt").val(), genArt: $("#genArt").val()},
    function(data){

        $(".searchResults").replaceWith($(".searchResults",data)).fade("slow");
        
    });
    rolDel();
    event.preventDefault();
    });
    
};

$(document).ready(function(){
    rolDel();
    rolCre();
});