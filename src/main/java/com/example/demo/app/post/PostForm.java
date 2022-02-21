package com.example.demo.app.post;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.PostComment;


public class PostForm {
	
	@NotNull (message = "楽曲名を入力してください。")
	@Size(min=1, max=100, message="1文字以上100文字以上の記入が必要です。")
	private String music_name;
	
	@NotNull (message = "アーティスト名を入力してください。")
	@Size(min=1,max=100, message="1文字以上100文字以上の記入が必要です。")
	private String artist_name;
	
	private PostComment postComment;
	
	@NotNull (message = "ジャンルを入力してください。")
	@Digits(integer=1, fraction=0)
	private int genre;
	
	@NotNull (message = "説明文を入力してください。")
	@Size(min=1, max=200,message="1文字以上200文字以上の記入が必要です。")
	private String caption;
	
//	
//	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
//	private LocalDateTime created;
	
//	フォームの内容がDBに存在するかの結果を入れる。
//	trueの場合はEdit,falseの場合はNew。
	private boolean newPost;
	
	
//	コンストラクタ
	
	public PostForm(
            String music_name,
		    String artist_name,
			PostComment postComment,
			int genre,
			String caption,
			boolean newPost) {
		this.music_name = music_name;
		this.artist_name = artist_name;
		this.postComment = postComment;
		this.genre = genre;
		this.caption = caption;
		this.newPost = newPost;
	}
	
	
	
	
//  getter/setter
	public String getMusic_name() {
		return music_name;
	}

	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

	public int getGenre() {
		return genre;
	}

	public void setGenre(int genre) {
		this.genre = genre;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public boolean isNewPost() {
		return newPost;
	}
	
	public void settNewPost(boolean newPost) {
		this.newPost = newPost;
	}
	
	

}
