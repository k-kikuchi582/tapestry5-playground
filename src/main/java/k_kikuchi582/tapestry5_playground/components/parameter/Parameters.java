package k_kikuchi582.tapestry5_playground.components.parameter;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;

public class Parameters {
    // パラメータはフィールドの名前
    @Parameter
    private String paramA;

    // nameでパラメータの名前を変更することができる
    @Parameter(name = "b")
    private String paramB;

    // required=trueでパラメータを必須にできる
    @Parameter(required = true)
    private String paramC;

    // defaultPrefixでBindingPrefixを変更することができる、デフォルトは'prop'
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String paramD;

    // valueでデフォルトの値を設定できる
    @Parameter(value = "'defaultValue'")
    private String paramE;

    // allowNull=falseでnullを不可にできる
    @Parameter(allowNull = false)
    private String paramF;

    // @Parameterなフィールドはprivateでなければならない
//    @Parameter
//    String nonPrivateParam;

    public String getParamA() {
        return paramA;
    }

    public String getParamB() {
        return paramB;
    }

    public String getParamC() {
        return paramC;
    }

    public String getParamD() {
        return paramD;
    }

    public String getParamE() {
        return paramE;
    }

    public String getParamF() {
        return paramF;
    }
}
