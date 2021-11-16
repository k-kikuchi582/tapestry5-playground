package k_kikuchi582.tapestry5_playground.pages.component;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class PropertyExpressions {
    @Inject
    private PersistentLocale persistentLocale;

    public String getFooBar() {
        return "foo-bar";
    }

    public boolean isEnglish() {
        Locale currentLocale = persistentLocale.get();
        return currentLocale != null && currentLocale.getLanguage().equals(Locale.ENGLISH.getLanguage());
    }

    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public List<String> getList() {
        return null;
    }

}
