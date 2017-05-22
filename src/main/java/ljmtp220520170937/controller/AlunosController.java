package ljmtp220520170937.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlunosController {
	@RequestMapping(path = "/datatable/alunos", method = RequestMethod.GET)
	public String goHome() {
		return "alunos";
	}
}
