package cd.home.redditbackend.Controller;

import cd.home.redditbackend.data.SubredditDto;
import cd.home.redditbackend.service.SubredditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubredditController {
    private final SubredditService subredditService;

    @PostMapping
    public ResponseEntity<SubredditDto> createSubreddit(@RequestBody SubredditDto subredditDto) {
        if (subredditDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(subredditService.save(subredditDto));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    /*get all subred*/
    public ResponseEntity<List<SubredditDto>> getAllSubreddits() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subredditService.getAll());
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<SubredditDto> getSubreddit(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subredditService.getSubreddit(id));
    }*/
}

