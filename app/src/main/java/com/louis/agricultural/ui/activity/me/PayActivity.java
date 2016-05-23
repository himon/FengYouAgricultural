package com.louis.agricultural.ui.activity.me;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.louis.agricultural.R;
import com.louis.agricultural.alipay.PayResult;
import com.louis.agricultural.alipay.SignUtils;
import com.louis.agricultural.base.activity.BaseActivity;
import com.louis.agricultural.base.app.Constants;
import com.louis.agricultural.model.event.MyOrderEvent;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * 支付页面
 */
public class PayActivity extends BaseActivity {

    // 商户PID
    public static final String PARTNER = "2088221616856461";
    // 商户收款账号
    public static final String SELLER = "lyfylqm@163.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICXAIBAAKBgQDWZ83R14GeKRXBUTwGzPlXjYq1tFZtm5bWMmjcxaJm7JJFbfEAvtiYN5RMIct7zM19cCA7kAHSekEtLGyMoy+OlM2AC4zv/R2+fd5gIIzUgeGU9zw+3LjrAQzUAIIUwq63gYYKK9YsbLto50UubVvU31Z9EeJOLDKV8nfe/2CPGwIDAQABAoGABrxuJ/iYVuq9hzxRIXmRH+IPiJPo3zqzK3mb98uxxYALPGku2DImxemBHD83kGUn05gROy3UENPMdmnd4zFBTi+9fH3LaoCAScHZTdvDlE+y4AZdpV2SPdUhxkdUTEu7njnxR/Y7sG5eaX1Wk1Bafr7+dOPrHLJvUQe39MEXShkCQQDy+4Luvh+GL4kmgc490uryrPyFrvoEUajUk4DE+01MYobccPoLt3qG4PLegPTitNh21bIqA0YpgjPNjeTD7aANAkEA4eRccL5dl4gZeUvyHDzTJSB876plZLLtNVmxlndIw4TEKFBhn5qST25PRg3faNuQ7KSdWoFVJx3cuzu6sU95xwJBAO1q29CzbNIMeJJrmz3FbVSZulRVWG4H7FNpnRTcB/du/h8/NNNmAA7yldzbXGx4EFptC50JffDpC/z5fGIFObECQFBeZDlEsZ3ZMV8Dk0dSqLjb3zeSA3MZaeYCXHmxRPUzRmsldiZH42hZUeEVzHfNLrnTM5zgyQAa0s7WyGyPXz8CQCWxiRh6Xy0UZ5nPJJyqQA7u5wtIeec/l4M5HYx1UVY0Hpuq+EAF5WeiEA5iudoW3vklLHHVlu2BPMmzAFL6vOg=";
    // 支付宝公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWZ83R14GeKRXBUTwGzPlXjYq1tFZtm5bWMmjcxaJm7JJFbfEAvtiYN5RMIct7zM19cCA7kAHSekEtLGyMoy+OlM2AC4zv/R2+fd5gIIzUgeGU9zw+3LjrAQzUAIIUwq63gYYKK9YsbLto50UubVvU31Z9EeJOLDKV8nfe/2CPGwIDAQAB";
    private static final int SDK_PAY_FLAG = 1;

    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(PayActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        MyOrderEvent event = new MyOrderEvent("update_pay");
                        event.setOrderId(mNo);
                        event.setStatus("2");
                        EventBus.getDefault().post(event);
                        finish();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(PayActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(PayActivity.this, "支付失败", Toast.LENGTH_SHORT).show();

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };


    @Bind(R.id.cb_alipay)
    CheckBox mCbAlipay;
    @Bind(R.id.cb_bank)
    CheckBox mCbBank;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.btn_pay)
    Button mBtnPay;
    private String mPrice;
    private String mNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void initView() {
        initTitle("支付");

        initEvent();
    }

    private void initEvent() {
        mBtnPay.setOnClickListener(this);

        mCbAlipay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mCbBank.setChecked(false);
                }
            }
        });

        mCbBank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mCbAlipay.setChecked(false);
                }
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mPrice = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY);
            mNo = intent.getStringExtra(Constants.MESSAGE_EXTRA_KEY2);
            mTvPrice.setText("还需支付：￥" + mPrice);
        }
    }

    @Override
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_pay:
                pay();
                break;
        }
    }

    private void pay() {
        if (mCbAlipay.isChecked()) {
            alipay();
        } else {

        }
    }

    /**
     * call alipay sdk pay. 调用SDK支付
     */
    public void alipay() {
        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置PARTNER | RSA_PRIVATE| SELLER")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialoginterface, int i) {
                            //
                            finish();
                        }
                    }).show();
            return;
        }
        String orderInfo = getOrderInfo("订单号:" + mNo, "该测试商品的详细描述", mPrice);

        /**
         * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
         */
        String sign = sign(orderInfo);
        try {
            /**
             * 仅需对sign 做URL编码
             */
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * 完整的符合支付宝参数规范的订单信息
         */
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }

    /**
     * create the order info. 创建订单信息
     */
    private String getOrderInfo(String subject, String body, String price) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + SELLER + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + mNo + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=\"30m\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        orderInfo += "&return_url=\"m.alipay.com\"";

        // 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
        // orderInfo += "&paymethod=\"expressGateway\"";

        return orderInfo;
    }

    /**
     * get the out_trade_no for an order. 生成商户订单号，该值在商户端应保持唯一（可自定义格式规范）
     */
    private String getOutTradeNo() {
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
        Date date = new Date();
        String key = format.format(date);

        Random r = new Random();
        key = key + r.nextInt();
        key = key.substring(0, 15);
        return key;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }
}
