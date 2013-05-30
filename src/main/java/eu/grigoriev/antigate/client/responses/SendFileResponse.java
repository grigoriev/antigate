package eu.grigoriev.antigate.client.responses;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 16:40
 */
public class SendFileResponse implements Response {
    private String captchaID;

    public SendFileResponse(String captchaID) {
        this.captchaID = captchaID;
    }

    public String getCaptchaID() {
        return captchaID;
    }

    public void setCaptchaID(String captchaID) {
        this.captchaID = captchaID;
    }
}
