package com.poloniex.impl;

import com.poloniex.PoloniexApiError;
import com.poloniex.exception.PoloniexApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static com.poloniex.impl.PoloniexApiServiceGenerator.getPoloniexApiError;

/**
 * An adapter/wrapper that transform a response to the {@link CompletableFuture}.
 */
public class RetrofitCallbackAdapter<T> implements Callback<T> {

    private final CompletableFuture<T> future;

    public RetrofitCallbackAdapter(CompletableFuture<T> future) {
        this.future = future;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            future.complete(response.body());
        } else {
            try {
                PoloniexApiError apiError = getPoloniexApiError(response);
                onFailure(call, new PoloniexApiException(apiError));
            } catch (IOException e) {
                onFailure(call, new PoloniexApiException(e));
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof PoloniexApiException) {
            future.completeExceptionally(t);
        } else {
            future.completeExceptionally(new PoloniexApiException(t));
        }
    }
}
