package com.cook.baolema.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class SmsService {

    public static void send(String phone,String key){
        //第二个参数为自己独有的accessKeyid，第三个参数为自己独有的accessKeySecret
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                "LTAI5tBmnKNmd61ubDngpfyG","C5xWKjWVS2WIQGwFqY8P5kflr1j2Cc");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();//组装请求对象
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);//设置post提交
        request.setDomain("dysmsapi.aliyuncs.com");//短信API产品域名（接口地址固定，无需修改）
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "邹伟个人博客");//短信签名
        request.putQueryParameter("TemplateCode", "SMS_273355088");
        request.putQueryParameter("TemplateParam","{\"code\":\""+key+"\"}");//code阿里云模板只有一个短信参数
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        SmsService.send("15172118655","1110");
    }
}
