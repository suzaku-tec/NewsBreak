package rss;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RssUtil {

	public static SyndFeed getFeed(String url) throws IllegalArgumentException, MalformedURLException, FeedException, IOException {
		return new SyndFeedInput().build(new XmlReader(new URL(url)));

	}
}
