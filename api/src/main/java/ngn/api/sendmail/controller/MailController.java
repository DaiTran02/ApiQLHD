package ngn.api.sendmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ngn.api.hopdong.services.SendingMailService;

@RestController
@ResponseBody
public class MailController {
	
	@Autowired
	private SendingMailService sendingMailService;
	
	@GetMapping("/send")
	public String sendMail() {
		sendingMailService.sendMail("tranphudai1020@gmail.com", "test", "test");
		return "Succes";
	}

}
