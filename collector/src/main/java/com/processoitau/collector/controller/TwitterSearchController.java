package com.processoitau.collector.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TwitterSearchController
 */
@RestController
public class TwitterSearchController {

    private final Twitter twitter;

    @Inject
    public TwitterSearchController(Twitter twitter) {
        this.twitter = twitter;
    }

    @RequestMapping("/twitter/tag")
    public List<Tweet> greeting(@RequestParam(value = "tag", defaultValue = "java") String tag) {
        return twitter.searchOperations().search(tag).getTweets();
    }

}