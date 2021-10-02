package k_kikuchi582.tapestry5_playground.pages.component.event;

import k_kikuchi582.tapestry5_playground.util.Utils;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Id;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EventHandler {
    @Inject
    @Id("eventHandlerSample")
    private Block eventHandlerSampleBlock;

    @Inject
    @Id("eventHandlerSampleJava")
    private Block eventHandlerSampleJavaBLock;

    @Inject
    @Id("eventHandlerSampleTemplate")
    private Block eventHandlerSampleTemplateBlock;

    public List<Block> getEventHandlerSampleTabBodies() {
        return Arrays.asList(eventHandlerSampleBlock, eventHandlerSampleJavaBLock, eventHandlerSampleTemplateBlock);
    }

    @Inject
    @Path("../../../components/component/event/EventHandlerSample.java")
    private Asset eventHandlerSampleJava;

    @Inject
    @Path("../../../components/component/event/EventHandlerSample.tml")
    private Asset eventHandlerSampleTemplate;

    public String getEventHandlerSampleJavaText() throws IOException {
        return Utils.getText(eventHandlerSampleJava);
    }

    public String getEventHandlerSampleTemplateText() throws IOException {
        return Utils.getText(eventHandlerSampleTemplate);
    }

    @Inject
    @Id("eventHandlerNamingConvention")
    private Block eventHandlerNamingConventionBlock;

    @Inject
    @Id("eventHandlerNamingConventionJava")
    private Block eventHandlerNamingConventionJavaBLock;

    @Inject
    @Id("eventHandlerNamingConventionTemplate")
    private Block eventHandlerNamingConventionTemplateBlock;

    public List<Block> getEventHandlerNamingConventionTabBodies() {
        return Arrays.asList(eventHandlerNamingConventionBlock, eventHandlerNamingConventionJavaBLock, eventHandlerNamingConventionTemplateBlock);
    }

    @Inject
    @Path("../../../components/component/event/EventHandlerNamingConvention.java")
    private Asset eventHandlerNamingConventionJava;

    @Inject
    @Path("../../../components/component/event/EventHandlerNamingConvention.tml")
    private Asset eventHandlerNamingConventionTemplate;

    public String getEventHandlerNamingConventionJavaText() throws IOException {
        return Utils.getText(eventHandlerNamingConventionJava);
    }

    public String getEventHandlerNamingConventionTemplateText() throws IOException {
        return Utils.getText(eventHandlerNamingConventionTemplate);
    }

    @Inject
    @Id("eventHandlerArguments")
    private Block eventHandlerArgumentsBlock;

    @Inject
    @Id("eventHandlerArgumentsJava")
    private Block eventHandlerArgumentsJavaBLock;

    @Inject
    @Id("eventHandlerArgumentsTemplate")
    private Block eventHandlerArgumentsTemplateBlock;

    public List<Block> getEventHandlerArgumentsTabBodies() {
        return Arrays.asList(eventHandlerArgumentsBlock, eventHandlerArgumentsJavaBLock, eventHandlerArgumentsTemplateBlock);
    }

    @Inject
    @Path("../../../components/component/event/EventHandlerArguments.java")
    private Asset eventHandlerArgumentsJava;

    @Inject
    @Path("../../../components/component/event/EventHandlerArguments.tml")
    private Asset eventHandlerArgumentsTemplate;

    public String getEventHandlerArgumentsJavaText() throws IOException {
        return Utils.getText(eventHandlerArgumentsJava);
    }

    public String getEventHandlerArgumentsTemplateText() throws IOException {
        return Utils.getText(eventHandlerArgumentsTemplate);
    }
}
