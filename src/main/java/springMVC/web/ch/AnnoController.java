package springMVC.web.ch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springMVC.domain.MyObject;

@Controller
@RequestMapping("/anno")
public class AnnoController {
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURI() + " can access";
	}
	@RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String pathVar(@PathVariable String str,HttpServletRequest request) {
		return "url:" + request.getRequestURI() + " can access,str: " + str;
	}
	@RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id,HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access,id: "+id;
	}
	@RequestMapping(value = "obj",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String passMyObject(MyObject object,HttpServletRequest request) {
		return "url: " + request.getRequestURI() + " can access, obj id: " + object.getId()+ " obj name: "+object.getName();
	}
	@RequestMapping(value = { "/name1","/name2" },produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {
		return "url:" + request.getRequestURI() + " can access";
	}
}
