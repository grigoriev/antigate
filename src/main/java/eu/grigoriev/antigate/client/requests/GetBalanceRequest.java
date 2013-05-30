package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.AntigateClient;
import eu.grigoriev.antigate.client.responses.GetBalanceResponse;
import eu.grigoriev.antigate.client.utils.AntigateResponseParser;
import eu.grigoriev.antigate.config.constants.AntigateConstants;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:40
 */
public class GetBalanceRequest implements Request<GetBalanceResponse> {
    @Override
    public GetBalanceResponse execute() throws IOException {
        HttpGet get = new HttpGet(AntigateConstants.OPERATE_CAPTCHA_URL + getBalanceURIParameters());

        HttpResponse httpResponse = RequestHelper.execute(get);
        double balance = AntigateResponseParser.parseGetBalanceResponse(httpResponse.getEntity());

        return new GetBalanceResponse(balance);
    }

    private String getBalanceURIParameters() {
        return "?key=" + AntigateClient.getAntigateConfig().getKey() + "&action=getbalance";
    }
}
