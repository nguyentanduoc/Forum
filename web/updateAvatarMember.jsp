<%-- 
    Document   : updateAvatarMember
    Created on : Oct 22, 2017, 3:28:12 PM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="//template_admin/header.jsp"%>
<%@include file="//template_admin/sidebar.jsp" %>

<section id="main-content">
    <section class="wrapper">
        <div class="form-w3layouts">            
            <% if (request.getAttribute("success") != null) {%>
            <div class="alert alert-success" role="alert">
                <%=request.getAttribute("success")%>
            </div>
            <%}
                if (request.getAttribute("error") != null) {%>
            <div class="alert alert-danger" role="alert">
                <%=request.getAttribute("error")%>
            </div>
            <%}%>
            <form action="uploadAvatarMember" method="POST" enctype = "multipart/form-data">
                <input type="hidden" name="id" value="<%=member.getMemberId()%>">           
                <div class="well" data-bind="fileDrag: fileData">
                    <div class="form-group row">
                        <div class="col-md-6">
                            <img style="height: 125px;" class="img-rounded  thumb" data-bind="attr: { src: fileData().dataURL }, visible: fileData().dataURL">
                            <div data-bind="ifnot: fileData().dataURL">
                                <label class="drag-label">Drag file here</label>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <input name="file" type="file" data-bind="fileInput: fileData, customFileInput: {
              buttonClass: 'btn btn-primary',
              fileNameClass: 'disabled form-control',
              onClear: onClear}" accept="image/*"/>
                        </div>
                    </div>
                </div>             
                <button class="btn btn-default">Update</button>
            </form>
        </div>
    </section>
</section>
<script src='http://cdnjs.cloudflare.com/ajax/libs/knockout/3.1.0/knockout-min.js'></script>
<script src="js_admin/knockout-file-bindings.js" type="text/javascript"></script>
<script>
    var viewModel = {};
    viewModel.fileData = ko.observable({
        dataURL: ko.observable(),
        // can add "fileTypes" observable here, and it will override the "accept" attribute on the file input
        // fileTypes: ko.observable('.xlsx,image/png,audio/*')
    });
    viewModel.multiFileData = ko.observable({dataURLArray: ko.observableArray()});
    viewModel.onClear = function (fileData) {
        if (confirm('Are you sure?')) {
            fileData.clear && fileData.clear();
        }
    };
    viewModel.debug = function () {
        window.viewModel = viewModel;
        console.log(ko.toJSON(viewModel));
        debugger;
    };
    viewModel.onInvalidFileDrop = function (failedFiles) {
        var fileNames = [];
        for (var i = 0; i < failedFiles.length; i++) {
            fileNames.push(failedFiles[i].name);
        }
        var message = 'Invalid file type: ' + fileNames.join(', ');
        alert(message)
        console.error(message);
    };
    ko.applyBindings(viewModel);
</script>
<%@include file="//template_admin/footer.jsp" %>