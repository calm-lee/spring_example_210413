package com.calmlee.ex.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp를 내려줄 때는 ResponseBody가 사용되지 않는다
public class Ex02Controller {

	// 요청 url - http://localhost/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02_1() {
		// ResponseBody가 아닌 상태로 String을 리턴하면
		// ViewResolver을 사용해서 리턴된 String 이름의 view를 찾고 view 화면이 구성된다.
		
		// 경로: /WEB-INF/jsp/lesson01/ex02.jsp
		return "lesson01/ex02"; // jsp view 이름 (prefix, suffix 제외된)
	}
	
}
