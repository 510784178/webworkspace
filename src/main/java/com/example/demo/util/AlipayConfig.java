package com.example.demo.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2021000116663681";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCzlCSndnYB8vJJtUdXdlAzUahzd34TuRl07omehR0eS8Ejh5lIidTwjuI3+U0JlBlNdfAvYY+qnDmmmW66DpJAIZ6fyJi3rORLQaYyiHmmObGk9R581tPlsq4nxvbA5/eF6IWN5CrePzwQqtOHFAliQcufJ5E61rRwYIQrg82DoqrN+sZ/xQRj5xwbF66HyCVoD4VDPu2zKdiI0uMzICL8LfBgYLPj56QpFTltGzvgbG3hBcwY0QtGhqqFmTju1ntoTsMh1HWfy4C4hI0wP4on/1wmnxe2CqwQ+UV13VCiq+FOWpr1LtJTGVnmjHkDslxc2oH41toULzU8ne0k8f83AgMBAAECggEAPZ04rlSQzL5krzGJltK7VcBQwb1f/rhlqZ8mjMMzaG+pht1BlIfmDduYdogNDJpJzDAJBti8iFct2KGQQjo5p9NhL4WOEIc7lS6jLXdx9byZ3PVVTpQPBCK4amFzzGBKpyFOoY6FvteHbliOVyxiw9m7WZIj3EJKirwy3RNN8jnMip00quYyQpX8DMgZ945GbEiPIYBJQYCMfymqiUpGavaN/cdBRlvVzXdpVZNhqxvaTfoqdOz37QW9Q7htGB8XEMfK3DZgEAAF7B4I/vqec8P/CtRgakZYzmSzMgCYXLVfEHSLe/YIa3o2MQx8nFy9eehvRqc1ohWJjO8icWZ7AQKBgQDffCySSbGA2TknECg61d1iyLOe2SijKA5zzdFubTvp6TDoglDW+M28ms9d89kPJGizXTsP8I0WN78afC6JPgv6yJzkgz18sW1QYK7WaVm6GoB1yrf7jujUExoMJu+sdVCKUuhp32C9ppk/9T+kK3i7aiiAUE/TRGzd11+TbVtQwQKBgQDNtKbX4PnW0w/KnS7+Y6ec0YJu32dAb6BM5NTx2+aMfQQUF0p10krVtlVyCeI1fsT7XWtqfh0l4Emeurpk0UgEtmLuWnLbQgXdr/oWWkpeyq8plq2UWMjHbf7mtuuFA2sCB8TYtcpjQfn3+oOeh3fiCg7e5jpVvU1mdrM8CsdV9wKBgAvHQZocJCzERgzW/yfKqbZRGZZfn5Kpw8k6qbUGMMgtMBSw+Y264yzzg8ZR2bjAlHwPh9NZPDZVjc7ZiKJXEM6Q0CQC/rSZrUc1MUG/n6j9SJPssTGi4IZ80zycuLkAHdSMdg9OZIzaQO1sAYSnfd9ywtuwX+SkkJBIj5L3in6BAoGAMaYqpuxMIQesRhEOKKRQ7k67FpuhRjIrFKQeqYmT6dC6zUaZ2Do7ib2Kfg3YpWTFko4HwRpTWrL50e/r0S2aHlkPI8x88GLNG6a/y+lbDeoJwRX3K1kKjOgFoBYCXoZmq4TIhC3MfYyNEsdKQVcdHlejIzWaWttn9RUtSY6och0CgYEArKWV560M4qzbdBKrdyxIS4PQFmVy4udLkHv3i9NCUWNoKUEhmKKJ/Y1syzDyyiDxVOG+ZHfwSqlAu5TpQJ63LALCG9cGZ2n8dvMGQIQP7xZfNYwyi/BIkvvCZhTPKfAHiMHrLEiM8wsh9K0yf/QUbX9HY3+xbyUwjxcY5cLfzMY=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkZe7e3S82iO8suNDyUL51+L5/I5HqVTz0GKI3nC6P9jkFFZTTXVUJ6hKUyzWr1XWh/ctI6/SvFiJCOl6eObHz8TbfPwQR+V4TYL2A1OeEnHKV9HX3tVPzbJOu6WwWaOIwCQHd5A/c3kTbLromg3o9i8L+6vEdNeb04Xp5fwP+4Nq5j4zNUgFdtpbhv12yM3IPcUJUyTbXEbaAZvq+rsxAa/y00sFFMhJM0gU2hT3PDOsq4XsNGmK/w4wa+/KSGsRbg1BQahZejR081ebiYPRDMbNITN2IFh7gZptVcZoJVpcaqdR0lQbU6VV+1FMTgNWzNJAESlDoqvs8IkqRTTDMwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

