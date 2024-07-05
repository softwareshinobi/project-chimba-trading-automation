
var apiURL = "https://apis.projectchimba.softwareshinobi.digital";

//var apiURL = "http://localhost:7777";

$(document).ready(function () {

    fetchAnalysisHistory();

    setInterval(fetchAnalysisHistory, 1000 * 8);

});

function fetchAnalysisHistory() {

    console.debug("enter > fetchAnalysisHistory");

    $.ajax({

        type: "GET",

        url: apiURL + "/robot/sma/report",

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

function setResultsArea(response) {

    var html = '';

    var rowCount = 0;

    for (var index = response.executionReports.length - 1; index >= 0; index--) {

        // increment counter and break on threshold break

        rowCount = rowCount + 1;

        if(rowCount > 50){

            break;

        }

        //

        html += '<tr>';

        html += '<td class="METADATA DEBUG">' + response.executionReports[index].date + '</td>';

        html += '<td class="METADATA DEBUG">' + response.executionReports[index].security + '</td>';

        html += '<td> $ ' + response.executionReports[index].triggerJustificationReport.sma.toFixed(2) + '</td>';

        html += '<td> $ ' + response.executionReports[index].triggerJustificationReport.price.toFixed(2) + '</td>';

        html += '<td>' + response.executionReports[index].triggerJustificationReport.reason + '</td>';

        if (response.executionReports[index].trigger) {

            html += '<td><span class="badge pill bg-primary">' +
                    response.executionReports[index].trigger + '</span></td>';

        } else {

            html += '<td><span class="badge pill bg-secondary">' +
                    response.executionReports[index].trigger + '</span></td>';

        }

        html += '</tr>';

       
    }


    $('#activity-display-table  > tbody').html(html);

}
