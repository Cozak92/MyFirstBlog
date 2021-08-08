
let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});

	},
	
	save:function(){
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		}
		

		$.ajax({
			type:"POST",
			url:"/auth/board",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" 
			
			
		}).done(function(res){
			alert("글 작성 완료");
			location.href ="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	}
}

index.init();