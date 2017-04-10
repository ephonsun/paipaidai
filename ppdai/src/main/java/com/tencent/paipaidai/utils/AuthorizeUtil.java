package com.tencent.paipaidai.utils;

import com.ppdai.open.core.AuthInfo;
import com.ppdai.open.core.OpenApiClient;
import com.ppdai.open.core.RsaCryptoHelper;

/**
 *
 */

public class AuthorizeUtil {

    // ����˹�Կ
    private static final String serverPublicKey="your_public_key";
    // �ͻ���˽Կ
    private static final  String clientPrivateKey = "your_private_key";
    // Ӧ��ID
    private static final String appid="your_appid";
    //AccessToken
    private static final String  accessToken = "your_accesstoken";
    /**
     * �û���Ȩ��¼��ȡaccesstoken
     * @param code
     * @return
     * @throws Exception
     */
    public static String getAccessToken(String code) throws Exception {
        //����ʼ��һ�μ���
        OpenApiClient.Init(appId, RsaCryptoHelper.PKCSType.PKCS8, serverPublicKey, clientPrivateKey);
        //��Ȩ��Ϣ
        AuthInfo authInfo = OpenApiClient.authorize(code);
        //��ȡaccessToken
        String accessToke = authInfo.getAccessToken();
        return accessToke;
    }
}
