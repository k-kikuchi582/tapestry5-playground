package k_kikuchi582.tapestry5_playground.mixins;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.FormSupport;
import org.apache.tapestry5.services.Request;

@IncludeJavaScriptLibrary({
        "./SubmitOnChange.js"
})
public class SubmitOnChange {
    @Parameter
    private Object[] context;

    @InjectContainer
    private Field field;

    @Inject
    private RenderSupport renderSupport;
    @Inject
    private ComponentResources componentResources;
    @Inject
    private Request request;

    @Environmental
    private FormSupport formSupport;

    // Radioなどレンダ―フェーズでないとdisabledを正しく取得できないコンポーネントもあるのでPersistしておく
    // ちなみに、Radioでうまくdisabledを取得できないのは、RadioのisDisabledがRadioGroupのsetupRenderでEnvironmentに登録されるRadioContainerが必要だから
    @Persist(PersistenceConstants.FLASH)
    private boolean disabled;

    @AfterRender
    void afterRender(MarkupWriter writer) {
        String controlName = getSubmitControlName();
        writer.element("input",
                "type", "submit",
                "name", controlName,
                "style", "display: none;",
                "id", controlName );

        disabled = field.isDisabled();
        if ( disabled ) {
            writer.attributes( "disabled", "disabled" );
        }
        writer.end();

        formSupport.store(this, new ProcessSubmission( controlName ) );

        renderSupport.addScript("SubmitOnChange.init('%s', '%s');", field.getClientId(), controlName );
    }

    private String getSubmitControlName() {
        return field.getControlName() + "-submit";
    }

    void processSubmission(String elementName) {
        if ( disabled ) {
            return;
        }

        String value = request.getParameter(elementName);

        if (value == null) {
            return;
        }

        Runnable sendNotification = () -> componentResources.triggerEvent(EventConstants.SELECTED, context, null);

        formSupport.defer(sendNotification);
    }

    private static class ProcessSubmission implements ComponentAction<SubmitOnChange> {
        private final String elementName;

        public ProcessSubmission(String elementName)
        {
            this.elementName = elementName;
        }

        public void execute(SubmitOnChange component)
        {
            component.processSubmission(elementName);
        }
    }
}
