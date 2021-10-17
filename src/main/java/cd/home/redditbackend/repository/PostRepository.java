package cd.home.redditbackend.repository;

import cd.home.redditbackend.model.Post;
import cd.home.redditbackend.model.Subreddit;
import cd.home.redditbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);

}