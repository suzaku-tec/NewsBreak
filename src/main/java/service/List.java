package service;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;

import rss.RssUtil;

@RestController
public class List {

	@RequestMapping(name="/list")
	public String list() {


		try {
			SyndFeed feed = RssUtil.getFeed("https://stackoverflow.com/feeds/tag?tagnames=rome");
			return feed.getTitle();
		} catch (IllegalArgumentException | FeedException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}
}
