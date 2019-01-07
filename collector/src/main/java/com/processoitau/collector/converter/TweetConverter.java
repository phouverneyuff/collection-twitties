package com.processoitau.collector.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.processoitau.collector.model.Tweet;

public class TweetConverter {
	
	//for lists
	private static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
	    return from.stream().map(func).collect(Collectors.toList());
	}
	
	public static Tweet toTweet(org.springframework.social.twitter.api.Tweet original) {
		Tweet tweet = new Tweet();
		
		tweet.setId(original.getId());
		tweet.setIdStr(original.getIdStr());
		tweet.setText(original.getText());
		tweet.setCreatedAt(original.getCreatedAt());
		tweet.setFromUser(original.getFromUser());
		tweet.setFromUserId(original.getFromUserId());
		tweet.setLanguageCode(original.getLanguageCode());
		tweet.setUser(original.getUser());
		
		return tweet;
	}
	
	public static List<Tweet> toList(List<org.springframework.social.twitter.api.Tweet> originals){
		return TweetConverter.convertList(originals, t -> TweetConverter.toTweet(t));
	}

}
