package k_kikuchi582.tapestry5_playground.pages;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Persistence {
    private enum SubmitEvent {
        ADD, DELETE, SAVE
    }

    @Inject
    private ComponentResources componentResources;

    @Persist
    @Property
    private List<String> context;

    // NG @Persistなフィールドはprivateでなければいけない
//    @Persist
//    Object notPrivate;

    // NG @Persistなフィールドは宣言時に初期化してはいけない
//    @Persist
//    private Object initialized = "initialized";

    @Persist
    private int count;

    @Property
    private int index;

    private SubmitEvent submitEvent;
    private int deleteIndex;

    @OnEvent(EventConstants.ACTIVATE)
    void onActivate(EventContext eventContext) {
        count = eventContext.getCount();

        context = IntStream.range(0, count)
                .mapToObj(i -> eventContext.get(String.class, i))
                .collect(Collectors.toList());
    }

    @OnEvent(EventConstants.PASSIVATE)
    String[] onPassivate() {
        return context.toArray(new String[0]);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAContext() {
        return context.get(index);
    }

    public void setAContext( String aContext ) {
        context.set(index, aContext);
    }

    @OnEvent(value = EventConstants.SELECTED, component = "delete")
    void onSelectedFromDelete(int index) {
        submitEvent = SubmitEvent.DELETE;
        deleteIndex = index;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "add")
    void onSelectedFromAdd() {
        submitEvent = SubmitEvent.ADD;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "save")
    void onSelectedFromSave() {
        submitEvent = SubmitEvent.SAVE;
    }

    @OnEvent(EventConstants.SUBMIT)
    void onSubmit() {
        if (submitEvent == SubmitEvent.DELETE) {
            context.remove(deleteIndex);
        } else if (submitEvent == SubmitEvent.ADD) {
            context.add("");
        }
    }
}
