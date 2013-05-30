package eu.grigoriev.antigate.config;

import eu.grigoriev.antigate.client.utils.types.NumericCaptcha;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:04
 */
@SuppressWarnings("ALL")
public class AntigateConfig {
    private String key;

    private float priceOfThousands;
    private boolean isRussian;
    private int maxLength;
    private int minLength;
    private boolean isMathExpression;
    private NumericCaptcha numeric;
    private boolean isRegisterSensitive;
    private boolean isTwoWords;

    private String proxyHost;
    private int proxyPort;
    private int numberOfAttempts;
    private int timeout;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public float getPriceOfThousands() {
        return priceOfThousands;
    }

    public void setPriceOfThousands(float priceOfThousands) {
        this.priceOfThousands = priceOfThousands;
    }

    public boolean isRussian() {
        return isRussian;
    }

    public void setRussian(boolean russian) {
        isRussian = russian;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public boolean isMathExpression() {
        return isMathExpression;
    }

    public void setMathExpression(boolean mathExpression) {
        isMathExpression = mathExpression;
    }

    public NumericCaptcha getNumeric() {
        return numeric;
    }

    public void setNumeric(NumericCaptcha numeric) {
        this.numeric = numeric;
    }

    public boolean isRegisterSensitive() {
        return isRegisterSensitive;
    }

    public void setRegisterSensitive(boolean registerSensitive) {
        isRegisterSensitive = registerSensitive;
    }

    public boolean isTwoWords() {
        return isTwoWords;
    }

    public void setTwoWords(boolean twoWords) {
        isTwoWords = twoWords;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public boolean useProxy() {
        return (!(getProxyHost() == null || getProxyHost().isEmpty()) && getProxyPort() != 0);
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
