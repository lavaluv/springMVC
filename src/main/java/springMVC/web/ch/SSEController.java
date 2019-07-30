package springMVC.web.ch;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SSEController {
	@RequestMapping(value = "/push",produces = "text/event-stream")
	public @ResponseBody String push() {
		Random random = new Random();
		try {
			//每五秒推送一次消息
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "data:Testing 1,2,3"+ random.nextInt() + "\n\n";
	}
}
