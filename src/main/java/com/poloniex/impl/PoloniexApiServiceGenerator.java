package com.poloniex.impl;

import com.poloniex.PoloniexApiError;
import com.poloniex.exception.PoloniexApiException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

import static com.poloniex.constant.PoloniexApiConstants.API_BASE_URL;

/**
 * Generates a Poloniex API implementation based on @see {@link PoloniexApiService}.
 */
public class PoloniexApiServiceGenerator {

    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();
    @SuppressWarnings("unchecked")
    private static final Converter<ResponseBody, PoloniexApiError> errorBodyConverter =
            (Converter<ResponseBody, PoloniexApiError>) converterFactory.responseBodyConverter(
                    PoloniexApiError.class, new Annotation[0], null);

    private final OkHttpClient client;

    public PoloniexApiServiceGenerator(OkHttpClient client) {
        this.client = client;
    }

    public <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                PoloniexApiError apiError = getPoloniexApiError(response);
                throw new PoloniexApiException(apiError);
            }
        } catch (IOException e) {
            throw new PoloniexApiException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static PoloniexApiError getPoloniexApiError(Response<?> response) throws IOException, PoloniexApiException {
        return errorBodyConverter.convert(response.errorBody());
    }
}
