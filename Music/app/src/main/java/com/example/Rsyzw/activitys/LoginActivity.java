package com.example.Rsyzw.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.Rsyzw.R;
import com.example.Rsyzw.utils.UserUtils;
import com.example.Rsyzw.views.InputView;

import java.util.*;
import com.example.Rsyzw.tools.*;


public class LoginActivity extends BaseActivity {

    private InputView mInputPhone, mInputPassword,mInputFace;
    private int age;
    private String emotion;
    private String image_url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575192485964&di=fd6c10047200e942f898b98451426971&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7e3e6709c93d70cf9e598ff9f2dcd100bba12ba6.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView () {
        initNavBar(false, "登录", false);

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
        mInputFace=fd(R.id.input_face);
    }


    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick (View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 登录
     */
    public void onCommitClick (View v) {

        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

//        验证用户输入是否合法
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }


//        跳转到应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }
    /**
        * 人脸登录
     */
    public void faceDetect(View v) throws InterruptedException {
        image_url=mInputFace.getInputStr();
        String happy="happy";
        final String image="";

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
                try {
                    Map<String, Object> map = new HashMap<>();
                    if(image_url.equals(image)){
                        image_url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575192485964&di=fd6c10047200e942f898b98451426971&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7e3e6709c93d70cf9e598ff9f2dcd100bba12ba6.jpg";
                    }
                    map.put("image",image_url);//"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575192485964&di=fd6c10047200e942f898b98451426971&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F7e3e6709c93d70cf9e598ff9f2dcd100bba12ba6.jpg");
                    map.put("face_field", "age,emotion");
                    map.put("image_type", "URL");

                    String param = GsonUtils.toJson(map);

                    // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                    String accessToken = "24.e10e2a7f3ecbfb20fe51c37c16bc46fb.2592000.1577779527.282335-17899480";

                    String result = HttpUtil.post(url, accessToken, "application/json", param);

                    String[] split_result=result.split(",");

                    String[] split_age=split_result[16].split(":");
                    age=Integer.parseInt(split_age[1]);

                    String[] split_emotion=split_result[17].split(":");
                    emotion=split_emotion[2].replace("\"","").trim();

                } catch (Exception e) {
                    e.printStackTrace();
                }finally {


                }

            }
        }).start();


        if(age>=18 && emotion.equals(happy)){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if (age==0){
            Toast.makeText(LoginActivity.this, "请等等，正在检测你的脸", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "年龄太小或者不开心", Toast.LENGTH_LONG).show();
        }





    }

}
