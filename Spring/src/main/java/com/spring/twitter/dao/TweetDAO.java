package com.spring.twitter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.spring.twitter.entity.Tweet;

public class TweetDAO {

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterTemplate;

	// Retrieve all tweets using ResultSetExtractor
	public List<Tweet> getTweets() {
		String query = "select * from tweet";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Tweet>>() {
			@Override
			public List<Tweet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Tweet> tweets = new ArrayList<Tweet>();
				while (rs.next()) {
					Tweet tweet = new Tweet();
					tweet.setId(rs.getLong("id"));
					tweet.setUserid(rs.getInt("userid"));
					tweet.setParentid(rs.getLong("parentid"));
					tweet.setMessage(rs.getString("message"));
					tweets.add(tweet);
				}
				return tweets;
			}
		});
	}

	/**
	 * Retrieve tweets posted by a given user
	 * @param userid
	 * @return
	 */
	public List<Tweet> getAllTweets(int userid) {
		String query = "select * from tweet where userid=" + userid;
		return getTweets(query);
	}

	public List<Tweet> getTweetsFromFollowing(int userid) {
		String query = "select * from tweet where userid in "
							+ "(select followerid as userid from followers where userid=" + userid + ")";
		return getTweets(query);
	}

	/**
	 * Retrieve tweets from DB based on the given query
	 * 
	 * @param query
	 * @return
	 */
	public List<Tweet> getTweets(String query) {
		return jdbcTemplate.query(query, new RowMapper<Tweet>() {
			@Override
			public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tweet tweet = new Tweet();
				tweet.setId(rs.getLong("id"));
				tweet.setUserid(rs.getInt("userid"));
				tweet.setParentid(rs.getLong("parentid"));
				tweet.setMessage(rs.getString("message"));
				return tweet;
			}
		});
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterTemplate() {
		return namedParameterTemplate;
	}

	public void setNamedParameterTemplate(NamedParameterJdbcTemplate namedParameterTemplate) {
		this.namedParameterTemplate = namedParameterTemplate;
	}
}
