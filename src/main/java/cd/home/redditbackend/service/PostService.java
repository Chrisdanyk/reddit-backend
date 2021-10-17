package cd.home.redditbackend.service;

import cd.home.redditbackend.data.PostRequest;
import cd.home.redditbackend.mapper.PostMapper;
import cd.home.redditbackend.repository.PostRepository;
import cd.home.redditbackend.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PostService {

    private final SubredditRepository subredditRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final AuthService authService;

    @Transactional
    public void save(PostRequest postRequest) {
       /* Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));*/
    }

    public Object getAllPosts() {
        return null;
    }

    public Object getPost(Long id) {
        return null;
    }


    public Object getPostsBySubreddit(Long id) {
        return null;
    }

    public Object getPostsByUsername(String name) {
        return null;
    }
}
