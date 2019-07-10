package br.com.sada.twgerenciadortarefas.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
//@RequestMapping("/")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	//@GetMapping("/")
	public String home() {
		return "home/home";
	}

}
