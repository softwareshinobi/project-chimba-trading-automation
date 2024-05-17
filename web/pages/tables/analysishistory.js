
$(document).ready(function () {

    fetchAnalysisHistory();

	setInterval(fetchAnalysisHistory, 1000*8);

});

function fetchAnalysisHistory() {

	console.debug("enter > fetchAnalysisHistory");

	$.ajax({

		type: "GET",
		
// url: "http://localhost:8889/robot/analysis-report/",
        
        url: "https://apis.projectchimba.softwareshinobi.digital" + "/robot/report",

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

    var html = '';

    for (var i = responseData.executionReports.length - 1; i >= 0; i--) {

        html += '<tr>';

        html += '<td class="METADATA DEBUG">' + responseData.executionReports[i].date + '</td>';

        html += '<td class="METADATA DEBUG">' + responseData.executionReports[i].security + '</td>';

        html += '<td>' + responseData.executionReports[i].triggerJustificationReport.targetMinute + '</td>';

        html += '<td>' + responseData.executionReports[i].triggerJustificationReport.actualMinute + '</td>';

        html += '<td>' + responseData.executionReports[i].triggerJustificationReport.description + '</td>';

        if(responseData.executionReports[i].doTrigger){

            html += '<td><label class="badge badge-success">' + responseData.executionReports[i].doTrigger + '</label></td>';

        } else {

            html += '<td><label class="badge badge-info">' + responseData.executionReports[i].doTrigger + '</label></td>';

        }

        html += '</tr>';

        $('#activity-display-table  > tbody').html(html); 

    }

}
