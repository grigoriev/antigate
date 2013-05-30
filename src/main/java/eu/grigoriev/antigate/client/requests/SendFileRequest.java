package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.AntigateClient;
import eu.grigoriev.antigate.client.responses.SendFileResponse;
import eu.grigoriev.antigate.client.utils.AntigateResponseParser;
import eu.grigoriev.antigate.config.AntigateConfig;
import eu.grigoriev.antigate.config.constants.AntigateConstants;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 16:40
 */
public class SendFileRequest implements Request<SendFileResponse> {
    private final String filePath;

    public SendFileRequest(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public SendFileResponse execute() throws IOException {
        File file = new File(filePath);

        MultipartEntity entity = createMultipartEntity();
        entity.addPart("file", new FileBody(file, "application/zip"));

        HttpPost post = new HttpPost(AntigateConstants.SEND_CAPTCHA_URL);
        post.setEntity(entity);

        String captchaID;
        captchaID = AntigateResponseParser.parseSendFileResponse(RequestHelper.execute(post).getEntity());

        return new SendFileResponse(captchaID);
    }

    private MultipartEntity createMultipartEntity() throws UnsupportedEncodingException {
        AntigateConfig config = AntigateClient.getAntigateConfig();

        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

        addPartToEntity(entity, "key", config.getKey());
        addPartToEntity(entity, "method", "post");

        if (config.isTwoWords()) {
            addPartToEntity(entity, "phrase", "1");
        } else {
            addPartToEntity(entity, "phrase", "0");
        }

        if (config.isRegisterSensitive()) {
            addPartToEntity(entity, "regsense", "1");
        } else {
            addPartToEntity(entity, "regsense", "0");
        }

        addPartToEntity(entity, "numeric", config.getNumeric().getNumericCode());

        if (config.isMathExpression()) {
            addPartToEntity(entity, "calc", "1");
        } else {
            addPartToEntity(entity, "calc", "0");
        }

        addPartToEntity(entity, "min_len", String.valueOf(config.getMinLength()));

        addPartToEntity(entity, "max_len", String.valueOf(config.getMaxLength()));

        if (config.isRussian()) {
            addPartToEntity(entity, "is_russian", "1");
        } else {
            addPartToEntity(entity, "is_russian", "0");
        }

        addPartToEntity(entity, "max_bid", String.valueOf(config.getPriceOfThousands()));

        return entity;
    }

    private void addPartToEntity(final MultipartEntity entity, final String name, final String value) throws UnsupportedEncodingException {
        entity.addPart(name, new StringBody(value, Charset.forName("UTF-8")));
    }

}
