package com.example.quotes.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.quotes.entities.Quote;

@Service
public class QuoteService {

	@Value("${dailyQuoteAPIPath}")
	private String path;

	@Cacheable("quote")
	// Magic number 0 is because the response is an Array with one element only
	public Quote getDailyQuote() {
		RestTemplate restTemplate = new RestTemplate();
		Quote[] response = restTemplate.getForObject(this.path, Quote[].class);
		return response[0];
	}

	// Every day at midnight (00:00 CST) cache will be cleared so we can get a new quote
	@Scheduled(cron = "@midnight", zone = "GMT-6:00")
	@CacheEvict(value = "quote", allEntries = true)
	public void evictQuote() { }

}
