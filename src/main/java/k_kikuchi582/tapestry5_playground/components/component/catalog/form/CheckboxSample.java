package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class CheckboxSample {
    @Property
    private boolean isCheckedApple;
    @Property
    private boolean isCheckedOrange;
    @Property
    private boolean isCheckedGrape;
    @Property
    private List<CheckModel> checkModels;

    @Property
    private CheckModel checkModel;

    @InjectComponent("fruitZone")
    private Zone fruitZone;
    @InjectComponent("vegetableZone")
    private Zone vegetableZone;

    @SetupRender
    void setupRender() {
        if ( checkModels == null ){
            checkModels = Arrays.asList(
                    new CheckModel( "🥕にんじん", false ),
                    new CheckModel( "🍅トマト", false ),
                    new CheckModel( "🥒きゅうり", false )
            );
        }
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "fruitForm")
    Block onSubmitFromFruitForm() {
        return fruitZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "vegetableForm")
    Block onSubmitFromVegetableForm() {
        return vegetableZone.getBody();
    }

    @OnEvent(value = EventConstants.SYNCHRONIZE_VALUES, component = "vegetableCheckLoop")
    void onSynchronizedValuesFromVegetableCheckLoop(List<CheckModel> synchronizedValues) {
        this.checkModels = synchronizedValues;
    }

    public static class CheckModel {
        private final String label;
        private boolean checked;

        public CheckModel(String label, boolean checked) {
            this.label = label;
            this.checked = checked;
        }

        public String getLabel() {
            return label;
        }

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        @Override
        public String toString() {
            return label + "='" + checked + "'";
        }
    }

    public ValueEncoder<CheckModel> getVegetableEncoder() {
        return CheckModelEncoder.INSTANCE;
    }

    public static class CheckModelEncoder implements ValueEncoder<CheckModel> {
        private static final CheckModelEncoder INSTANCE = new CheckModelEncoder();

        @Override
        public String toClient(CheckModel value) {
            if (value == null) {
                return JSONObject.NULL.toString();
            }
            return new JSONObject()
                    .accumulate("label", value.label)
                    .accumulate("checked", value.checked)
                    .toString();
        }

        @Override
        public CheckModel toValue(String clientValue) {
            if (clientValue == null) {
                return null;
            }

            JSONObject json = new JSONObject(clientValue);
            if (JSONObject.NULL.equals(json)) {
                return null;
            }
            return new CheckModel(json.getString("label"), json.getBoolean("checked"));
        }
    }
}
