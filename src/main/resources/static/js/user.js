
let index = {
	init:function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
		$("#btn-update").on("click", ()=>{
			this.update();
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
			url:"/auth/joinProc",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', //mimetype
			dataType: "json" //응답이 왔을때 생긴게 json이라면 => javascript 오브젝트로 바꾸어줌
			
			
		}).done(function(res){
			alert("회원가입 완료");
			location.href ="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	update:function(){
		let data = {
			//username:$("#username").val(),
			id:$("#id").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}


	console.log(data);
		$.ajax({
			type:"PUT",
			url:"/user",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', 
			dataType: "json" 
			
			
		}).done(function(res){
			alert("회원 수정 완료");
			location.href ="/";
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 파라미터를 JSON으로 변경하여 instert요청
		
	}
}

index.init();