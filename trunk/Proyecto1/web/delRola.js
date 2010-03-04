$(document).ready(function(){
    $(".delus").click(function(event){
     $(this.parentNode.parentNode).hide("slow");
     $.get(this.getAttribute("href"),{});
     event.preventDefault();
   });
});