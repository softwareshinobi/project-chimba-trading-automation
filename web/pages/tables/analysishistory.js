
$(document).ready(function () {

	setInterval(fetchAnalysisHistory, 1000);
});

function fetchAnalysisHistory() {

	console.debug("enter > fetchAnalysisHistory");

	$.ajax({

		type: "GET",
		
        url: "https://apis.projectchimba.softwareshinobi.digital/trading-robot/analysis-report/",

		contentType: "text/plain",
		
		crossDomain: true,				

		success: function (data, status, jqXHR) {
            
            setResultsArea(data);          

		},

		error: function (jqXHR, status) {

			console.log("exception");
			
			console.log(jqXHR);

		}

	});

}

function setResultsArea(responseData) {

    var trHTML = '';

    for (var i = responseData.executionReports.length - 1; i >= 0; i--) {

        trHTML += '<tr>';

        trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].date + '</td>';

        trHTML += '<td class="METADATA DEBUG">' + responseData.executionReports[i].security + '</td>';

        trHTML += '<td>' + responseData.executionReports[i].triggerJustificationReport.targetMinute + '</td>';

        trHTML += '<td>' + responseData.executionReports[i].triggerJustificationReport.actualMinute + '</td>';

        trHTML += '<td>' + responseData.executionReports[i].triggerJustificationReport.description + '</td>';

        if(responseData.executionReports[i].doTrigger){

            trHTML += '<td><label class="badge badge-success">' + responseData.executionReports[i].doTrigger + '</label></td>';

        } else {

            trHTML += '<td><label class="badge badge-info">' + responseData.executionReports[i].doTrigger + '</label></td>';

        }

        trHTML += '</tr>';

        $('#activity-display-table  > tbody').html(trHTML); 

    }

}
