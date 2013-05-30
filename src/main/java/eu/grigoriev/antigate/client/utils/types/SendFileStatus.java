package eu.grigoriev.antigate.client.utils.types;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 18:07
 */
enum SendFileStatus {
    OK("OK|") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_WRONG_USER_KEY("ERROR_WRONG_USER_KEY") {
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
    ERROR_ZERO_BALANCE("ERROR_ZERO_BALANCE") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_NO_SLOT_AVAILABLE("ERROR_NO_SLOT_AVAILABLE") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_ZERO_CAPTCHA_FILESIZE("ERROR_ZERO_CAPTCHA_FILESIZE") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_TOO_BIG_CAPTCHA_FILESIZE("ERROR_TOO_BIG_CAPTCHA_FILESIZE") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_WRONG_FILE_EXTENSION("ERROR_WRONG_FILE_EXTENSION") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_IMAGE_TYPE_NOT_SUPPORTED("ERROR_IMAGE_TYPE_NOT_SUPPORTED") {
        @Override
        public String getValue() {
            return this.value;
        }
    },
    ERROR_IP_NOT_ALLOWED("ERROR_IP_NOT_ALLOWED") {
        @Override
        public String getValue() {
            return this.value;
        }
    };

    final String value;

    private SendFileStatus(String value) {
        this.value = value;
    }

    public abstract String getValue();
}
