package k_kikuchi582.tapestry5_playground.components;

import org.apache.tapestry5.RenderSupport;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.function.Consumer;

public class ScriptInjector {
    @Parameter(required = true)
    private Consumer<RenderSupport> script;

    @Inject
    private RenderSupport renderSupport;

    @AfterRender
    void afterRender() {
        script.accept(renderSupport);
    }
}
