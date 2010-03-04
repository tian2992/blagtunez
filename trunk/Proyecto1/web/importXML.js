$(document).ready(function(){
    $("#importa").click(function(event){
    $.get(this.getAttribute("href"),{},function(data){
        $(".contenidoso").append(data).show("slow");
    });

    event.preventDefault();
    });

});
