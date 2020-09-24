package com.example.demo.web;


import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.Goods;
import com.example.demo.service.ICardService;

import io.minio.MinioClient;

@RestController//相当于@Controller+@ResponseBody
@RequestMapping("/card")
@CrossOrigin(allowCredentials="true", allowedHeaders="*")
public class GoodsController {
	@Autowired
	private ICardService cardService;
	@RequestMapping(path="/goodslist",method= {RequestMethod.GET,RequestMethod.POST})
	public  List<Goods> listGoods(HttpSession session) {
		List<Goods> goodsList=cardService.listAllGoods();
		return goodsList;	
	}
	@RequestMapping(path="/querygoods",method= {RequestMethod.GET,RequestMethod.POST})
	public Goods queryGoods (Integer goodsId) {
		return cardService.queryGoodsBygoodsId(goodsId);
	}

	@RequestMapping(path="/delegoods",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleGoods (Integer goodsId) {
		return cardService.deleteBygoodsId(goodsId);
	}
	@RequestMapping(path="/deleAllgoods",method= {RequestMethod.GET,RequestMethod.POST})
	public Boolean deleAllGoods (Integer[] id) {
		boolean rt=false;
		for(Integer goodsId:id) {
			rt=cardService.deleteBygoodsId(goodsId);
		}
		return rt;
	}
	@RequestMapping(path="/querygoodsName",method= {RequestMethod.GET,RequestMethod.POST})
	public List<Goods> queryGoods (String goodsName) {
		return cardService.selectByGoodsName(goodsName);
	}
	@RequestMapping(path="/savegoods",method = {RequestMethod.GET,RequestMethod.POST})
	public boolean updateGoods( Goods goods,MultipartFile file) {
		boolean rt=false;
		if(file!=null) {
			try {
				MinioClient minioClient = new MinioClient("http://localhost:9000", "minioadmin", "minioadmin"); // 连接
				if (!minioClient.bucketExists("goods")) { // 是否存在名为“test”的bucket
					minioClient.makeBucket("goods");
				}
				String fileName = file.getOriginalFilename();
				String newName = UUID.randomUUID().toString().replaceAll("-", "")+fileName.substring(fileName.lastIndexOf("."));
				InputStream inputStream = file.getInputStream(); // 获取file的inputStream
				//image/png
				minioClient.putObject("goods", newName, inputStream,"image/png"); // 上传
				//minioClient.putObject("goods", newName, inputStream, "application/octet-stream"); // 上传
				inputStream.close();
				String url = minioClient.getObjectUrl("goods", newName); // 文件访问路径
				goods.setGoodsImage(url);
				rt= cardService.updateGoods(goods);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			rt=cardService.updateGoods(goods);
		}
		
		return rt;
	}
	
	
	@RequestMapping(path="/addgoods",method = {RequestMethod.GET,RequestMethod.POST})
	public boolean addGoods( Goods goods,MultipartFile file) {
		if (file.isEmpty() || file.getSize() == 0) {
			return false;
		}
		try {
			MinioClient minioClient = new MinioClient("http://localhost:9000", "minioadmin", "minioadmin"); // 连接
			if (!minioClient.bucketExists("goods")) { // 是否存在名为“test”的bucket
				minioClient.makeBucket("goods");
			}
			String fileName = file.getOriginalFilename();
			String newName = UUID.randomUUID().toString().replaceAll("-", "")+fileName.substring(fileName.lastIndexOf("."));
			InputStream inputStream = file.getInputStream(); // 获取file的inputStream
			//image/png
			minioClient.putObject("goods", newName, inputStream,"image/png"); // 上传
			//minioClient.putObject("goods", newName, inputStream, "application/octet-stream"); // 上传
			inputStream.close();
			String url = minioClient.getObjectUrl("goods", newName); // 文件访问路径
			goods.setGoodsImage(url);
			return cardService.addGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cardService.addGoods(goods);
	}
}
