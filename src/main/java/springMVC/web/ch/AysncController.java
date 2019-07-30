package springMVC.web.ch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import springMVC.service.PushService;

@Controller
public class AysncController {
	@Autowired
	PushService pushService;
	@RequestMapping(value = "/defer")
	public @ResponseBody DeferredResult<String> deferredResult(){
		return pushService.getAysncResult();
	}
}
