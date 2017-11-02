jQuery(function($){
	//$("#engine_nav ul li:eq(0)").find('a').addClass("current");	
});

function addEvent(id){
	$("#"+id).on("mouseenter", function(){
		  $(this).find('a').addClass("visit");
	});
	  $("#"+id).on("mouseleave", function(){
		   $(this).find('a').removeClass("visit");
	   });
	   $("#"+id).on("click", function(){
		   $(this).parent().children().children(".current").removeClass("visit").removeClass("current");  
		   $(this).find('a').removeClass("visit").addClass("current");
	   });
}
function addEvent2(id){
	   $("#"+id).on("click", function(){
		    $(this).parent().children(".active").removeClass("active");
		     $(this).addClass("active");
	   });
}
