package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.AntigateClient;
import eu.grigoriev.antigate.client.responses.AbuseInvalidCaptchaResponse;
import eu.grigoriev.antigate.config.constants.AntigateConstants;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 18:10
 */
public class AbuseInvalidCaptchaRequest implements Request<AbuseInvalidCaptchaResponse> {
    private final String captchaID;

    public AbuseInvalidCaptchaRequest(String captchaID) {
        this.captchaID = captchaID;
    }

    @Override
    public AbuseInvalidCaptchaResponse execute() throws IOException {
        HttpGet get = new HttpGet(AntigateConstants.OPERATE_CAPTCHA_URL + getAbuseURIParameters(captchaID));

        RequestHelper.execute(get);

        return new AbuseInvalidCaptchaResponse();
    }

    private String getAbuseURIParameters(String captchaID) {
        return "?key=" + AntigateClient.getAntigateConfig().getKey() + "&action=reportbad&id=" + captchaID;
    }
}
