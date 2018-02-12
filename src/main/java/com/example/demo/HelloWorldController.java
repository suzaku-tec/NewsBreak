package com.example.demo;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import rss.RssUtil;

@RestController
public class HelloWorldController {
	@RequestMapping(name = "/")
	public String helloWorld() {
		try {
			SyndFeed feed = RssUtil.getFeed("https://stackoverflow.com/feeds/tag?tagnames=rome");
			feed.getEntries().stream().map(entry -> entry.getTitle()).forEach(System.out::println);
		} catch (IllegalArgumentException | FeedException | IOException e) {
			e.printStackTrace();
		}

		return "Hello world";
	}
}