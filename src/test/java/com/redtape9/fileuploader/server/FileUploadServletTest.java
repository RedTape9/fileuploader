package com.redtape9.fileuploader.server;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class FileUploadServletTest {

    @Test
    public void testDoPost() throws Exception {
        // Mock HttpServletRequest and HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock the file part
        Part filePart = mock(Part.class);
        when(filePart.getSubmittedFileName()).thenReturn("testfile.txt");
        when(filePart.getInputStream()).thenReturn(new ByteArrayInputStream("Test content".getBytes()));

        when(request.getPart("file")).thenReturn(filePart);

        // Create instance of the servlet
        FileUploadServlet servlet = new FileUploadServlet();

        // Execute doPost method
        servlet.doPost(request, response);

        // Verify if the getPart method was called with "file"
        verify(request, times(1)).getPart("file");

        // Here, you should add more verifications for your logic, for example, check if a file was saved
        // This example doesn't include writing to disk or the logic to verify that,
        // but you can extend this based on how your servlet processes the upload.
    }
}
