package eu.grigoriev.antigate.client.responses;

import eu.grigoriev.antigate.client.utils.types.CaptchaStatus;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 16:55
 */
public class GetCaptchaStatusResponse implements Response {
    private CaptchaStatus captchaStatus;
    private String captchaWord;

    public GetCaptchaStatusResponse(final String captchaWord, CaptchaStatus status) {
        this.captchaWord = captchaWord;
        this.captchaStatus = status;

    }
    public CaptchaStatus getCaptchaStatus() {
        return captchaStatus;
    }

    public void setCaptchaStatus(CaptchaStatus captchaStatus) {
        this.captchaStatus = captchaStatus;
    }

    public String getCaptchaWord() {
        return captchaWord;
    }

    public void setCaptchaWord(String captchaWord) {
        this.captchaWord = captchaWord;
    }
}
