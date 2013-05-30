package eu.grigoriev.antigate.client.utils.types;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:39
 */
public enum CaptchaStatus {
    OK("OK|") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    CAPCHA_NOT_READY("CAPCHA_NOT_READY") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_KEY_DOES_NOT_EXIST("ERROR_KEY_DOES_NOT_EXIST") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_WRONG_ID_FORMAT("ERROR_WRONG_ID_FORMAT") {
        @Override
        public String getValue() {
            return value;
        }
    };

    final String value;

    private CaptchaStatus(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
