package com.icss.freshshop.utils;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author : 齐双宝
 * @version : 1.0
 * @create : 2022/10/5/005 13:59
 * @Description :
 */
public class FaceUtil {
    private static final String AppID = "26219661";
    private static final String APIKey = "yzlqKzUNCX4E2wDst9GlYc21";
    private static final String SecretKey = "y0GSYCslqflpftdCB49tbukGNSlBqnFw";

    static AipFace client = null;
    static {
        client = new AipFace(AppID,APIKey,SecretKey);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }
    //人脸注册
    public static String faceRegister(String image,String userInfo,String userId,String groupId){
        HashMap<String,String> options = new HashMap<String,String>();
        options.put("user_info",userInfo);
        options.put("quality_control","NORMAL");
        options.put("liveness_control","LOW");
        options.put("action_type","REPLACE");
        String imageType = "BASE64";
        JSONObject res = client.addUser(image,imageType,groupId,userId,options);
        return res.toString(2);
    }

    //人脸登录
    public static String faceLogin(String image,String groupIdList){
        HashMap<String,Object> options = new HashMap<String,Object>();
        options.put("match_threshold","80");
        options.put("quality_control","NORMAL");
        options.put("liveness_control","LOW");
        String imageType = "BASE64";
        JSONObject res = client.search(image,imageType,groupIdList,options);
        return res.toString(2);
    }
}
