package com.example.root.buildh;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 1/26/18.
 */
@RunWith(AndroidJUnit4.class)
public class AsynctaskTest extends AndroidTestCase {
    @Test
    public void doInBackground() throws Exception {
        try{
            MainActivity mainActivity = new MainActivity();
            com.example.root.buildh.JokeLoader jokeLoader =
                    new com.example.root.buildh.JokeLoader(mainActivity,null);
            jokeLoader.execute();
            String result = jokeLoader.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            Log.e("AsyncTaskTested", "testDoInBackground: Timed out");
        }
    }
}
