package com.poloniex.security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_512;

/**
 * Utility class to sign messages using HMAC-SHA512.
 */
public final class HmacSHA512Signer {

    /**
     * Sign the given message using the given secret.
     *
     * @param message message to sign
     * @param secret  secret key
     * @return a signed message encoded in HEX string
     */
    public static String signEncodedInHexString(String message, String secret) {
        return Hex.encodeHexString(sign(message, secret));
    }

    /**
     * Sign the given message using the given secret.
     *
     * @param message message to sign
     * @param secret  secret key
     * @return a signed message in bytes
     */
    public static byte[] sign(String message, String secret) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), HMAC_SHA_512.getName());
            Mac sha256_HMAC = Mac.getInstance(HMAC_SHA_512.getName());
            sha256_HMAC.init(secretKeySpec);
            return sha256_HMAC.doFinal(message.getBytes(UTF_8));
        } catch (Exception e) {
            throw new RuntimeException("unable to sign message", e);
        }
    }
}
