function getClock()
  {
      //Get Current Time
      d = new Date();
      var hours = d.getHours();
      var hourdisp = hours % 12; 
      var minutes = d.getMinutes();
      var secs = d.getSeconds();
      var ampm = hours <= 11 ? 'AM' : 'PM';
      str = [hourdisp < 10 ? "0" + hourdisp : hourdisp,
             (minutes < 10 ? "0" + minutes : minutes),
             (secs < 10 ? "0" + secs : secs)
            ].join(':') + " " +ampm;
      
      //Get the Context 2D or 3D
      context = digiclock.getContext("2d");
      context.clearRect(0, 0, 224, 60);
      context.font = "40px lato,sans-serif";
      context.fillStyle = "#73879c";
      context.fillText(str, 0, 38);
  }

  function setDateToday(dateElem) {
	var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
	   "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	var dow = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
	//Get Current Time
    d = new Date();
    var str = dow[d.getDay()] + " " + months[d.getMonth()] + " " + d.getDate() + ", " + d.getFullYear();
    dateElem.text(str);
  }
  
  $(function(){
	  $("a#logtime").click(function(){
		  $.ajax({
	            type: 'GET',
	            url: "/timelogging",
	            data: null,
	            contentType: 'application/json',
	            dataType: "json",
	            success: function(data) {
	            	console.log(data);
	            },
	            error: function() {}
	        });
	  });
	  
	  setInterval(getClock, 1000);
	  
	  $(".datecont").each(function(index){
		  setDateToday($(this));
	  });
  });