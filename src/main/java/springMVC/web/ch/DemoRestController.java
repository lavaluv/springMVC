package springMVC.web.ch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springMVC.domain.MyObject;

@RestController
@RequestMapping("/rest")
public class DemoRestController {
	@RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})
	public MyObject getJson (MyObject object) {
		return new MyObject(object.getId()+1, object.getName() + "yy");
	}
	@RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})
	public MyObject getxml(MyObject object) {
		return new MyObject(object.getId() + 1,object.getName());
	}
}
