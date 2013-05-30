package eu.grigoriev.antigate.client.utils;

import eu.grigoriev.antigate.client.utils.types.CaptchaStatus;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:52
 */
public class AntigateResponseParser {
    public static double parseGetBalanceResponse(HttpEntity entity) throws IOException {
        String responseText = EntityUtils.toString(entity, "UTF-8");

        return Double.parseDouble(responseText);
    }

    public static String parseSendFileResponse(HttpEntity entity) throws IOException {
        String responseText = EntityUtils.toString(entity, "UTF-8");

        if (responseText.startsWith(CaptchaStatus.OK.getValue())) {
            return responseText.substring(CaptchaStatus.OK.getValue().length(), responseText.length());
        } else {
            return responseText;
        }
    }

    public static String parseGetCaptchaStatusResponse(HttpEntity entity) throws IOException {
        String responseText = EntityUtils.toString(entity, "UTF-8");

        if (responseText.startsWith(CaptchaStatus.OK.getValue())) {
            return responseText.substring(CaptchaStatus.OK.getValue().length(), responseText.length());
        } else {
            return null;
        }
    }
}
