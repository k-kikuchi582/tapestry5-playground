package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.commons.io.IOUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.tapestry5.ContentType;
import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@IncludeJavaScriptLibrary({
        "./UploadSample.js"
})
public class UploadSample {
    @Property
    private UploadedFile value;

    @Inject
    private ComponentResources componentResources;

    @Inject
    @Id("imgBlock")
    private Block imgBlock;

    @Inject
    @Id("textBlock")
    private Block textBlock;

    @Inject
    @Id("notPreviewableBlock")
    private Block notPreviewableBlock;

    @Inject
    @Id("noFileBlock")
    private Block noFileBlock;

    @Persist
    private FileItem fileItem;

    public Consumer<RenderSupport> getUploadScript() {
        return renderSupport -> {
            renderSupport.addScript("new UploadSample();");
        };
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "form")
    void onSubmitFromForm() throws IOException {
        if (value != null) {
            fileItem = new FileItem(value);
        } else {
            fileItem = null;
        }
    }

    public Block getPreview() throws IOException {
        if (fileItem == null) {
            return noFileBlock;
        }
        if (isImageFileUploaded()) {
            return imgBlock;
        }
        if (isTextFileUploaded()) {
            return textBlock;
        }
        return notPreviewableBlock;
    }

    private boolean isImageFileUploaded() {
        return getUploadedFileContentType()
                .filter(contentType -> contentType.getBaseType().equals("image"))
                .isPresent();
    }

    // basetypeがtextではないけどtextデータとして解析ができそうな奴ら
    private static final Set<String> NOT_TEXT_BUT_LIKE_TEXT_MIME_TYPES = new HashSet<>( Arrays.asList(
            "application/javascript",
            "application/json",
            "application/xml"
    ) );

    private boolean isTextFileUploaded() {
        return getUploadedFileContentType()
                .filter(contentType -> contentType.getBaseType().equals("text") || NOT_TEXT_BUT_LIKE_TEXT_MIME_TYPES.contains(contentType.getMimeType()))
                .isPresent();
    }

    public String getFileName() {
        return fileItem != null ? fileItem.name : "not uploaded";
    }

    private final static NumberFormat FILE_SIZE_FORMAT = new DecimalFormat( "#,###" );

    public String getFileSize() {
        return fileItem != null ? FILE_SIZE_FORMAT.format( fileItem.size ) : "";
    }

    public Link getPreviewAsImageLink() {
        return componentResources.createEventLink( "previewAsImage" );
    }

    @OnEvent("previewAsImage")
    public StreamResponse getFileAsStream() {
        return fileItem.toStreamResponse();
    }

    public String getFileAsText() throws IOException {
        StringWriter writer = new StringWriter();
        try ( InputStream inputStream = fileItem.getStream() ) {
            IOUtils.copy( inputStream, writer, StandardCharsets.UTF_8 );
        }
        return StringEscapeUtils.escapeHtml4(writer.toString());
    }

    public String getFileSubType() {
        return getUploadedFileContentType()
                .map(ContentType::getSubType)
                .orElse("");
    }

    private Optional<ContentType> getUploadedFileContentType() {
        if (fileItem == null) {
            return Optional.empty();
        }
        return Optional.of(fileItem.contentType);
    }

    private static class FileItem {

        private final java.nio.file.Path tmpFile;
        private final String name;
        private final ContentType contentType;
        private final long size;

        private FileItem( UploadedFile uploadedFile ) throws IOException {
            name = uploadedFile.getFileName();
            contentType = new ContentType(uploadedFile.getContentType());
            size = uploadedFile.getSize();
            tmpFile = Files.createTempFile("upload", name);
            uploadedFile.write(tmpFile.toFile());
        }

        private InputStream getStream() throws IOException {
            return Files.newInputStream(tmpFile, StandardOpenOption.DELETE_ON_CLOSE);
        }

        @Override
        protected void finalize() throws Throwable {
            Files.deleteIfExists(tmpFile);
            super.finalize();
        }

        private StreamResponse toStreamResponse() {
            return new StreamResponse() {
                @Override
                public String getContentType() {
                    return contentType.getMimeType();
                }

                @Override
                public InputStream getStream() throws IOException {
                    return FileItem.this.getStream();
                }

                @Override
                public void prepareResponse(Response response) {

                }
            };
        }
    }

}
