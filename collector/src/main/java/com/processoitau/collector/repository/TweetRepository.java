package com.processoitau.collector.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.processoitau.collector.model.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, Long> {
	
}
