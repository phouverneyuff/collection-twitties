package com.processoitau.collector.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.social.twitter.api.Entities;
import org.springframework.social.twitter.api.TwitterObject;
import org.springframework.social.twitter.api.TwitterProfile;

public class Tweet extends TwitterObject implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String idStr;
	private String text;
	private Date createdAt;
	private String fromUser;
	private long fromUserId;
	private String languageCode;
	private TwitterProfile user;
	
	public Tweet() {
		
	}

	public void setId(long id) {
		this.id = id;
	}




	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	/**
	 * The text of the tweet. If this tweet is a retweet of another tweet, the text may be preceeded with "RT \@someuser" and may be truncated at the end.
	 * To get the raw, unmodified text of the original tweet, use {@link #getUnmodifiedText()}. 
	 * @return The text of the tweet.
	 */
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public long getId() {
		return id;
	}

	public String getIdStr() {
		return idStr;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public TwitterProfile getUser() {
		return this.user;
	}
	
	public void setUser(final TwitterProfile prof) {
		this.user = prof;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Tweet tweet = (Tweet) o;

		if (fromUserId != tweet.fromUserId) {
			return false;
		}
		if (id != tweet.id) {
			return false;
		}
		if (idStr != null ? !idStr.equals(tweet.idStr) : tweet.idStr != null) {
			return false;
		}
		if (createdAt != null ? !createdAt.equals(tweet.createdAt) : tweet.createdAt != null) {
			return false;
		}
		if (fromUser != null ? !fromUser.equals(tweet.fromUser) : tweet.fromUser != null) {
			return false;
		}
		if (languageCode != null ? !languageCode.equals(tweet.languageCode) : tweet.languageCode != null) {
			return false;
		}
		if (text != null ? !text.equals(tweet.text) : tweet.text != null) {
			return false;
		}
		if (user != null ? !user.equals(tweet.user) : tweet.user != null) {
			return false;
		}
	
		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (idStr != null ? idStr.hashCode() : 0);
		result = 31 * result + (text != null ? text.hashCode() : 0);
		result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
		result = 31 * result + (fromUser != null ? fromUser.hashCode() : 0);
		result = 31 * result + (int) (fromUserId ^ (fromUserId >>> 32));
		result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
		result = 31 * result + (user != null ? user.hashCode() : 0);
		return result;
	}
	
}
