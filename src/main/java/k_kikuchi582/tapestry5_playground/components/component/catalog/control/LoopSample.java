package k_kikuchi582.tapestry5_playground.components.component.catalog.control;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.LoopFormState;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LoopSample {

    @Persist
    private LoopFormState formState;

    @Property
    private LoopEntry loopValue;
    @Property
    private int index;

    @Persist
    @Property
    private List<LoopEntry> formStateLoopSource;
    @Property
    private LoopEntry formStateLoopValue;

    @InjectComponent
    private Zone formStateLoopZone;

    @SetupRender
    void setupRender() {
        if ( formState == null ) {
            formState = LoopFormState.NONE;
        }

        if ( formStateLoopSource == null ) {
            formStateLoopSource = getLoopSource();
        }
    }

    public List<LoopEntry> getLoopSource() {
        return Arrays.asList(
                new LoopEntry(1, "apple"),
                new LoopEntry(2, "orange"),
                new LoopEntry(3, "peach")
        );
    }

    public List<LoopEntry> getEmptySource() {
        return Collections.emptyList();
    }

    public LoopFormState getFormState() {
        return formState;
    }

    public void setFormState(LoopFormState formState) {
        this.formState = formState;
    }

    private boolean selectedOnChangeFormState = false;

    @OnEvent(value = EventConstants.SELECTED, component = "formState_NONE")
    void onSelectedFromFormFormState_NONE() {
        selectedOnChangeFormState = true;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "formState_ITERATION")
    void onSelectedFromFormFormState_ITERATION() {
        selectedOnChangeFormState = true;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "formState_VALUES")
    void onSelectedFromFormFormState_VALUES() {
        selectedOnChangeFormState = true;
    }

    private List<LoopEntry> synchronizedValues;

    @OnEvent(value = EventConstants.SYNCHRONIZE_VALUES, component = "formStateLoop")
    void onSynchronizedValuesFromFormStateLoop(List<LoopEntry> synchronizedValues) {
        this.synchronizedValues = synchronizedValues;
    }

    @OnEvent(EventConstants.SUBMIT)
    Zone onSubmit() {
        if (synchronizedValues != null) {
            if (selectedOnChangeFormState) {
                formStateLoopSource = synchronizedValues;
            } else {
                formStateLoopSource = synchronizedValues.stream()
                        .map(entry -> {
                            if (entry.name != null && entry.name.startsWith("(synchronized)") ) {
                                return entry;
                            }
                            return new LoopEntry(entry.id, "(synchronized)" + entry.getName() );
                        } )
                        .collect( Collectors.toList() );
            }
        }

        return formStateLoopZone;
    }

    public static class LoopEntry {
        private int id;
        private String name;

        public LoopEntry(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public LoopEntryValueEncoder getLoopEntryValueEncoder() {
        return LoopEntryValueEncoder.INSTANCE;
    }

    public static class LoopEntryValueEncoder implements ValueEncoder<LoopEntry> {
        private static final LoopEntryValueEncoder INSTANCE = new LoopEntryValueEncoder();

        @Override
        public String toClient(LoopEntry value) {
            if (value == null) {
                return null;
            }
            return new JSONObject()
                    .accumulate("id", value.id)
                    .accumulate("name", value.name)
                    .toString();
        }

        @Override
        public LoopEntry toValue(String clientValue) {
            if (clientValue == null) {
                return null;
            }
            JSONObject json = new JSONObject(clientValue);
            return new LoopEntry(json.getInt("id"), json.getString("name"));
        }
    }

    public LoopFormState getFormState_none() {
        return LoopFormState.NONE;
    }

    public LoopFormState getFormState_iteration() {
        return LoopFormState.ITERATION;
    }

    public LoopFormState getFormState_values() {
        return LoopFormState.VALUES;
    }
}
