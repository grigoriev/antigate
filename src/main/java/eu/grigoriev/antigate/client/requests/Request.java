package eu.grigoriev.antigate.client.requests;

import eu.grigoriev.antigate.client.responses.Response;

import java.io.IOException;

/**
 * Author: Sergey Grigoriev
 * Created: 19.12.12 15:40
 */
public interface  Request<T extends Response> {
    T execute() throws IOException;
}
