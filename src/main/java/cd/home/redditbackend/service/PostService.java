package cd.home.redditbackend.service;

import cd.home.redditbackend.data.PostRequest;
import cd.home.redditbackend.data.PostResponse;
import cd.home.redditbackend.exceptions.PostNotFoundException;
import cd.home.redditbackend.exceptions.SubredditNotFoundException;
import cd.home.redditbackend.mapper.PostMapper;
import cd.home.redditbackend.model.Post;
import cd.home.redditbackend.model.Subreddit;
import cd.home.redditbackend.model.User;
import cd.home.redditbackend.repository.PostRepository;
import cd.home.redditbackend.repository.SubredditRepository;
import cd.home.redditbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PostService {

    private final SubredditRepository subredditRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AuthService authService;
    private final UserRepository userRepository;

    @Transactional
    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
        Subreddit subreddit = subredditRepository.findById(subredditId)
                .orElseThrow(() -> new SubredditNotFoundException(subredditId.toString()));
        List<Post> posts = postRepository.findAllBySubreddit(subreddit);
        return posts.stream().map(postMapper::mapToDto).collect(toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
}
