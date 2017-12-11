package com.spring.twitter.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.twitter.dao.TweetDAO;
import com.spring.twitter.entity.Tweet;

@Path("/tweet")
public class TweetService {

	private TweetDAO tweetDAO;

	private final ApplicationContext context = new ClassPathXmlApplicationContext("twitter-config.xml");

	@GET
	@Path("/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Tweet> getTweet(@PathParam("userid") int userid) {
		tweetDAO = (TweetDAO) context.getBean("tweetDAO");
		return tweetDAO.getAllTweets(userid);
	}

	/**
	 * Retrieve the feed for a given user. Get the list of contacts whom the
	 * user is following and retrieve their tweets.
	 */
	@GET
	@Path("/{userid}/feed")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Tweet> getFeed(@PathParam("userid") int userid) {
		tweetDAO = (TweetDAO) context.getBean("tweetDAO");
		return tweetDAO.getTweetsFromFollowing(userid);
	}
}
