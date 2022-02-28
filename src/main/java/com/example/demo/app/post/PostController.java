package com.example.demo.app.post;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
//	一覧画面
	@GetMapping
	public String post(PostForm postForm,Model model) {
		
		postForm.setNewPost(true);
		
		List<Post> list = postService.findAll();
		
		model.addAttribute("list", list);
		model.addAttribute("heading", "Home");
		model.addAttribute("title", "投稿一覧");
		return "post/index";
	}
	
//	新規登録（投稿Post）
	@PostMapping("/insert")
	public String insert(
			@Valid @ModelAttribute PostForm postForm,
			BindingResult result,
			Model model
			) {
		
		if (!result.hasErrors()) {
			Post post = makePost(postForm,0);
			postService.insert(post);
			return "redirect:/post";
			
			
		}else {
			postForm.setNewPost(true);
			model.addAttribute("postForm", postForm);
			List<Post> list = postService.findAll();
			model.addAttribute("list", list);
			model.addAttribute("title","投稿一覧バリデーション");	
			return "post/index";
			
		}
		
	}
	
//	編集（Edit）
	@GetMapping("/{id}")
	public String showUpdate(
			PostForm postForm,
			@PathVariable int id,
			Model model) {
		
		Optional<Post> postOpt = postService.getPost(id);
		
		Optional<PostForm> postFormOpt =  postOpt.map(t->makePostForm(t));
		
		
		if(postFormOpt.isPresent()) {
			postForm = postFormOpt.get();
		}
		
		model.addAttribute("postForm",postForm);
		List<Post> list = postService.findAll();
		model.addAttribute("list",list);
		model.addAttribute("postId",id);
		model.addAttribute("title","更新用フォーム");
		
		return "post/index";
	}
	
//	更新(update)
	@PostMapping("/update")
	public String update(
			@Valid @ModelAttribute PostForm postForm,
			BindingResult result,
			@RequestParam("postId") int postId,
			Model model,
			RedirectAttributes redirectAttributes) {
		
		if (!result.hasErrors()) {
			
			Post post = makePost(postForm, postId);
			
			postService.update(post);
			redirectAttributes.addFlashAttribute("complete","完了しました。");
			return "redirect:/post";
			
		}else {
			model.addAttribute("postForm",postForm);
			model.addAttribute("title","投稿一覧");
			return "post/index";
			
			
		}

		
	}
	
//	投稿削除(delete)
	@PostMapping("/delete")
	public String delete(
			@RequestParam("postId") int id,
			Model model
			) {
		postService.deleteById(id);
		return "redirect:/post";
		
	}
	
	
	
	
	private Post makePost(PostForm postForm ,int postId) {
		Post post = new Post();
		if(postId != 0) {
			post.setId(postId);
		}
		
		post.setUserId(1);
		post.setMusic_name(postForm.getMusic_name());
		post.setArtist_name(postForm.getArtist_name());
		post.setGenreId(postForm.getGenreId());
		post.setCaption(postForm.getCaption());
		post.setCreated(LocalDate.now());
		
		return post;
	}
	
	private PostForm makePostForm(Post post) {
		PostForm postForm = new PostForm();
		
		postForm.setUserId(post.getUserId());
		postForm.setMusic_name(post.getMusic_name());
		postForm.setArtist_name(post.getArtist_name());
		postForm.setGenreId(post.getGenreId());
		postForm.setCaption(post.getCaption());
		postForm.setNewPost(false);
		
		return postForm;
	}
	

}
