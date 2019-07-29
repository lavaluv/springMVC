package springMVC.messageConverter;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import springMVC.domain.MyObject;

public class DemoConverter extends AbstractHttpMessageConverter<MyObject>{
	public DemoConverter() {
		super(new MediaType("application", "x-wisely",Charset.forName("UTF-8")));
	}
	
	@Override
	protected MyObject readInternal(Class<? extends MyObject> class1,
			HttpInputMessage message)throws IOException{
		String temp = StreamUtils.copyToString(message.getBody(),Charset.forName("UTF-8"));
		String[] tempArr = temp.split("-");
		System.out.println("get "+temp);
		return new MyObject(new Long(tempArr[0]),tempArr[1]);
	}
	
	@Override
	protected boolean supports(Class<?> class1) {
		return MyObject.class.isAssignableFrom(class1);
	}
	
	@Override
	protected void writeInternal(MyObject object, HttpOutputMessage message)throws IOException,HttpMessageNotWritableException{
		String outString = "hello" + object.getId() + "-" + object.getName();
		System.out.println("put " + outString);
		message.getBody().write(outString.getBytes());
	}
}
