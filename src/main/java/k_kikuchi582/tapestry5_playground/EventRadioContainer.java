package k_kikuchi582.tapestry5_playground;

public interface EventRadioContainer {
    String getControlName();
    boolean isDisabled();
    boolean isSelected(Object value);
    String getEvent();
    Object[] getContext();
    String getZone();
}
