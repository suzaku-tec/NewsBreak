package dao;

import java.io.Serializable;

import jp.sf.amateras.mirage.annotation.Column;
import jp.sf.amateras.mirage.annotation.Table;

@Table(name = "feed")
public class Feed implements Serializable {

	@Column(name="title")
	private String title;

	@Column(name="link")
	private String link;

	@Column(name="description")
	private String description;

	@Column(name="publishedDate")
	private String publishedDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
}
