
$(document).ready(function () {
    
//    alert("tick history");

	setInterval(fetchCandleHistory,1000);

});

function fetchCandleHistory() {

	console.debug("enter > fetchCandleHistory");

	//console.debug("traderExchangeURL / ", traderExchangeURL);

	$.ajax({

		type: "GET",
		
        url: "https://apis.projectchimba.softwareshinobi.digital/trading-robot/analysis-report/",

		contentType: "text/plain",
		
		crossDomain: true,				

		success: function (data, status, jqXHR) {

            console.log("everything went good.");
                        
			console.log("data");

            console.log(data);
            
            setResultsArea(data);
            
            showResultsArea();

		},

		error: function (jqXHR, status) {

			console.log("Something Went wrong");

			console.log("exception");
			
			console.log(jqXHR);

			console.log("status");
			
			console.log(status);

		}

	});

	//

	//console.debug(" <- :: processForm()");
  
}


function setResultsArea(responseData) {

	
	console.log("reverse: ")
	console.log( responseData);
	
	
	 //var tableHTML = '';
	 
	
   // console.log("|");
	        var trHTML = '';

  //  for (var i = 0; i < responseData.priceHistory.length; i++) {

for (var i = responseData.executionReports.length - 1; i >= 0; i--) {

//for (var i = arr.length - 1; i >= 0; i--) {
//    console.log(arr[i]);
//}


	console.log("beeeeeeepppppppppppppppppp");
	
		trHTML += '<tr>';
	
         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].date + '</td>';

         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].security + '</td>';

         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].doTrigger + '</td>';

         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].triggerJustificationReport.actualMinute + '</td>';

         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].triggerJustificationReport.targetMinute + '</td>';
         trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].triggerJustificationReport.description + '</td>';



		trHTML += '</tr>';
		
		
		  
}
	 $('#activity-display-table  > tbody').html(trHTML); 
		 
		// setTimeout(4444);    
		// fullRow += trHTML;
		
		    console.log("trHTML", trHTML);

}

function clearFormBoxes(){

    setcategory("");

    setRemoteServerIP("");

    setRemoteServerPort(""); 

   // hideResultsArea();
    
}

function setcategory(newValue) {

	$("#category").val(newValue);

}

function setRemoteServerIP(newValue) {

	$("#state").val(newValue);

}

function setRemoteServerPort(newValue) {

	$("#description").val(newValue);

}

function showResultsArea() {

	$("#results-area-parent-div").show();

}

function hideResultsArea() {

	$("#results-area-parent-div").hide();

}
