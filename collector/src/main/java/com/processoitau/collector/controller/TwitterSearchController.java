package com.processoitau.collector.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.processoitau.collector.converter.TweetConverter;
import com.processoitau.collector.model.Tweet;
import com.processoitau.collector.repository.TweetRepository;

/**
 * TwitterSearchController
 */
@RestController
public class TwitterSearchController {

    private final Twitter twitter;
	private final TweetRepository repository;

    @Inject
    public TwitterSearchController(Twitter twitter, TweetRepository repository) {
        this.twitter = twitter;
        this.repository = repository;
    }

    @RequestMapping("/twitter/tag")
    public List<Tweet> listByTag(@RequestParam(value = "tag", defaultValue = "java") String tag) {
        List<Tweet> tweeties = TweetConverter.toList(twitter.searchOperations().search(tag).getTweets());
        
        repository.save(tweeties);
        
        return tweeties;
    }
    
    @RequestMapping("/twitter/tag/all")
    public List<Tweet> listAll() {
    	List<Tweet> tweeties = repository.findAll();
        
        return tweeties;
    }

}