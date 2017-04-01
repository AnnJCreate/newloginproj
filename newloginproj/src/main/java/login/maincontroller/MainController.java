package login.maincontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import login.user.User;
import login.user.UserDao;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class MainController {
	
	private UserDao userDao;
	
	@Autowired
	public MainController(UserDao userDao){
		this.userDao = userDao;
	}
	@RequestMapping("/")
	public String showHomePage(){
		return "home";
	}
	@RequestMapping("/index")
    public String home(Model model) {
        return "home";
    }
	@RequestMapping("/hello")
	@ResponseBody
	 String home() {
	        return "Hello World!";
	 	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(Model model){
		User user=new User();
		model.addAttribute("user",user);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user){
		
			
			boolean bl =userDao.findUserByUserBean(user);
			if(bl==true){				
					return "redirect:/result/login/successful";				
			}
		
		return "redirect:/result/login/failed";
	}

}
