package eu.grigoriev.antigate.config;

import eu.grigoriev.antigate.config.constants.AntigateConstants;
import eu.grigoriev.antigate.client.utils.types.NumericCaptcha;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:07
 */
public class DefaultAntigateConfig extends AntigateConfig {
    public DefaultAntigateConfig() {
        setKey(AntigateConstants.DEFAULT_ANTIGATE_ACCOUNT_KEY);

        setPriceOfThousands(1.0f);
        setRussian(false);
        setMaxLength(0);
        setMinLength(0);
        setMathExpression(false);
        setNumeric(NumericCaptcha.DEFAULT);
        setRegisterSensitive(false);
        setTwoWords(false);

        setProxyHost("");
        setProxyPort(0);

        setNumberOfAttempts(10);
        setTimeout(10000);
    }
}
