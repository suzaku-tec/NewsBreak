package com.example.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import dao.Feed;
import jp.sf.amateras.mirage.SqlManager;
import jp.sf.amateras.mirage.session.Session;
import jp.sf.amateras.mirage.session.SessionFactory;
import rss.RssUtil;

@RestController
public class HelloWorldController {
	@RequestMapping(name = "/")
	public String helloWorld() {
		try {
			SyndFeed feed = RssUtil.getFeed("https://stackoverflow.com/feeds/tag?tagnames=rome");
			feed.getEntries().stream().map(entry -> entry.getTitle()).forEach(System.out::println);

			Session session = SessionFactory.getSession();
			SqlManager sqlManager = session.getSqlManager();
			session.begin();
			feed.getEntries().stream().map(HelloWorldController::convertFeed).forEach(value -> sqlManager.insertEntity(value));
			session.commit();
		} catch (IllegalArgumentException | FeedException | IOException e) {
			e.printStackTrace();
		}

		return "Hello world";
	}

	private static Feed convertFeed(SyndEntry entry) {
		LocalDateTime ldt = LocalDateTime.ofInstant(entry.getPublishedDate().toInstant(), ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

		Feed feed = new Feed();
		feed.setTitle(entry.getTitle());
		feed.setLink(entry.getLink());
		feed.setPublishedDate(formatter.format(ldt));
		feed.setDescription(entry.getDescription().getValue());

		return feed;
	}
}