package controller;

import org.apache.mina.http.api.HttpMethod;
import org.apache.mina.http.api.HttpRequest;

import com.alibaba.fastjson.JSONObject;
import com.fenglinga.tinyspring.framework.Controller;
import com.fenglinga.tinyspring.framework.annotation.Comment;
import com.fenglinga.tinyspring.framework.annotation.RequestMapping;
import com.fenglinga.tinyspring.framework.annotation.RestController;

@RestController
public class HelloWordRestController extends Controller {
	@Comment(content="演示")
	@RequestMapping(value = "/hello_world", method = {HttpMethod.GET, HttpMethod.POST})
	public JSONObject hello_world(
			HttpRequest request
	) throws Exception {
		return new JSONObject();
	}
}
