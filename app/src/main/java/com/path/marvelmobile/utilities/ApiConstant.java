package com.path.marvelmobile.utilities;

public class ApiConstant {

    public static final String privateKey="3b9bbd7f2794a4fdb90741d3d237286a6f1834a5";
    public static final String publicKey="2d7e61a788660dd78d718af961c9d603";
    public static final String ts="ercan";

    public static String  getHashKey(){
        String key = ts + privateKey + publicKey;
        return MD5Helper.md5(key);
    }
}
