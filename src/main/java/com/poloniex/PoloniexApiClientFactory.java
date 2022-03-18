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

    private ApiCredentials apiCredentials;

    public PoloniexApiClientFactory() {
        this.serviceGenerator = new PoloniexApiServiceGenerator(new OkHttpClient());
    }

    public PoloniexApiClientFactory(ApiCredentials apiCredentials) {
        this.serviceGenerator = new PoloniexApiServiceGenerator(new OkHttpClient());
        this.apiCredentials = apiCredentials;
    }

    public PoloniexApiClientFactory(ApiCredentials apiCredentials, ApiInteractionConfig apiInteractionConfig) {
        this(new OkHttpClient(), apiCredentials, apiInteractionConfig);
    }

    private PoloniexApiClientFactory(OkHttpClient client,
                                     ApiCredentials apiCredentials,
                                     ApiInteractionConfig apiInteractionConfig) {
        OkHttpClient newClient = client.newBuilder()
                .proxySelector(new CustomProxySelector(apiInteractionConfig.getProxies()))
                .addInterceptor(new RateLimitInterceptor(
                        apiInteractionConfig.getMaxRequestsPerSecond(),
                        apiInteractionConfig.getMaxApiKeyUsagePerSecond()
                )).build();
        this.serviceGenerator = new PoloniexApiServiceGenerator(newClient);
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
