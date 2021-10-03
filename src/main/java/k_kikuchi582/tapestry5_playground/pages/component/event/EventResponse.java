package k_kikuchi582.tapestry5_playground.pages.component.event;

import k_kikuchi582.tapestry5_playground.pages.Index;
import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class EventResponse {
    @InjectPage
    private Index indexPage;

    @Inject
    private ComponentResources componentResources;

    @Persist(PersistenceConstants.FLASH)
    private String responseType;

    public String getResponseType() {
        return StringUtils.isBlank(responseType) ? "なし" : responseType;
    }

    @OnEvent(value = "null")
    Object onNull() {
        responseType = "null";
        return null;
    }

    @OnEvent(value = "void")
    void onVoid() {
        responseType = "void";
    }

    @OnEvent(value = "string")
    String onString() {
        return "component/event/EventHandler";
    }

    @OnEvent(value = "class")
    Class<?> onClass() {
        return Index.class;
    }

    @OnEvent(value = "page")
    Index onPage() {
        return indexPage;
    }

    @OnEvent(value = "link")
    Link onLink() {
        return componentResources.createEventLink("byLink");
    }

    @OnEvent(value = "byLink")
    void onByLink() {
        responseType = "link";
    }

    @Inject
    @Path("context:/img/neko_01.jpeg")
    private Asset image;

    @OnEvent(value = "stream")
    StreamResponse onStream() {
        return new StreamResponse() {
            @Override
            public String getContentType() {
                return "image/jpeg";
            }

            @Override
            public InputStream getStream() throws IOException {
                return image.getResource().openStream();
            }

            @Override
            public void prepareResponse(Response response) {
            }
        };
    }

    @OnEvent(value = "url")
    URL onURL() throws MalformedURLException {
        return new URL("https://tapestry.apache.org/index.html");
    }

    @Inject
    @Id("EventResponseJava")
    private Block EventResponseJavaBLock;

    @Inject
    @Id("EventResponseTemplate")
    private Block EventResponseTemplateBlock;

    public List<Block> getTabBodies() {
        return Arrays.asList(EventResponseJavaBLock, EventResponseTemplateBlock);
    }

    @Inject
    @Path("./EventResponse.java")
    private Asset EventResponseJava;

    @Inject
    @Path("./EventResponse.tml")
    private Asset EventResponseTemplate;

    public String getEventResponseJavaText() throws IOException {
        return Utils.getText(EventResponseJava);
    }

    public String getEventResponseTemplateText() throws IOException {
        return Utils.getText(EventResponseTemplate);
    }
}
