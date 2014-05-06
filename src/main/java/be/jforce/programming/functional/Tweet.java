package be.jforce.programming.functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Tweet {
    private User user;
    private String content;
    private Collection<String> hashtags;
    private Collection<String> handles;

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
        List<String> words = Arrays.asList(content.split("[^#@\\w]"));
        this.hashtags = words.stream()
                .filter(s -> s.startsWith("#"))
                .map(String::toLowerCase)
                .distinct()
                .collect(toList());
        this.handles = words.stream()
                .filter(s -> s.startsWith("@"))
                .map(String::toLowerCase)
                .distinct()
                .collect(toList());
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Collection<String> getHashtags() {
        return hashtags;
    }

    public Collection<String> getHandles() {
        return handles;
    }

    public boolean hasHashtag(String hashtag) {
        return hashtags.contains(hashtag.toLowerCase());
    }

    @Override
    public String toString() {
        return user.getHandle() + ": " + content;
    }
}
