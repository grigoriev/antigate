package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.AntigateClient;
import eu.grigoriev.antigate.client.responses.GetCaptchaStatusResponse;
import eu.grigoriev.antigate.client.utils.AntigateResponseParser;
import eu.grigoriev.antigate.client.utils.types.CaptchaStatus;
import eu.grigoriev.antigate.config.constants.AntigateConstants;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 16:57
 */
public class GetCaptchaStatusRequest implements Request<GetCaptchaStatusResponse> {
    private final String captchaID;

    public GetCaptchaStatusRequest(String captchaID) {
        this.captchaID = captchaID;
    }

    @Override
    public GetCaptchaStatusResponse execute() throws IOException {
        HttpGet get = new HttpGet(AntigateConstants.OPERATE_CAPTCHA_URL + getCaptchaStatusURIParameters(captchaID));

        HttpResponse response = RequestHelper.execute(get);
        String result = AntigateResponseParser.parseGetCaptchaStatusResponse(response.getEntity());

        GetCaptchaStatusResponse statusResponse;
        if (result != null) {
            statusResponse = new GetCaptchaStatusResponse(result, CaptchaStatus.OK);
        } else {
            statusResponse = new GetCaptchaStatusResponse(null, CaptchaStatus.CAPCHA_NOT_READY);
        }

        return statusResponse;
    }

    private String getCaptchaStatusURIParameters(String captchaID) {
        return "?key=" + AntigateClient.getAntigateConfig().getKey() + "&action=get&id=" + captchaID;
    }
}
