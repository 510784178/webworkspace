package com.example.demo.web;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Shoppcar;
import com.example.demo.pojo.Student;
import com.example.demo.service.ICardService;
import com.example.demo.util.AlipayConfig;

@RestController//相当于@Controller+@ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class ShoppcarController {
	@Autowired
	private ICardService cardService;
	@RequestMapping(path="/addshoppcar",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean addShoppcar (Goods goods,Integer num,HttpSession session) {
		Shoppcar shoppcar=new Shoppcar();
		shoppcar.setShoppcarImage(goods.getGoodsImage());
		shoppcar.setShoppcarName(goods.getGoodsName());
		shoppcar.setShoppcarNum(num);
		shoppcar.setShoppcarPrice(goods.getGoodsPrice());
		Student student=(Student)session.getAttribute("stu");
		System.out.println(student);
		shoppcar.setShoppcarStuid(student.getStuId());
		return cardService.addShoppcar(shoppcar);
	}
	@RequestMapping(path="/showshoppcar",method= {RequestMethod.GET,RequestMethod.POST})
	public List<Shoppcar> listShoppcar (HttpSession session) {
		Student student=(Student)session.getAttribute("stu");
		return cardService.selectBystuId(student.getStuId());
	}
	@RequestMapping(path="/delshoppcargoods",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleShoppcargood (Integer carId) {
		System.out.println(carId);
		return cardService.deleteBycarId(carId);
	}
	@RequestMapping(path="/delAllShoppcarGoods",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleAllShoppcargoods (Integer[] id) {
		boolean rt=false;
		for(Integer carId:id) {
			rt=cardService.deleteBycarId(carId);
		}
		return rt;
	}
	@RequestMapping(path="/payAllShoppcarGoods",method= {RequestMethod.GET,RequestMethod.POST})
	public String payAllShoppcargoods (Integer[] id,Integer allmoney,HttpServletRequest request,HttpSession session) {
		String result=null;
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		Student student=(Student)session.getAttribute("stu");
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no =UUID.randomUUID().toString()+student.getStuId();
		//付款金额，必填
		String total_amount = allmoney+"";
		//订单名称，必填
		String subject = UUID.randomUUID().toString()+student.getStuLogin();
		//商品描述，可空
		String body =null;
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//请求
		try {
			result= alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 for(Integer carId:id) { 
			 cardService.deleteBycarId(carId); 
		 }
		return result;
	}
}
