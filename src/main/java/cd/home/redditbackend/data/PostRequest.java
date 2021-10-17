package cd.home.redditbackend.data;

import cd.home.redditbackend.model.Subreddit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private Long postId;
    private Subreddit subreddit;
    private String postName;
    private String url;
    private String description;
}
