package eu.grigoriev.antigate.client.utils.types;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:06
 */
public enum NumericCaptcha {
    DEFAULT("0"),
    ONLY_NUMERIC("1"),
    WITHOUT_NUMERIC("2");

    private final String numericCode;

    private NumericCaptcha(final String numericCode){
        this.numericCode = numericCode;
    }

    public String getNumericCode() {
        return numericCode;
    }
}
