package com.example.android_dualpane_layout;

import org.junit.Test;

import models.DataWrapper;
import utils.Retriever;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void retriever_isCorrect(){
        Retriever<DataWrapper> retriever = new Retriever<>();
        DataWrapper expectedResult = DataWrapper.fromJSON("{data:{names:['LU XIANZE', 'LIM LING HUI', 'YAW JIAN HAO']}}");
        DataWrapper actualResult = retriever.getData();
        assertEquals(
                expectedResult,
                actualResult
        );
    }
}