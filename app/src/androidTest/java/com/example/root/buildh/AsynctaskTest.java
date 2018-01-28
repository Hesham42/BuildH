package com.example.root.buildh;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 1/26/18.
 */
@RunWith(AndroidJUnit4.class)
public class AsynctaskTest extends AndroidTestCase {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);
    Context context;

    @Test
    public void doInBackground() throws Exception {
        try{
           context= mActivityRule.getActivity().getApplicationContext();
            JokeLoader jokeLoader =
                    new JokeLoader(context);
            jokeLoader.execute();
            String result = jokeLoader.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            fail("Operation timed out");
        }
    }
}
