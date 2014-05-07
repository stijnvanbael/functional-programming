package be.jforce.programming.functional;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

public class FunctionalProgrammingTest {

    private List<Tweet> tweets = Arrays.asList(TWEET_1, TWEET_2, TWEET_3, TWEET_4, TWEET_5, TWEET_6, TWEET_7, TWEET_8, TWEET_9);
    private UserRepository userRepository = new UserRepository(LISA, STEPHEN, ROBERT);

    @Test
    public void tweetsWithHashtagJava8() {
        List<Tweet> java8Tweets = new ArrayList<>(); //TODO

        assertThat(java8Tweets.size(), is(5));
        assertThat(java8Tweets.get(0), is(TWEET_1));
        assertThat(java8Tweets.get(1), is(TWEET_2));
        assertThat(java8Tweets.get(2), is(TWEET_4));
        assertThat(java8Tweets.get(3), is(TWEET_6));
        assertThat(java8Tweets.get(4), is(TWEET_8));
    }

    @Test
    public void tweetingUsers() {
        List<User> users = new ArrayList<>(); //TODO

        assertThat(users.size(), is(9));
        assertThat(users.get(0), is(STEPHEN));
        assertThat(users.get(1), is(LISA));
        assertThat(users.get(2), is(STEPHEN));
        assertThat(users.get(3), is(LISA));
        assertThat(users.get(4), is(STEPHEN));
        assertThat(users.get(5), is(ROBERT));
        assertThat(users.get(6), is(STEPHEN));
        assertThat(users.get(7), is(LISA));
        assertThat(users.get(8), is(STEPHEN));
    }

    @Test
    public void uniqueHashtags() {
        List<String> hashtags = new ArrayList<>(); //TODO

        assertThat(hashtags.size(), is(3));
        assertThat(hashtags.get(0), is("#nighthacking"));
        assertThat(hashtags.get(1), is("#java8"));
        assertThat(hashtags.get(2), is("#hadoop"));
    }

    @Test
    public void tweetsForUser() {
        Map<User, List<Tweet>> tweetsForUser = new HashMap<>(); // TODO

        assertThat(tweetsForUser.size(), is(3));

        List<Tweet> lisasTweets = tweetsForUser.get(LISA);
        assertThat(lisasTweets.size(), is(3));
        assertThat(lisasTweets.get(0), is(TWEET_2));
        assertThat(lisasTweets.get(1), is(TWEET_4));
        assertThat(lisasTweets.get(2), is(TWEET_8));

        List<Tweet> stephensTweets = tweetsForUser.get(STEPHEN);
        assertThat(stephensTweets.size(), is(5));
        assertThat(stephensTweets.get(0), is(TWEET_1));
        assertThat(stephensTweets.get(1), is(TWEET_3));
        assertThat(stephensTweets.get(2), is(TWEET_5));
        assertThat(stephensTweets.get(3), is(TWEET_7));
        assertThat(stephensTweets.get(4), is(TWEET_9));

        List<Tweet> robertsTweets = tweetsForUser.get(ROBERT);
        assertThat(robertsTweets.size(), is(1));
        assertThat(robertsTweets.get(0), is(TWEET_6));
    }

    @Test
    public void averageLengthOfTweets() {
        int length = 0; // TODO

        assertThat(length, is(63));
    }

    @Test
    public void referencedUsersByTweet() {
        long start = System.currentTimeMillis();
        Map<Tweet, List<User>> usersForTweet = new HashMap<>(); // TODO, use UserRepository
        long duration = System.currentTimeMillis() - start;

        assertThat(duration, lessThan(500L));
        assertThat(usersForTweet.size(), is(6));
        assertThat(usersForTweet.get(TWEET_3), is(Arrays.asList(LISA)));
        assertThat(usersForTweet.get(TWEET_4), is(Arrays.asList(STEPHEN)));
        assertThat(usersForTweet.get(TWEET_5), is(Arrays.asList(LISA)));
        assertThat(usersForTweet.get(TWEET_6), is(Arrays.asList(STEPHEN)));
        assertThat(usersForTweet.get(TWEET_7), is(Arrays.asList(ROBERT)));
        assertThat(usersForTweet.get(TWEET_9), is(Arrays.asList(LISA, ROBERT)));
    }

    private static final User LISA = new User("@LisaA", "Lisa Andersen");
    private static final User STEPHEN = new User("@steveonjava", "Stephen Chin");
    private static final User ROBERT = new User("@Robertolomeus", "Robert");

    public static final Tweet TWEET_1 = new Tweet(STEPHEN,  "Hang on for tonight's #nighthacking session on #Java8");
    public static final Tweet TWEET_2 = new Tweet(LISA,     "The nighthacking session on #Java8 is boring!");
    public static final Tweet TWEET_3 = new Tweet(STEPHEN,  "@LisaA why do you find it boring? What can we do to make it more interesting?");
    public static final Tweet TWEET_4 = new Tweet(LISA,     "@steveonjava there's too much bla bla, I want to start programming in #java8!");
    public static final Tweet TWEET_5 = new Tweet(STEPHEN,  "@LisaA Thanks for the feedback, I'll keep that in mind!");
    public static final Tweet TWEET_6 = new Tweet(ROBERT,   "Really enjoyed @steveonjava's #nighthacking session on #java8");
    public static final Tweet TWEET_7 = new Tweet(STEPHEN,  "@Robertolomeus Thanks for the love, appeciate it! #nighthacking");
    public static final Tweet TWEET_8 = new Tweet(LISA,     "Hooray! #Java8 is GA!");
    public static final Tweet TWEET_9 = new Tweet(STEPHEN,  "@LisaA @Robertolomeus It was a pleasure having you in my session tonight. See you next time for a session on #Hadoop!");

}
