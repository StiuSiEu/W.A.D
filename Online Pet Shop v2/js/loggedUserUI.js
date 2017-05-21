function loadData(){
	var arthubAPI = new ArthubAPI();
	arthubAPI.setBaseURL("http://localhost:8080");
    
	console.log("test");
    var request = arthubAPI.getUserData();
	request.done(function( data ) {
    	document.getElementById("userdata").innerHTML = data.message;
		
	});
    
	
	
}