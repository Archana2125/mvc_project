package com.nt.controller;

import java.io.ByteArrayInputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.Dao.ProductDao;
import com.nt.Dto.GetProductDto;
import com.nt.Entity.Products;
import com.nt.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductDao dao;
	
	/************************ Userdashboard Page ***********************/
	@RequestMapping("/userDashborad")
	public String showUserDashbordPage(Model model) {
		 List<Products> products = (List<Products>) userService.getAllProducts();
		 List<GetProductDto> dtos=new ArrayList<>();
		 
		 for (Products p : products) {
		        GetProductDto dto = new GetProductDto();
		        dto.setId(p.getProduct_id());
		        dto.setName(p.getProduct_name());
		        dto.setPrice(p.getPrice());

		        if (p.getImage() != null) {
		            try {
		                byte[] imageBytes = p.getImage();
		                String base64 = Base64.getEncoder().encodeToString(imageBytes);
		                String mimeType = URLConnection.guessContentTypeFromStream( new ByteArrayInputStream(imageBytes));
		                if (mimeType == null) mimeType = "image/jpeg";
		                dto.setBase64Image("data:" + mimeType + ";base64," + base64);
		            } catch (Exception e) {
		                e.printStackTrace();
		                dto.setBase64Image(null);
		            }
		        }

		        dtos.add(dto); // <-- add DTO to list
		    }

	        model.addAttribute("products", dtos);
		return "user-Dashboard";
	}
	
	
	/************************ viewproduct ***********************/
	@RequestMapping("/getAllProduct")
	public String showProductsBycat(Model model )
	{
		 List<Products> products =(List<Products>) userService.getAllProducts();
		 
		 List<GetProductDto> dtos=new ArrayList();
		 for(Products p:products)
		 {
			 GetProductDto productDto=new GetProductDto();
			productDto.setId(p.getProduct_id());
			productDto.setName(p.getProduct_name());
			productDto.setPrice(p.getPrice());
			
			
			if(p.getImage() !=null)
			{
				try {
				byte[] imageBytes=p.getImage();
				String base64=Base64.getEncoder().encodeToString(p.getImage());
				
				String mimetype;
				
					mimetype=URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageBytes));
					if(mimetype==null)
					{
						mimetype="image/jpeg";
					}
					String imageSrc="data:"+mimetype+";base64,"+base64;
					
					productDto.setBase64Image(imageSrc);			
					}catch (Exception e) {
						e.printStackTrace();
						productDto.setBase64Image(null);
					}
				}
			
			 dtos.add(productDto);
		 }
		model.addAttribute("products", dtos);
		return"userViewProduct";
	}



}
