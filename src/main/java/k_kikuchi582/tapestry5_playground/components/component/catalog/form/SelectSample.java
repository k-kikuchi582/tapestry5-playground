package k_kikuchi582.tapestry5_playground.components.component.catalog.form;

import org.apache.tapestry5.*;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.internal.OptionModelImpl;
import org.apache.tapestry5.internal.SelectModelImpl;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SelectSample {
    @Property
    private Continent modelValue;
    @Property
    private Item valueEncoderValue;
    @Property
    private String blankOptionNullableValue;
    @Validate("required")
    @Property
    private String blankOptionNonNullValue;
    @Property
    private String blankLabelValue;

    @Property
    @Persist
    private String blankOption;

    @Persist
    private Map<String, Item> items;

    @Inject
    private Messages messages;

    @InjectComponent("modelZone")
    private Zone modelZone;
    @InjectComponent("valueEncoderZone")
    private Zone valueEncoderZone;
    @InjectComponent("blankOptionZone")
    private Zone blankOptionZone;

    @SetupRender
    void setupRender() {
        if (items == null) {
            items = new LinkedHashMap<>();
            items.put("makura", new Item("makura", "枕草子"));
            items.put("houjou", new Item("houjou", "方丈記"));
            items.put("tsure", new Item("tsure", "徒然草"));
        }
        if (blankOption == null) {
            blankOption = "auto";
        }
    }

    public SelectModel getModel() {
        return new EnumSelectModel( Continent.class, messages );
    }

    public SelectModel getValueEncoderModel() {
        List<OptionModel> options = items.values().stream()
                .map(item -> new OptionModelImpl(item.label, item))
                .collect(Collectors.toList());
        return new SelectModelImpl(null, options);
    }

    public SelectModel getBlankOptionModel() {
        return new SelectModelImpl(
                new OptionModelImpl("那智の滝", "nachi"),
                new OptionModelImpl("華厳の滝", "kegon"),
                new OptionModelImpl("袋田の滝", "fukuro")
        );
    }

    public SelectModel getBlankLabelModel() {
        return new SelectModelImpl(
                new OptionModelImpl("万葉集", "manyou"),
                new OptionModelImpl("古今和歌集", "kokin"),
                new OptionModelImpl("新古今和歌集", "shinkokin")
        );
    }

    public ValueEncoder<Item> getValueEncoder() {
        return new ValueEncoder<Item>() {
            @Override
            public String toClient(Item value) {
                return value.value;
            }

            @Override
            public Item toValue(String clientValue) {
                return items.get(clientValue);
            }
        };
    }

    @OnEvent("changeBlankOption")
    Block onChangeBlankOption(String blankOption) {
        this.blankOption = blankOption;
        return blankOptionZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "modelForm")
    Block onSubmitFromModelForm() {
        return modelZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "valueEncoderForm")
    Block onSubmitFromValueEncoderForm() {
        return valueEncoderZone.getBody();
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "blankOptionForm")
    Block onSubmitFromBlankOptionForm() {
        return blankOptionZone.getBody();
    }

    public enum Continent {
        Eurasia, Africa, NorthAmerica, SouthAmerica, Australia, Antarctica;
    }

    public static class Item {
        private final String value;
        private final String label;

        public Item(String value, String label) {
            this.value = value;
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        private static class Encoder implements ValueEncoder<Item> {

            @Override
            public String toClient(Item value) {
                return null;
            }

            @Override
            public Item toValue(String clientValue) {
                return null;
            }
        }
    }
}
