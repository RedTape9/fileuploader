package com.redtape9.fileuploader.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;

public class FileUploaderClient implements EntryPoint {

    public void onModuleLoad() {
        VerticalPanel panel = new VerticalPanel();
        RootPanel.get().add(panel);

        FileUpload fileUpload = new FileUpload();
        fileUpload.setName("file");

        Button uploadButton = new Button("Upload");
        FormPanel form = new FormPanel();
        form.setAction("/fileupload"); // Stellen Sie sicher, dass dies mit der Annotation @WebServlet in Ihrem Servlet übereinstimmt
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        form.add(panel);
        panel.add(fileUpload);
        panel.add(uploadButton);

        uploadButton.addClickHandler(event -> form.submit());
        form.addSubmitCompleteHandler(event -> Window.alert(event.getResults()));

        RootPanel.get().add(form);
    }
}
