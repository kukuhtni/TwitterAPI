import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterApp {
    private final static String CONSUMER_KEY = "FScRBXh238ME6IWH9C77KQDXX";
    private final static String CONSUMER_KEY_SECRET = "VOKljuK2H4PkUWPUgaZ7KcXIqKnY95ZLtP9g8X0vHeHVB3Psq3";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo tugas webservice kukuh");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "CmYsmViAWwuPkF4iR2pCEfoHoHS9yxiTh4mYfYuNjjxWY";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1151866038520147970-c2zTTHyahNIXYbXz8HFGNbqQFqSMr3";
    }

    public static void main(String[] args) throws Exception {
	new TwitterApp().start();
    }
}