package cd.home.redditbackend.mapper;

import cd.home.redditbackend.data.SubredditDto;
import cd.home.redditbackend.model.Post;
import cd.home.redditbackend.model.Subreddit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {
    SubredditMapper INSTANCE = Mappers.getMapper(SubredditMapper.class);

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

  /*  @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);*/

}
