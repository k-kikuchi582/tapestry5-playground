package k_kikuchi582.tapestry5_playground.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class HtmlHead {
    @Parameter(value = "'Tapestry5_playground'")
    @Property
    private String title;

    @Parameter(defaultPrefix = BindingConstants.BLOCK)
    @Property
    private Block head;

    @Inject
    private Messages messages;
    @Inject
    private PersistentLocale persistentLocale;

    @SetupRender
    void onSetupRender() {
        synchronized (persistentLocale) {
            if (!persistentLocale.isSet()) {
                persistentLocale.set(Locale.JAPANESE);
            }
        }
    }

    public Locale getCurrentLocale() {
        return persistentLocale.get();
    }
}
