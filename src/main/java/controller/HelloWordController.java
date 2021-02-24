package controller;

import org.apache.mina.http.api.HttpMethod;
import org.apache.velocity.VelocityContext;

import com.fenglinga.tinyspring.framework.Controller;
import com.fenglinga.tinyspring.framework.annotation.RequestMapping;
import com.fenglinga.tinyspring.mysql.BaseObject;

@com.fenglinga.tinyspring.framework.annotation.Controller
public class HelloWordController extends Controller {	
	@RequestMapping(value = "/hello_world.html", method = HttpMethod.GET)
	public String hello_world(VelocityContext model) throws Exception {
		model.put("Timestamp", BaseObject.date());
		return "hello_world.html";
	}
}
