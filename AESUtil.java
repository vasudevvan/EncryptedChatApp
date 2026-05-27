package security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESUtil {

    private static final String KEY =
            "1234567890123456";

    public static String encrypt(String message)
            throws Exception {

        SecretKeySpec key =
                new SecretKeySpec(KEY.getBytes(), "AES");

        Cipher cipher =
                Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encrypted =
                cipher.doFinal(message.getBytes());

        return Base64.getEncoder()
                .encodeToString(encrypted);
    }

    public static String decrypt(String encryptedMessage)
            throws Exception {

        SecretKeySpec key =
                new SecretKeySpec(KEY.getBytes(), "AES");

        Cipher cipher =
                Cipher.getInstance("AES");

        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decoded =
                Base64.getDecoder()
                        .decode(encryptedMessage);

        return new String(cipher.doFinal(decoded));
    }
}