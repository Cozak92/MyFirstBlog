
let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save:function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
		
		// ajax 호출시 default가 비동기 호출
		$.ajax({
			type:"POST",
			url:"/blog/api/user",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', //mimetype
			dataType: "json" //응답이 왔을때 생긴게 json이라면 => javascript 오브젝트로 바꾸어줌
			
			
		}).done(function(res){
			alert("회원가입 완료");
			alert(res);
			//location.href ="/blog";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 파라미터를 JSON으로 변경하여 instert요청
		
	}
}

index.init();