package com.louis.mango.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.louis.mango.common.utils.IOUtils;

@RestController
public class SysLoginController {
	@Autowired
	private Producer procucer;

	@GetMapping("captcha.jg")
	public void captcha(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setHeader("Cache-Control", "no-store,no-cahce");
		response.setContentType("image/jpeg");
		//生成文字验证码
		String textString = procucer.createText();
		//生成图片验证码
		BufferedImage image = procucer.createImage(textString);
		//保存图片到session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, textString);
		ServletOutputStream outputStream = response.getOutputStream();
		
		ImageIO.write(image, "jpg", outputStream);
		
		IOUtils.closeQuietly(outputStream);
	}
}
