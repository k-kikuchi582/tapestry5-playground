package k_kikuchi582.tapestry5_playground.components.parameter;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;

import java.util.function.Consumer;

public class ParameterBiDirectional {
    @Parameter
    private int count;

    enum SubmitType {
        COUNT_UP(ParameterBiDirectional::countUp),
        COUNT_DOWN(ParameterBiDirectional::countDown);

        private final Consumer<ParameterBiDirectional> action;

        SubmitType(Consumer<ParameterBiDirectional> action) {
            this.action = action;
        }

        private void doAction(ParameterBiDirectional parameterBiDirectional) {
            action.accept(parameterBiDirectional);
        }
    }

    private SubmitType submitType;

    public int getCount() {
        return count;
    }

    private void countUp() {
        count = count + 1;
    }

    private void countDown() {
        count = count - 1;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "countUp")
    void onSelectedFromCountUp() {
        submitType = SubmitType.COUNT_UP;
    }

    @OnEvent(value = EventConstants.SELECTED, component = "countDown")
    void onSelectedFromCountDown() {
        submitType = SubmitType.COUNT_DOWN;
    }

    @OnEvent(value = EventConstants.SUBMIT, component = "countForm")
    void onSubmitFromCountForm() {
        submitType.doAction(this);
    }
}
