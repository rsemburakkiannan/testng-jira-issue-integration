package qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.test.annotation.JiraDetails;

import java.util.ArrayList;
import java.util.List;

public class TestNgDemoTests
{

    @Test
    @JiraDetails(issueId = "PRJKEY-1")
    public void noOrderSuccess() {
        String[] rto1 = {"boolean", "BigInteger", "List",};
        String[] rto2 = {"List", "BigInteger", "boolean",};
        Assert.assertEqualsNoOrder(rto1, rto2);
    }


    @Test(expectedExceptions = AssertionError.class)
    @JiraDetails(issueId = "PRJKEY-2")
    public void noOrderFailure() {
        String[] rto1 = {"a", "a", "b",};
        String[] rto2 = {"a", "b", "b",};
        Assert.assertEqualsNoOrder(rto1, rto2);
    }

    @Test
    @JiraDetails(issueId = "PRJKEY-3")
    public void intArray_Issue4() {
        int[] intArr00 = {1};
        int[] intArr01 = {1};
        Assert.assertEquals(intArr00, intArr01);
    }

    @Test
    @JiraDetails(issueId = "PRJKEY-4")
    public void int_Integer_Arrays() {
        int[] intArr = {1, 2};
        Integer[] integerArr = {1, Integer.valueOf(3)};
        Assert.assertEquals(intArr, integerArr);
        Assert.assertEquals(integerArr, intArr);
    }

    @Test(expectedExceptions = AssertionError.class)
    @JiraDetails(issueId = "PRJKEY-5")
    public void arraysFailures_1() {
        int[] intArr = {1, 2};
        long[] longArr = {1, 2};
        Assert.assertEquals(intArr, longArr);
    }

    @Test(expectedExceptions = AssertionError.class)
    @JiraDetails(issueId = "PRJKEY-6")
    public void arraysFailures_2() {
        int[] intArr = {1, 2};
        Assert.assertEquals(intArr, Long.valueOf(1));
    }

    @Test(expectedExceptions = AssertionError.class)
    @JiraDetails(issueId = "PRJKEY-7")
    public void arraysFailures_3() {
        long[] longArr = {1};
        Assert.assertEquals(Long.valueOf(1), longArr);
    }

    @Test
    @JiraDetails(issueId = "PRJKEY-8")
    public void setsSuccess() {
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        set1.add(1);
        set2.add(1);
        set1.add(3);
        set2.add(3);
        set1.add(2);
        set2.add(2);
        Assert.assertEquals(set1, set2);
        Assert.assertEquals(set2, set1);
    }

}

