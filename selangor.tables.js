var oTable;

$(document).ready(function(){

    
    /* Add a click handler to the rows - this could be used as a callback */
    $("#selangortable tbody tr").click( function( e ) {
        if ( $(this).hasClass('row_selected') ) {
            $(this).removeClass('row_selected');
        }
        else {
            oTable.$('tr.row_selected').removeClass('row_selected');
            $(this).addClass('row_selected');
        }
    });
     
     
    /* Init the table */
    oTable = $('#selangortable').dataTable({
        "sPaginationType": "full_numbers",
        "processing": true,
        "serverSide": true,
        "ajax": "selangor_processing.php",
        "language": {
          "search": "<font size=2em>Filter: </font>",
          "lengthMenu": "<font size=2em>Show _MENU_</font>",
          "infoEmpty": "<font size=2em>No records available</font>",
          "infoFiltered": "",
          "info": "<font size=2em>Showing page _PAGE_ of _PAGES_</font>"
        },
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
        "aoColumnDefs": [
                           {
                                "aTargets": [2],
                                "mData": null,
                                "mRender": function (data, type, full) {
                                    return '<center><a href="mapview.php?id='+ full[0] +'"><button id='+ full[0] +' class="viewmap btn btn-labeled btn-success"><i class="icon-search" aria-hidden="true"></i> View</button></a></center>';
                                }
                            }
                         ]
    });   
});

/* Get the rows which are currently selected */
function fnGetSelected( oTableLocal )
{
    return oTableLocal.$('tr.row_selected');
}

