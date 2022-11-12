package com.example.quotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.quotes.entities.Quote;
import com.example.quotes.services.QuoteService;

@Controller
public class QuoteController {
	
	private final QuoteService quoteService;
	
	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	@GetMapping(path = "/")
	public String getQuote(Model model) {
		Quote quote = quoteService.getDailyQuote();
		model.addAttribute("quote", quote);
		return "index";
	}
	
}
