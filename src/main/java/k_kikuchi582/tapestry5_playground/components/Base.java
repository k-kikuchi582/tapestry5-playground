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

@IncludeStylesheet({"./Base.css"})
public class Base {
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

    @Property
    private LangView langView;

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

    public String getCurrentLangLabel() {
        return messages.get(getCurrentLocale().getLanguage());
    }

    public List<LangView> getAvailableLangs() {
        return Arrays.asList(
                new LangView(Locale.ENGLISH),
                new LangView(Locale.JAPANESE)
        );
    }

    @OnEvent(component = "changeLang")
    void onChangeLang( String languageTag ) {
        persistentLocale.set(Locale.forLanguageTag( languageTag ));
    }

    public class LangView {
        private final Locale locale;

        public LangView(Locale locale) {
            this.locale = locale;
        }

        public String getLabel() {
            return messages.get(locale.getLanguage());
        }

        public String getLanguageTag() {
            return locale.toLanguageTag();
        }

        public boolean isCurrent() {
            return locale.equals(getCurrentLocale());
        }
    }

}
