package com.example.hellomobilestackoverflow;

import android.test.AndroidTestCase;
import android.os.Bundle;

import com.example.hellomobilestackoverflow.activity.MainActivity;
import com.example.hellomobilestackoverflow.model.User;
import com.example.hellomobilestackoverflow.result.SearchResponse;
import com.google.gson.Gson;

public class BaseTestCase extends AndroidTestCase {

	public void testSearchQueryTrim() throws Throwable {
		final String searchQuery = " android  ";
		assertEquals("android", MainActivity.trimSearchQuery(searchQuery));
	}
	
	public void testSearchResponseFormat() throws Throwable {
		final String searchResponseString = "{\"items\":[{\"tags\":[\"java\",\"php\",\"android\"],\"owner\":{\"reputation\":5,\"user_id\":3993456,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/38ab1ee8c8270100cc82c614c9a544fa?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"tektok tek\",\"link\":\"http://stackoverflow.com/users/3993456/tektok-tek\"},\"is_answered\":false,\"view_count\":6,\"answer_count\":1,\"score\":0,\"last_activity_date\":1409860378,\"creation_date\":1409859732,\"question_id\":25673770,\"link\":\"http://stackoverflow.com/questions/25673770/android-get-image-to-imageview-from-web-server-not-cashed-copy\",\"title\":\"Android get image to ImageView from web server not cashed copy\"},{\"tags\":[\"java\",\"android\",\"listview\"],\"owner\":{\"reputation\":441,\"user_id\":1282637,\"user_type\":\"registered\",\"accept_rate\":83,\"profile_image\":\"https://www.gravatar.com/avatar/f31a34ee542e2b071da787fd399ea95c?s=128&d=identicon&r=PG\",\"display_name\":\"user1282637\",\"link\":\"http://stackoverflow.com/users/1282637/user1282637\"},\"is_answered\":false,\"view_count\":8,\"answer_count\":1,\"score\":0,\"last_activity_date\":1409860193,\"creation_date\":1409858449,\"question_id\":25673466,\"link\":\"http://stackoverflow.com/questions/25673466/putting-footer-on-dynamically-growing-listview-android-app\",\"title\":\"Putting footer on dynamically growing ListView Android App\"},{\"tags\":[\"java\",\"android\",\"exception\",\"threadpoolexecutor\"],\"owner\":{\"reputation\":3971,\"user_id\":215266,\"user_type\":\"registered\",\"accept_rate\":76,\"profile_image\":\"https://www.gravatar.com/avatar/3a8390f51211bcbf7f8df930327ee785?s=128&d=identicon&r=PG\",\"display_name\":\"satur9nine\",\"link\":\"http://stackoverflow.com/users/215266/satur9nine\"},\"is_answered\":false,\"view_count\":3,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409860068,\"creation_date\":1409860068,\"question_id\":25673837,\"link\":\"http://stackoverflow.com/questions/25673837/android-not-handling-assertionerror-in-executor-properly\",\"title\":\"Android not handling AssertionError in Executor properly?\"},{\"tags\":[\"android\",\"android-drawable\",\"layerdrawable\"],\"owner\":{\"reputation\":5,\"user_id\":3350482,\"user_type\":\"registered\",\"profile_image\":\"http://i.stack.imgur.com/EuOk0.jpg?s=128&g=1\",\"display_name\":\"Ssr1368\",\"link\":\"http://stackoverflow.com/users/3350482/ssr1368\"},\"is_answered\":false,\"view_count\":4,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409859728,\"creation_date\":1409859728,\"question_id\":25673769,\"link\":\"http://stackoverflow.com/questions/25673769/multiple-images-single-view-mispositioned-android\",\"title\":\"Multiple images single view mispositioned Android\"},{\"tags\":[\"android\",\"firewall\",\"iptables\"],\"owner\":{\"reputation\":1,\"user_id\":4009359,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/ae6bab4fb51a29375ebaadd665bbcea5?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Geiser\",\"link\":\"http://stackoverflow.com/users/4009359/geiser\"},\"is_answered\":false,\"view_count\":3,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409859628,\"creation_date\":1409859628,\"question_id\":25673752,\"link\":\"http://stackoverflow.com/questions/25673752/working-script-for-droidwall-in-android\",\"title\":\"Working script for DroidWall in Android\"},{\"tags\":[\"java\",\"android\",\"image\",\"gridview\"],\"owner\":{\"reputation\":4699,\"user_id\":612606,\"user_type\":\"registered\",\"accept_rate\":95,\"profile_image\":\"https://www.gravatar.com/avatar/e0203736e6783dceba36e4d68a5c3bf4?s=128&d=identicon&r=PG\",\"display_name\":\"ViTo Brothers\",\"link\":\"http://stackoverflow.com/users/612606/vito-brothers\"},\"is_answered\":false,\"view_count\":8,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409859444,\"creation_date\":1409859444,\"question_id\":25673713,\"link\":\"http://stackoverflow.com/questions/25673713/android-gridview-item-change-image-on-pressed-and-change-back\",\"title\":\"Android GridView item change image on pressed and change back\"},{\"tags\":[\"android\",\"android-actionbar\",\"android-4.4-kitkat\",\"monkeytalk\"],\"owner\":{\"reputation\":114,\"user_id\":1598022,\"user_type\":\"registered\",\"accept_rate\":100,\"profile_image\":\"http://i.stack.imgur.com/6EBsg.jpg?s=128&g=1\",\"display_name\":\"Leo K\",\"link\":\"http://stackoverflow.com/users/1598022/leo-k\"},\"is_answered\":true,\"view_count\":67,\"accepted_answer_id\":25673698,\"answer_count\":1,\"score\":3,\"last_activity_date\":1409859402,\"creation_date\":1400754290,\"question_id\":23804149,\"link\":\"http://stackoverflow.com/questions/23804149/monkeytalk-2-0-4-android-kitkat-actionbar-overflow-menu-support\",\"title\":\"MonkeyTalk (2.0.4) Android (KitKat) - ActionBar overflow menu support?\"},{\"tags\":[\"java\",\"android\",\"encryption\",\"aes\",\"conceal\"],\"owner\":{\"reputation\":1601,\"user_id\":3805262,\"user_type\":\"registered\",\"accept_rate\":86,\"profile_image\":\"http://i.stack.imgur.com/h6zXd.png?s=128&g=1\",\"display_name\":\"mmlooloo\",\"link\":\"http://stackoverflow.com/users/3805262/mmlooloo\"},\"is_answered\":false,\"view_count\":17,\"answer_count\":0,\"score\":-1,\"last_activity_date\":1409859152,\"creation_date\":1409859152,\"question_id\":25673637,\"link\":\"http://stackoverflow.com/questions/25673637/encrypt-images-at-the-server-and-decrypt-it-in-android\",\"title\":\"encrypt images at the server and decrypt it in android\"},{\"tags\":[\"android\",\"android-asynctask\"],\"owner\":{\"reputation\":6,\"user_id\":4009281,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/5409fc59dd6c349e4fe12a7cc6a504ce?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"dadecki\",\"link\":\"http://stackoverflow.com/users/4009281/dadecki\"},\"is_answered\":false,\"view_count\":10,\"answer_count\":0,\"score\":1,\"last_activity_date\":1409859053,\"creation_date\":1409858813,\"last_edit_date\":1409859053,\"question_id\":25673563,\"link\":\"http://stackoverflow.com/questions/25673563/android-asynctask-webservice-calling-not-working\",\"title\":\"Android AsyncTask Webservice calling not working\"},{\"tags\":[\"android\",\"android-studio\",\"android-styles\"],\"owner\":{\"reputation\":8,\"user_id\":3795691,\"user_type\":\"registered\",\"profile_image\":\"http://i.stack.imgur.com/2bkoj.jpg?s=128&g=1\",\"display_name\":\"matt95\",\"link\":\"http://stackoverflow.com/users/3795691/matt95\"},\"is_answered\":false,\"view_count\":4,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409858799,\"creation_date\":1409858799,\"question_id\":25673561,\"link\":\"http://stackoverflow.com/questions/25673561/where-to-find-values-v11-values-v14-in-android-studio-projects\",\"title\":\"Where to find values-v11 &amp; values-v14 in Android Studio Projects?\"},{\"tags\":[\"android\",\"facebook\",\"android-intent\"],\"owner\":{\"reputation\":1568,\"user_id\":963542,\"user_type\":\"registered\",\"accept_rate\":83,\"profile_image\":\"https://www.gravatar.com/avatar/7fdeff8c13561f05f0e9ea002a864879?s=128&d=identicon&r=PG\",\"display_name\":\"JoeMighty\",\"link\":\"http://stackoverflow.com/users/963542/joemighty\"},\"is_answered\":true,\"view_count\":36867,\"accepted_answer_id\":14496338,\"answer_count\":4,\"score\":32,\"last_activity_date\":1409858662,\"creation_date\":1316950663,\"last_edit_date\":1389979280,\"question_id\":7545254,\"link\":\"http://stackoverflow.com/questions/7545254/android-and-facebook-share-intent\",\"title\":\"Android and Facebook share intent\"},{\"tags\":[\"admob\"],\"owner\":{\"reputation\":6,\"user_id\":1924249,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/d70bade261ab846e39b8d36a5f848899?s=128&d=identicon&r=PG\",\"display_name\":\"user1924249\",\"link\":\"http://stackoverflow.com/users/1924249/user1924249\"},\"is_answered\":false,\"view_count\":17,\"answer_count\":1,\"score\":0,\"last_activity_date\":1409858564,\"creation_date\":1409620455,\"question_id\":25614566,\"link\":\"http://stackoverflow.com/questions/25614566/how-can-i-use-google-ad-mob-in-my-android-sdk-xml\",\"title\":\"How can I use google ad mob in my android sdk xml\"},{\"tags\":[\"android\",\"draw\",\"ondraw\"],\"owner\":{\"reputation\":10,\"user_id\":3653803,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/f7e557e7cbd108754e93a512f90f92df?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"user3653803\",\"link\":\"http://stackoverflow.com/users/3653803/user3653803\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409858436,\"creation_date\":1409857169,\"question_id\":25673131,\"link\":\"http://stackoverflow.com/questions/25673131/trouble-with-ondraw-method-in-android\",\"title\":\"Trouble with onDraw() method in Android\"},{\"tags\":[\"android\",\"button\",\"mouse\"],\"owner\":{\"reputation\":41,\"user_id\":730757,\"user_type\":\"registered\",\"accept_rate\":50,\"profile_image\":\"https://www.gravatar.com/avatar/84773db48c74849595bc7280c76743fa?s=128&d=identicon&r=PG\",\"display_name\":\"eikuh\",\"link\":\"http://stackoverflow.com/users/730757/eikuh\"},\"is_answered\":false,\"view_count\":220,\"answer_count\":1,\"score\":1,\"last_activity_date\":1409858392,\"creation_date\":1395935978,\"question_id\":22692959,\"link\":\"http://stackoverflow.com/questions/22692959/right-mouse-button-in-android\",\"title\":\"Right mouse button in Android\"},{\"tags\":[\"android\",\"phonegap\"],\"owner\":{\"reputation\":144,\"user_id\":1067499,\"user_type\":\"registered\",\"accept_rate\":78,\"profile_image\":\"https://www.gravatar.com/avatar/d9cb0c413184a0a533e296884c730bfd?s=128&d=identicon&r=PG\",\"display_name\":\"gatzkerob\",\"link\":\"http://stackoverflow.com/users/1067499/gatzkerob\"},\"is_answered\":true,\"view_count\":9166,\"accepted_answer_id\":9864376,\"answer_count\":2,\"score\":7,\"last_activity_date\":1409858031,\"creation_date\":1332709889,\"question_id\":9864108,\"link\":\"http://stackoverflow.com/questions/9864108/android-phonegap-numeric-keyboard-only\",\"title\":\"Android PhoneGap - numeric keyboard only\"},{\"tags\":[\"android\",\"eclipse\"],\"owner\":{\"reputation\":1,\"user_id\":3999367,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/b6f539ef1b8d268292535952d66d5694?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Veera Prasad\",\"link\":\"http://stackoverflow.com/users/3999367/veera-prasad\"},\"is_answered\":false,\"view_count\":18,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409858025,\"creation_date\":1409747791,\"last_edit_date\":1409858025,\"question_id\":25644522,\"link\":\"http://stackoverflow.com/questions/25644522/thread-throws-error-message-eclipse-android\",\"title\":\"Thread throws error message---eclipse Android\"},{\"tags\":[\"android\",\"api\",\"oauth\",\"access-token\"],\"owner\":{\"reputation\":6,\"user_id\":3921782,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/e45563966f3810fc1446d0d774890166?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"Shoeb Ahmed Siddique\",\"link\":\"http://stackoverflow.com/users/3921782/shoeb-ahmed-siddique\"},\"is_answered\":false,\"view_count\":21,\"answer_count\":1,\"score\":1,\"last_activity_date\":1409857794,\"creation_date\":1409824751,\"last_edit_date\":1409827695,\"question_id\":25662536,\"link\":\"http://stackoverflow.com/questions/25662536/how-to-use-token-and-secret-in-oauth-in-android\",\"title\":\"how to use token and secret in Oauth in android\"},{\"tags\":[\"javascript\",\"android\",\"web-applications\",\"sencha-touch\"],\"owner\":{\"reputation\":17,\"user_id\":2733130,\"user_type\":\"registered\",\"accept_rate\":27,\"profile_image\":\"https://www.gravatar.com/avatar/7193e0074ebcefa0051c03e1e726dbfe?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"user2733130\",\"link\":\"http://stackoverflow.com/users/2733130/user2733130\"},\"is_answered\":false,\"view_count\":14,\"answer_count\":1,\"score\":0,\"last_activity_date\":1409857658,\"creation_date\":1409813750,\"last_edit_date\":1409857658,\"question_id\":25659058,\"link\":\"http://stackoverflow.com/questions/25659058/how-to-open-android-app-from-sencha-touch-application-and-send-some-data\",\"title\":\"How to open Android app from Sencha Touch Application and send some data?\"},{\"tags\":[\"android\",\"ios\",\"unity3d\",\"push-notification\",\"vuforia\"],\"owner\":{\"reputation\":349,\"user_id\":191998,\"user_type\":\"registered\",\"accept_rate\":56,\"profile_image\":\"https://www.gravatar.com/avatar/c4ddae78950eb97fe435d6e6f8587ddc?s=128&d=identicon&r=PG\",\"display_name\":\"Ronny vdb\",\"link\":\"http://stackoverflow.com/users/191998/ronny-vdb\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":0,\"score\":0,\"last_activity_date\":1409857587,\"creation_date\":1409857587,\"question_id\":25673241,\"link\":\"http://stackoverflow.com/questions/25673241/unity3d-push-notifications-ios-android-vuforia-urbanairship\",\"title\":\"Unity3D Push Notifications iOS &amp; Android Vuforia &amp; UrbanAirship\"},{\"tags\":[\"android\",\"android-fragments\",\"android-dialogfragment\",\"android-datepicker\"],\"owner\":{\"reputation\":3,\"user_id\":4008243,\"user_type\":\"registered\",\"profile_image\":\"https://www.gravatar.com/avatar/fe925931d2e7a0e62261f2ee1bf538a7?s=128&d=identicon&r=PG&f=1\",\"display_name\":\"JHinne\",\"link\":\"http://stackoverflow.com/users/4008243/jhinne\"},\"is_answered\":false,\"view_count\":7,\"answer_count\":1,\"score\":0,\"last_activity_date\":1409857410,\"creation_date\":1409857057,\"question_id\":25673106,\"link\":\"http://stackoverflow.com/questions/25673106/android-issues-with-datepicker-within-a-fragment\",\"title\":\"android - issues with datepicker within a fragment\"}],\"has_more\":true,\"quota_max\":300,\"quota_remaining\":119}";
		final SearchResponse searchResponse = new Gson().fromJson(searchResponseString, SearchResponse.class);
		assertNotNull(searchResponse);
		assertNotNull(searchResponse.items);
		assertEquals(20, searchResponse.items.size());
		assertEquals(true, searchResponse.hasMore);
	}
	
	public void testParcelableUser() throws Throwable {
		final User user = new User();
		user.reputation = 2008;
		user.userId = 12345;
		user.userType = "type";
		user.profileImage = "http://www.scipublish.com/public/image/core/default_avatar.png";
		user.displayName = "MaciejCiemiega";
		user.link = "http://www.google.com";
		
		final String EXTRA_USER_KEY = "user";
		final Bundle bundle = new Bundle();
		bundle.putParcelable(EXTRA_USER_KEY, user);
		
		final User userFromBundle = bundle.getParcelable(EXTRA_USER_KEY);
		assertEquals(user, userFromBundle);
	}
	
}
