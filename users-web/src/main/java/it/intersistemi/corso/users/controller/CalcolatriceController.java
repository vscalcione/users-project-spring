package it.intersistemi.corso.users.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalcolatriceController {


	@RequestMapping
	public String form() {
		return "calcolatrice";
	}

//	@RequestMapping("/somma")
	@RequestMapping(params="somma")
	public String somma(
			@RequestParam(name="op1", required=true) int op1,
			@RequestParam(name="op2", required=true) int op2,
			Model model
			) {
		int risultato = op1 + op2;
		model.addAttribute("operazione", "Somma");
		model.addAttribute("risultato", risultato);
		return "calcolatrice";
	}

//	@RequestMapping("/sottrai")
	@RequestMapping(params="sottrai")
	public String sottrai(
			@RequestParam(name="op1", required=true) int op1,
			@RequestParam(name="op2", required=true) int op2,
			Model model
			) {
		int risultato = op1 - op2;
		model.addAttribute("operazione", "Differenza");
		model.addAttribute("risultato", risultato);
		return "calcolatrice";
	}

//	@RequestMapping("/moltiplica")
	@RequestMapping(params="moltiplica")
	public String moltiplica(
			@RequestParam(name="op1", required=true) int op1,
			@RequestParam(name="op2", required=true) int op2,
			Model model
			) {
		int risultato = op1 * op2;
		model.addAttribute("operazione", "Moltiplicazione");
		model.addAttribute("risultato", risultato);
		return "calcolatrice";
	}

//	@RequestMapping("/dividi")
	@RequestMapping(params="dividi")
	public String dividi(
			@RequestParam(name="op1", required=true) int op1,
			@RequestParam(name="op2", required=true) int op2,
			Model model
			) {
		int risultato = op1 / op2;
		model.addAttribute("operazione", "Divisione");
		model.addAttribute("risultato", risultato);
		return "calcolatrice";
	}

}
