/**
 * 
 */
$( document ).ready(function() {
		$(".myclass").hide();
		$("#checkUserId" ).hide();
		
	});
	
	$("#checkUser").click(function() {
		var id = $("#userId").val();
		$.get( "check-user?userId="+id, function( data ) {
			if(id.length>3 && data=="false")
				{					
					$("#checkUserId").show().text("Invalid UserID");
					$(".myclass").hide();
					
				}
			else
				{
					$("#checkUser").hide();
					$("#checkUserId").hide();
					$(".myclass").show();
					$("#securityQuestion").val(data);
					$("#pass").hide();
					$("#setpass").hide();
				}
			
			}); 
	  });
	
	$("#setpass").click( function(){
		$("#pass").show();
	});
	
	$("#checkAnswer").click( function(){
		var ans= $("#answer").val();
		var id = $("#userId").val();
		var qu = $("#securityQuestion").val();
		$.get("check-answer?userId="+id+"&question="+qu+"&ans="+ans, function(data){
			if(data=="true")
				{
					alert(data);
				}
			else
				{
					alert(data);
				}
		});
	});
	
	