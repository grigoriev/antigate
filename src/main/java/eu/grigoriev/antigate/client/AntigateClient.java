package eu.grigoriev.antigate.client;

import eu.grigoriev.antigate.client.requests.AbuseInvalidCaptchaRequest;
import eu.grigoriev.antigate.client.requests.GetBalanceRequest;
import eu.grigoriev.antigate.client.requests.GetCaptchaStatusRequest;
import eu.grigoriev.antigate.client.requests.SendFileRequest;
import eu.grigoriev.antigate.client.responses.GetBalanceResponse;
import eu.grigoriev.antigate.client.responses.GetCaptchaStatusResponse;
import eu.grigoriev.antigate.client.responses.SendFileResponse;
import eu.grigoriev.antigate.client.utils.types.CaptchaStatus;
import eu.grigoriev.antigate.config.AntigateConfig;
import eu.grigoriev.antigate.config.DefaultAntigateConfig;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 14:36
 */
public class AntigateClient {
    private static AntigateConfig antigateConfig;
    private static final Logger logger = Logger.getLogger(AntigateClient.class);

    public AntigateClient(AntigateConfig config) {
        antigateConfig = config;
    }

    public double getBalance() throws IOException {
        logger.info("getting balance");
        GetBalanceRequest getBalanceRequest = new GetBalanceRequest();
        GetBalanceResponse getBalanceResponse = getBalanceRequest.execute();
        logger.info("balance has been received : " + getBalanceResponse.getBalance());
        return getBalanceResponse.getBalance();
    }

    public String recognizeCaptcha(String fileName) throws IOException, InterruptedException {
        logger.info("recognizing captcha from file " + fileName);
        String captchaID = sendCaptcha(fileName).getCaptchaID();
        logger.info("captcha was sent to server; waiting for 10 seconds");

        Thread.sleep(10000);

        int attempts = 1;
        while (attempts < AntigateClient.getAntigateConfig().getNumberOfAttempts()) {
            attempts++;
            GetCaptchaStatusResponse getCaptchaStatusResponse = getCaptchaStatus(captchaID);

            if (getCaptchaStatusResponse.getCaptchaStatus().equals(CaptchaStatus.OK)) {
                logger.info("recognized captcha has been received : " + getCaptchaStatusResponse.getCaptchaWord());
                return getCaptchaStatusResponse.getCaptchaWord();
            } else {
                logger.info("attempt " + attempts + "; captcha status is : " + getCaptchaStatusResponse.getCaptchaStatus());
            }

            logger.info("waiting for 5 seconds");
            Thread.sleep(5000);
        }

        logger.info("returning null due to number of attempts more then " + AntigateClient.getAntigateConfig().getNumberOfAttempts());
        return null;
    }

    public void abuse(String captchaID) throws IOException {
        logger.info("captcha was recognized with error; sending information to the server");
        AbuseInvalidCaptchaRequest abuseInvalidCaptchaRequest = new AbuseInvalidCaptchaRequest(captchaID);
        abuseInvalidCaptchaRequest.execute();
        logger.info("information has been sent");
    }

    private SendFileResponse sendCaptcha(final String filePath) throws IOException {
        SendFileRequest sendFileRequest = new SendFileRequest(filePath);
        return sendFileRequest.execute();
    }

    private GetCaptchaStatusResponse getCaptchaStatus(String captchaID) throws IOException {
        GetCaptchaStatusRequest getCaptchaStatusRequest = new GetCaptchaStatusRequest(captchaID);
        return getCaptchaStatusRequest.execute();
    }

    public static AntigateConfig getAntigateConfig() {
        if (antigateConfig == null) {
            antigateConfig = new DefaultAntigateConfig();
        }
        return antigateConfig;
    }
}
