package com.calmlee.ex.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calmlee.ex.lesson04.bo.NewUserBO;
import com.calmlee.ex.lesson04.model.NewUser;

@RequestMapping("/lesson04/ex01")
@Controller
public class NewUserController {
	
	
	@Autowired
	private NewUserBO newUserBO;
	
	// http://localhost/lesson04/ex01/1
	
	@RequestMapping(path = "/user", method = RequestMethod.GET)	
	public String addUserView() {
		return "lesson04/addUser"; // view 경로
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("birth") String birth,
			@RequestParam(value="introduce", required=false) String introduce, //비필수
			@RequestParam(value="email", required=false) String email //비필수
			) {
		
		// request -> response
		
		// DB insert
//		newUserBO.insertNewUser(name, birth, introduce, email);
		
		// 결과 jsp
		return "lesson04/afterAddUser";
	}
	
	/**
	 * 가장 최근에 추가된 사람 한 명 가져오기 
	 * @return
	 */
	// http://localhost/
	@GetMapping("/get_last_user")
	public String getLastUserView(Model model) {// view 화면에 data를 넘겨주는 객체 (참고: ModelAndView 객체는 요즘 잘 사용하진 않음)
		
		NewUser newUser = newUserBO.getLastUser();
		
		model.addAttribute("result", newUser); // 결과 jsp 뷰에 결과 객체값을 넘겨줌 
		model.addAttribute("subject", "회원 정보");
		
		return "lesson04/getLastUser";
	}
	
	
	@RequestMapping("/get_user")
	public String getUser(Model model) {
		
		NewUser newUser = newUserBO.getLastUser();
		
		model.addAttribute("newUser", newUser);
		
		return "lesson06/getNewUser";

	}
}