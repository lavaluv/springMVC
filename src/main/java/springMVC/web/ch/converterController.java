package springMVC.web.ch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springMVC.domain.MyObject;

@Controller
public class converterController {
	@RequestMapping(value = "/convert",produces = { "application/x-wisely" })
	public @ResponseBody MyObject convert(@RequestBody MyObject object) {
		System.out.println("get request");
		return object;
	}
}
