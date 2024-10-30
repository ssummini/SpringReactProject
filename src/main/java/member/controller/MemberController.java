package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.bean.MemberDTO;
import member.service.MemberService;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;
		
	//@RequestMapping(value="login", method = RequestMethod.GET)
	@GetMapping(value = "login")
	@ResponseBody
	public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		return memberService.login(id, pwd);
		
	}
}
