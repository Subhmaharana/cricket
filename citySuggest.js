/**
 * 
 */
var req;

function getScore(){
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest();
	}else if(window.ActivexObject){
		req = new ActivexObject("Microsoft.XMLHTTP");
	}
	var url = "showScore.jsp";
	req.onreadystatechange = getResponse;
	req.open("GET",url,true);
	req.send(null);
}
function getResponse(){
	if(req.readyState == 4)
		if(req.status == 200)
			document.getElementById("cricket_score").innerHTML=req.responseText;
}
//getScore();
setInterval(getScore, 1000);
