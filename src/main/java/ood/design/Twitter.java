package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Twitter
 * 355. Design Twitter
 */
@Quality(value = Stage.FAILING, details = "7/16")
@Platform(Site.LEETCODE)
class Twitter {

    private final Map<User, LinkedList<User>> usersFollowersMap;
    private final Map<User, LinkedList<Tweet>> usersTimelinesMap;
    private final Map<Integer, User> users;
    private final Map<Integer, Tweet> tweets;

    public Twitter(){
        usersFollowersMap = new HashMap<>();
        usersTimelinesMap = new HashMap<>();
        users = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId){
        users.putIfAbsent(userId, new User(userId));
        User user = users.get(userId);
        usersTimelinesMap.putIfAbsent(user, new LinkedList<>());
        if(usersFollowersMap.get(user) == null){
            usersFollowersMap.put(user, new LinkedList<>());
            usersFollowersMap.get(user).add(user);
        }

        usersFollowersMap.get(user).stream().forEach(
                follower -> {
                    tweets.putIfAbsent(tweetId, new Tweet(tweetId, userId));
                    usersTimelinesMap.get(follower).addFirst(
                            tweets.get(tweetId)
                    );
                }
        );
    }

    public List<Integer> getNewsFeed(int userId){
        if(usersTimelinesMap.get(users.get(userId)) == null)
            return new LinkedList<>();
        return usersTimelinesMap.get(users.get(userId)).stream().map(
                o -> o.id
        ).collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId){
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));

        usersFollowersMap.putIfAbsent(users.get(followeeId), new LinkedList<>());
        usersFollowersMap.get(users.get(followeeId)).add(users.get(followerId));
        populateTimeline(users.get(followerId), users.get(followeeId));
    }

    /**
     * TODO : refresh the timeline with tweets that you missed
     */
    private void populateTimeline(User user, User user1){
    }

    public void unfollow(int followerId, int followeeId){
        cleanTimeLine(users.get(followerId), users.get(followeeId));
        usersFollowersMap.get(users.get(followeeId)).remove(users.get(followerId));
    }

    private void cleanTimeLine(User user, User user1){
        usersFollowersMap.get(user1).remove(user);
        usersTimelinesMap.get(user).removeIf(tweet -> tweet.userId == user1.id);
    }

    private static class User {
        public int id;

        public User(int i){
            this.id = i;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode(){
            return Objects.hash(id);
        }
    }

    private static class Tweet {
        public int id;
        public int userId;

        public Tweet(int i, int u){
            this.id = i;
            this.userId = u;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Tweet user = (Tweet) o;
            return id == user.id;
        }

        @Override
        public int hashCode(){
            return Objects.hash(id);
        }
    }
}
