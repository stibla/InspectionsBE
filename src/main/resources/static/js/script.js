$(document).ready(function () {

  $(document).on("click", "#fetch-data", function () {
    fetchInspection();
  });

  $("#dropFiles").on('dragenter', function (ev) {
    // Entering drop area. Highlight area
    $("#dropFiles").addClass("highlightDropArea");
  });

  $("#dropFiles").on('dragleave', function (ev) {
    // Going out of drop area. Remove Highlight
    $("#dropFiles").removeClass("highlightDropArea");
  });

  $("#dropFiles").on('drop', function (ev) {
    // Dropping files
    ev.preventDefault();
    ev.stopPropagation();
    // Clear previous messages
    //$("#messages").empty();
    if (ev.originalEvent.dataTransfer) {
      if (ev.originalEvent.dataTransfer.files.length) {
        var droppedFiles = ev.originalEvent.dataTransfer.files;
        for (var i = 0; i < droppedFiles.length; i++) {

          uploadFile(droppedFiles[i])

        }
      }
    }

    $("#dropFiles").removeClass("highlightDropArea");
    return false;
  });

  $("#dropFiles").on('dragover', function (ev) {
    ev.preventDefault();
  });

  $("#dropFiles").click(function () {
    $("#file").click();
  });

  // file selected
  $("#file").change(function () {
    var fd = new FormData();

    var files = $('#file')[0].files[0];
    console.log(files);
    fd.append('file', files);

    uploadFile(files);
  });

  $(document).on("click", "#inspectionTable button.btn_delete", function (event) {

    $.ajax({
      url: '/files/' + (event.target.id).split("_")[2],
      type: 'DELETE',
      success: function (response) {
        fetchInspection();
      },
      error: function (e) {
        alert("ERROR: ", e);
        console.log("ERROR: ", e);
      }
    });
  });

  $(document).on("click", "#inspectionTable button.btn_convert", function (event) {

    $.ajax({
      url: '/files/' + (event.target.id).split("_")[2],
      type: 'PUT',
      success: function (response) {
        fetchInspection();
      },
      error: function (e) {
        alert("ERROR: ", e);
        console.log("ERROR: ", e);
      }
    });
  });

});

async function uploadFile(fileobj) {
  let formData = new FormData();
  formData.append("file", fileobj);
  $.ajax({
    
    url: '/upload',
    type: 'POST',
    data: formData,
    processData: false,
    contentType: false,

    success: function (response) {
      fetchInspection();
    },
    error: function (e) {
      alert("ERROR: ", e);
      console.log("ERROR: ", e);
    }
  });
  /*await fetch('/upload', {
    method: "POST",
    body: formData
  }).then(fetchInspection());*/
  
  //$("#messages").append("<br /> <b>Uploaded File </b>" + fileobj.name); //alert('The file has been uploaded successfully.');
}

function fetchInspection() {
  $.ajax({
    type: "GET",
    url: "/files",
    success: function (response) {
      $('#inspectionTable tbody').empty();
      $.each(response, (i, inspection) => {
        $('#inspectionTable tbody').append('<tr id=\"' + i + "\"" + '>' +
          '<td><a href="' + inspection.url + '" class="badge badge-primary">' + inspection.name + '</td>' +
          '<td>' + inspection.type + '</a></td>' +
          '<td>' + inspection.size + '</td>' + 
          '<td>' + '<button' + ' id=' + '\"btn_delete_' + inspection.id + '\"' +
          ' type="button" class="btn btn-danger btn_delete">X</button>' + '</td>' +
          '<td>' + '<button' + ' id=' + '\"btn_convert_' + inspection.id + '\"' +
          ' type="button" class="btn btn-primary btn_convert">Nacitaj data</button>' + '</td>' +
          '</tr>'); 
      });
    },
    error: function (e) {
      alert("ERROR: ", e);
      console.log("ERROR: ", e);
    }
  });
}
