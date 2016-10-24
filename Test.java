package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.dao.ProductDAOImpl;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.CategoryDAOImpl;
import com.niit.shoppingcart.dao.UserDAOImpl;



@Controller
public class Test {

	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
		

	@Autowired
	User user;
	
	@RequestMapping("/account")
	public ModelAndView toAccount()
	{
		return new ModelAndView("account");
	}
	@RequestMapping("/index")
	public ModelAndView toIndex()
	{
		return new ModelAndView("index");
	}
	
	 
	@RequestMapping("/checkout")
	public ModelAndView toCheckout()
	{
		return new ModelAndView("checkout");
	}
	
	@RequestMapping("/contact")
	public ModelAndView toContact()
	{
		return new ModelAndView("contact");
	}
	
	@RequestMapping("/men")
	public ModelAndView toMen()
	{
		return new ModelAndView("men");
	}
	
	
	@RequestMapping("/register")
	public ModelAndView toRegister()
	{
		return new ModelAndView("register");
	}
	
	@RequestMapping("/product")
	public ModelAndView toProduct()
	{
		return new ModelAndView("product");
	}
	
	@RequestMapping("/single")
	public ModelAndView toSingle()
	{
		return new ModelAndView("single");
	}
	
	@RequestMapping("/women")
	public ModelAndView toWomen()
	{
		return new ModelAndView("women");
	}
	
	@RequestMapping("/adminHome")
	public ModelAndView toAdminHome()
	{
		return new ModelAndView("adminHome");
	}

	

@RequestMapping("/kill")
public ModelAndView toButton(){
return new ModelAndView("button");
}
@RequestMapping("/hat")
public ModelAndView toAdd(){
return new ModelAndView("add");
}

	 @RequestMapping(value="/IsValidUser")
	 public ModelAndView executeLogin(@RequestParam("email") String email,@RequestParam("password") String pwd){
		 System.out.println("in controller");
			
		 ModelAndView mv;
		 if(email.equals("aaa@gmail.com"))
		 {
			 mv=new ModelAndView("women");
		 }
			 else {
				 mv=new ModelAndView("index");
				 
			}
		 
	 return mv;
	 }

	 

@RequestMapping (value="/savenewcategory")
	 public ModelAndView newcat (@RequestParam("id") String id,@RequestParam("name") String name){
		 Category cat=new Category();
		 cat.setId(id);
		 cat.setName(name);
		 categoryDAO.saveOrUpdate(cat);
		 
		 ModelAndView mv;
		 return new ModelAndView("Cat");
		 
		 
	 }
 
	 
@RequestMapping("/allCat")
public ModelAndView toCat()
{
return new ModelAndView("Cat");
}

@RequestMapping (value="/savenewcategory")
public ModelAndView newuser (@RequestParam("id") String id,@RequestParam("name") String name){
	 User User=new User();
	 User.setId(id);
	 
	 
	 ModelAndView mv;
	 return new ModelAndView("User");
	 
	 
}
@RequestMapping("/allUser")
public ModelAndView touser()
{
return new ModelAndView("User");
}

@RequestMapping("/allProd")
public ModelAndView toProducts()
{
return new ModelAndView("Products");
}


@RequestMapping("/dispProd")
public @ResponseBody String dispProd()
{
List<Product> listProd=productDAO.list();

Gson g=new Gson();
String prod=g.toJson(listProd);


return prod;
}




@RequestMapping("/dispUser")
public @ResponseBody String dispUser()
{
List<User> listUser=userDAO.list();

Gson g=new Gson();
String user=g.toJson(listUser);

for(User u:listUser){
	
	System.out.println(u.getId());
	System.out.println(u.getUsername1());
	System.out.println(u.getUtype());
	System.out.println(" next ");
}

return user;
}







@RequestMapping("/dispCat")
public @ResponseBody String dispCategory()
{
List<Category> listCategory=categoryDAO.list();

Gson g=new Gson();
String Cat=g.toJson(listCategory);

for(Category u:listCategory){
	
	System.out.println(u.getId());
	System.out.println(u.getName());
	
	System.out.println(" next ");
}

return Cat;
}

}


	

