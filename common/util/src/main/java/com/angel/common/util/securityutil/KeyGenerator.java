package com.angel.common.util.securityutil;

import java.security.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lijn on 2015/9/1.
 *
 * @author Lijn
 */
@SuppressWarnings("unused")
public class KeyGenerator {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    public static final String PUBLIC_KEY = "public_key";
    public static final String PRIVATE_KEY = "private_key";

        public static Map<String,String> getHexEncryptedRSAKey() {
            KeyPair keyPair;
            Map<String,String> keyMap = new HashMap<String,String>(2);

            try {
                keyPair = initKey();
                String publicKey = getPublicKey(keyPair);
                System.out.println("genreate public key: " + publicKey);
                keyMap.put(PUBLIC_KEY, publicKey);

                String privateKey = getPrivateKey(keyPair);
                System.out.println("genreate private key: " + privateKey);
                keyMap.put(PRIVATE_KEY, privateKey);
            }catch(Exception e){
                e.printStackTrace();
            }
            return keyMap;
        }
        public static String getPublicKey(KeyPair keyPair) throws Exception {
            PublicKey publicKey = keyPair.getPublic();
            return encryptHexString(publicKey.getEncoded());
        }
        public static String getPrivateKey(KeyPair keyPair) throws Exception {
            PrivateKey privateKey = keyPair.getPrivate();
            return encryptHexString(privateKey.getEncoded());
        }
//
//        public static byte[] decryptBASE64(String key) throws Exception {
//            return (new BASE64Decoder()).decodeBuffer(key);
//        }
//
//        public static String encryptBASE64(byte[] key) throws Exception {
//            return (new BASE64Encoder()).encodeBuffer(key);
//        }

        private static char[] HEXCHAR = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        public static String encryptHexString(byte[] key) {
            StringBuilder sb = new StringBuilder(key.length * 2);
            for (int i = 0; i < key.length; i++) {
                sb.append(HEXCHAR[(key[i] & 0xf0) >>> 4]);
                sb.append(HEXCHAR[key[i] & 0x0f]);
            }
            return sb.toString();
        }

        public static KeyPair initKey() throws Exception {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            keyPairGen.initialize(1024, new SecureRandom());
            KeyPair keyPair = keyPairGen.generateKeyPair();
            return keyPair;
        }

}
