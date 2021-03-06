
let index = {
	init:function(){
		$("#btn-write-save").on("click", ()=>{
			this.save();
		});
		$("#btn-delete").on("click", ()=>{
			this.deleteById();
		});
		$("#btn-update").on("click", ()=>{
			this.update();
		});
		$("#btn-reply-save").on("click", ()=>{
			this.replySave();
		});
	},

	
	save:function(){
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		}
		

		$.ajax({
			type:"POST",
			url:"/api/board",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" 
			
		}).done(function(res){
			alert("글 작성 완료");
			location.href ="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	
	deleteById:function(){
		let id = $('#id').text();
		
		$.ajax({
			type:"DELETE",
			url:"/api/board/" + id,
			dataType: "json" 
			
		}).done(function(res){
			alert("글 삭제 완료");
			location.href ="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},

	update:function(){
		let id = $("#id").val();
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		}
		
		$.ajax({
			type:"PUT",
			url:"/api/board/" + id,
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" ,
			
		}).done(function(res){
			alert("글 수정 완료");
			location.href ="/board/"+id;
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	},
	
	replySave:function(){
		let data = {
			boardId:$("#boardId").val(),
			content:$("#reply-content").val()
		}
		
		$.ajax({
			type:"POST",
			url:`/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" 
			
		}).done(function(res){
			if(res.status === 500){
				alert("댓글 작성 실패")
			}
			else{
				alert("댓글 작성 완료");
			}
			location.href =`/board/${data.boardId}`;
			
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		},
		
		replyDelete:function(boardId,replyId){
		
		$.ajax({
			type:"DELETE",
			url:`/api/board/${boardId}/reply/${replyId}`,
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" 
			
		}).done(function(res){
			if(res.status === 500){
				alert("댓글 삭제 실패")
			}
			else{
				alert("댓글 삭제 완료");
			}
			location.href =`/board/${boardId}`;
			
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});


		
	}


}

index.init();