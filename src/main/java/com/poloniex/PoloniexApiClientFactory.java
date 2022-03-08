package com.poloniex;

import com.poloniex.impl.PoloniexApiAsyncRestClientImpl;
import com.poloniex.impl.PoloniexApiRestClientImpl;
import com.poloniex.impl.PoloniexApiService;
import com.poloniex.impl.PoloniexApiServiceGenerator;
import com.poloniex.security.ApiCredentials;
import okhttp3.OkHttpClient;

/**
 * A factory for creating Poloniex API client objects.
 */
public class PoloniexApiClientFactory {

    private final PoloniexApiServiceGenerator serviceGenerator;

    private final ApiCredentials apiCredentials;

    public PoloniexApiClientFactory() {
        this(new OkHttpClient(), null);
    }

    public PoloniexApiClientFactory(ApiCredentials apiCredentials) {
        this(new OkHttpClient(), apiCredentials);
    }

    private PoloniexApiClientFactory(OkHttpClient client, ApiCredentials apiCredentials) {
        this.serviceGenerator = new PoloniexApiServiceGenerator(client);
        this.apiCredentials = apiCredentials;
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
     * New instance with authentication.
     *
     * @return the Poloniex API client factory
     */
    public static PoloniexApiClientFactory newInstance(ApiCredentials apiCredentials) {
        return new PoloniexApiClientFactory(apiCredentials);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public PoloniexApiRestClient newRestClient() {
        return new PoloniexApiRestClientImpl(serviceGenerator.createService(PoloniexApiService.class, apiCredentials));
    }

    /**
     * Creates a new asynchronous/non-blocking REST client.
     */
    public PoloniexApiAsyncRestClient newAsyncRestClient() {
        return new PoloniexApiAsyncRestClientImpl(serviceGenerator.createService(PoloniexApiService.class, apiCredentials));
    }
}
