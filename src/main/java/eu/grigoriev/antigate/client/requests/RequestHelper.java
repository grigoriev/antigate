package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.AntigateClient;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 19:24
 */
class RequestHelper {
    private static DefaultHttpClient httpClient;

    private static HttpClient getHttpClient() {
        if (httpClient == null) {
            final HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, AntigateClient.getAntigateConfig().getTimeout());
            HttpConnectionParams.setSoTimeout(httpParams, AntigateClient.getAntigateConfig().getTimeout());

            httpClient = new DefaultHttpClient(httpParams);
            httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
            if (AntigateClient.getAntigateConfig().useProxy()) {
                HttpHost proxy = new HttpHost(AntigateClient.getAntigateConfig().getProxyHost(), AntigateClient.getAntigateConfig().getProxyPort(), "http");
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            }
        }
        return httpClient;
    }

    public static HttpResponse execute(final HttpUriRequest request) throws IOException {
        return getHttpClient().execute(request);
    }

    public static void shutDownConnection() {
        getHttpClient().getConnectionManager().shutdown();
    }
}
