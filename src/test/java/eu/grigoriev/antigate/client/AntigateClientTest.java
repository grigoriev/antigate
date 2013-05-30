package eu.grigoriev.antigate.client;

import eu.grigoriev.antigate.config.VisapointProxyAntigateConfig;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 14:45
 */
public class AntigateClientTest {
    private final AntigateClient antigateClient = new AntigateClient(new VisapointProxyAntigateConfig());

    @Test
    public void testGetBalance() throws Exception {
        double balance = antigateClient.getBalance();

        assertThat(balance).isGreaterThan(0);
    }

    @Test
    public void testError500() throws Exception {

    }

    @Test
    public void testRecognizeCaptcha() throws Exception {
        String filename = "VLQCZL.jpg";

        String response = antigateClient.recognizeCaptcha(filename);

        assertThat(response).isEqualToIgnoringCase("VLQCZL");
    }

    @Ignore
    @Test
    public void testAbuse() throws Exception {
        String captchaID = "";

        antigateClient.abuse(captchaID);
    }

}
