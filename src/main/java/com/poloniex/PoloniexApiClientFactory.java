package com.poloniex;

import com.poloniex.impl.PoloniexApiAsyncRestClientImpl;
import com.poloniex.impl.PoloniexApiRestClientImpl;
import com.poloniex.impl.PoloniexApiService;
import com.poloniex.impl.PoloniexApiServiceGenerator;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Poloniex API client objects.
 */
public class PoloniexApiClientFactory {

    private final PoloniexApiServiceGenerator serviceGenerator;

    public PoloniexApiClientFactory() {
        this(new OkHttpClient());
    }

    private PoloniexApiClientFactory(OkHttpClient client) {
        this.serviceGenerator = new PoloniexApiServiceGenerator(client);
    }

    /**
     * New instance without authentication.
     *
     * @return the Poloniex API client factory
     */
    public static PoloniexApiClientFactory newInstance() {
        return new PoloniexApiClientFactory();
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public PoloniexApiRestClient newRestClient() {
        return new PoloniexApiRestClientImpl(serviceGenerator.createService(PoloniexApiService.class));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public PoloniexApiAsyncRestClient newAsyncRestClient() {
        return new PoloniexApiAsyncRestClientImpl(serviceGenerator.createService(PoloniexApiService.class));
    }
}
