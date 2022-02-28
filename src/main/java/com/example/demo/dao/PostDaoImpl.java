package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GenreType;
import com.example.demo.entity.Post;

@Repository
public class PostDaoImpl implements PostDao {
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PostDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Post> findAll() {
		
		String sql = "SELECT post.id, post.user_id ,music_name, artist_name, genre_id, caption, post.created, genreType.id, genreType.genre FROM post INNER JOIN genreType ON post.genre_id = genreType.id";

		List<Map<String,Object>> resultList = jdbcTemplate.queryForList(sql);
		
		List<Post> list = new ArrayList<Post>();
		
		for(Map<String,Object> result : resultList) {
			Post post = new Post();
			post.setId((int)result.get("id"));
			post.setUserId((int)result.get("user_id"));
			post.setMusic_name((String)result.get("music_name"));
			post.setArtist_name((String)result.get("artist_name"));
			post.setGenreId((int)result.get("genre_id"));
			post.setCaption((String)result.get("caption"));
			post.setCreated((((Timestamp)result.get("created")).toLocalDateTime()).toLocalDate());
			
			GenreType genreType = new GenreType();
			genreType.setId((int)result.get("genre_id"));
			genreType.setGenre((String)result.get("genre"));
			
			post.setGenreType(genreType);
			list.add(post);
		}
		return list;
    }

	@Override
	public Optional<Post> findById(int id) {
		String sql = "SELECT post.id,user_id,music_name,artist_name,genre_id,created,genreType.id,genreType.genre FROM post INNER JOIN genreType ON post.genre_id = genreType.id WHERE post.id = ?";

		
		Map<String,Object> result = jdbcTemplate.queryForMap(sql, id);
		
		Post post = new Post();
		post.setId((int)result.get("id"));
		post.setMusic_name((String)result.get("music_name"));
		post.setArtist_name((String)result.get("artist_name"));
		post.setGenreId((int)result.get("genre_id"));
		post.setCaption((String)result.get("caption"));
		post.setCreated((((Timestamp)result.get("created")).toLocalDateTime()).toLocalDate());
		
		
		GenreType genreType = new GenreType();
		genreType.setId((int)result.get("genre_id"));
		genreType.setGenre((String)result.get("genre"));
		
		post.setGenreType(genreType);
		
		Optional<Post> postOpt = Optional.ofNullable(post);
		
		return postOpt;
	}

	@Override
	public void insert(Post post) {
		jdbcTemplate.update("INSERT INTO post(user_id, music_name,artist_name,genre_id,caption,created)\n"
				+ "VALUES(?,?,?,?,?,?)",post.getUserId(),post.getMusic_name(), post.getArtist_name(), post.getGenreId(), post.getCaption(),post.getCreated());
		
	}

	@Override
	public int update(Post post) {
		
		return jdbcTemplate.update("UPDATE post SET music_name = ?,artist_name=?,genre_id = ?, caption = ?, created = ? WHERE id = ?",
				post.getMusic_name(), post.getArtist_name(), post.getGenreId(), post.getCaption(),post.getCreated(),post.getId());
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM post WHERE id = ?",id);
	}

}
