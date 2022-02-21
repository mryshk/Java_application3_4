package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Post;
import com.example.demo.entity.PostComment;

@Repository
public class PostDaoImpl implements PostDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	public PostDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Post> findAll() {
		
		String sql = "SELECT post.id,user_id,music_name,artist_name,genre,caption,post.created,comment, postComment.created," 
				+ "FROM post INNER JOIN postComment ON post.id = postComment.post_id";
		List<Map<String,Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<Post> list = new ArrayList<Post>();
		
		for(Map<String,Object> result : resultList) {
			Post post = new Post();
			post.setId((int)result.get("id"));
			post.setMusic_name((String)result.get("artist_name"));
			post.setArtist_name((String)result.get("artist_name"));
			post.setGenre((int)result.get("genre"));
			post.setCaption((String)result.get("caption"));
			post.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			
			PostComment postComment = new PostComment();
			postComment.setComment((String)result.get("comment"));
			postComment.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			
			post.setPostComment(postComment);
			list.add(post);
		}
		return list;
    }

	@Override
	public Optional<Post> findById(int id) {
		String sql = "SELECT\n"
				+ "  id,\n"
				+ "  user_id,\n"
				+ "  music_name,\n"
				+ "  artist_name,\n"
				+ "  genre,\n"
				+ "  post.created,\n"
				+ "  comment,\n"
				+ "  postComment.created\n"
				+ "FROM\n"
				+ "  post\n"
				+ "INNER JOIN postComment ON post.id = postComment.post_id\n"
				+ "WHERE post.id = ?";
		
		Map<String,Object> result = jdbcTemplate.queryForMap(sql);
		
		Post post = new Post();
		post.setId((int)result.get("id"));
		post.setMusic_name((String)result.get("artist_name"));
		post.setArtist_name((String)result.get("artist_name"));
		post.setGenre((int)result.get("genre"));
		post.setCaption((String)result.get("caption"));
		post.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
		
		PostComment postComment = new PostComment();
		postComment.setComment((String)result.get("comment"));
		postComment.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
		post.setPostComment(postComment);
		
		Optional<Post> postOpt = Optional.ofNullable(post);
		
		return postOpt;
	}

	@Override
	public void insert(Post post) {
		jdbcTemplate.update("INSERT INTO post(music_name,artist_name,genre,caption,created)\n"
				+ "VALUES(?,?,?,?,?)",post.getMusic_name(), post.getArtist_name(), post.getGenre(), post.getCaption(),post.getCreated());
		
	}

	@Override
	public int update(Post post) {
		
		return jdbcTemplate.update("UPDATE post SET music_name = ?,artist_name=?,genre = ?, caption = ?, created = ? WHERE id = ?",
				post.getMusic_name(), post.getArtist_name(), post.getGenre(), post.getCaption(),post.getCreated(),post.getId());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM post WHERE id = ?",id);
	}

}