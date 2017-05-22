package ljmtp220520170937.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CursosController {
	@RequestMapping(path = "/datatable/cursos", method = RequestMethod.GET)
	public String goHome() {
		return "cursos";
	}
}
