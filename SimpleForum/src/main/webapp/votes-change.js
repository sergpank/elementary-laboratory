'use strict';

function setHandlers(){
	var btns=document.querySelectorAll('.votes-form button[type="submit"]');
	for(var i=0; i<btns.length; i++){
		btns[i].addEventListener('click',btnClickHandler);
	}
}

function btnClickHandler(e){
	e.preventDefault();
	var btn=e.currentTarget;
	var parentForm=btn.form;
	var data={
		'action':btn.value,
		'postId': parentForm.elements['postId'].value
	};
	var parentContainer=btn.parentElement;
	while(!parentContainer.classList.contains("post-footer")){
		parentContainer=parentContainer.parentElement;
	}
	var targetElem=null;
	if(btn.value=='up')
	{
		targetElem=parentContainer.querySelector('.target-success');		
	}
	else
	{
		targetElem=parentContainer.querySelector('.target-danger');
	}

	doRequest(data,targetElem);
}

function doRequest(data, targetElem){
	var xhr=new XMLHttpRequest();
	xhr.open("POST","/forum/editVotes");
	var body='';
	for(var key in data){
		body+=(key+'='+data[key]);
		body+='&';
	}
	body=body.substr(0, body.length-1);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
	xhr.send(body);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			targetElem.innerHTML=xhr.responseText;
		}
	};

}