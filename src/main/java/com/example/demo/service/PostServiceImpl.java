package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PostDao;
import com.example.demo.entity.Post;

@Service
public class PostServiceImpl implements PostService {
	
	private final PostDao dao;
	
	public PostServiceImpl(PostDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Post> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Post> getPost(int id) {
		try {
			return dao.findById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new PostNotFoundException("指定された投稿はありません。");
		}
		
	}

	@Override
	public void insert(Post post) {
		dao.insert(post);
		
	}

	@Override
	public void update(Post post) {
		if(dao.update(post) == 0) {
			throw new PostNotFoundException("指定された投稿はありません。");
		}
		
	}

	@Override
	public void deleteById(int id) {
		if (dao.deleteById(id) == 0) {
			throw new PostNotFoundException("指定された投稿はありません");
		}
		
	}

}
