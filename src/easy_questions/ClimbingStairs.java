package easy_questions;

public class ClimbingStairs {
    // You are climbing a staircase. It takes n steps to reach the top.
    // Each time you can either climb 1 or 2 steps. In how many distinct ways can
    // you climb to the top?
    public static int climbStairs(int n) {
        int oneStepBack = 1;
        int twoStepBack = 1;
        for (int i = 2; i <= n; i++) {
            int temp = oneStepBack + twoStepBack;
            twoStepBack = oneStepBack;
            oneStepBack = temp;
        }
        return oneStepBack;
    }

    public static void test() {
        int[] allNs = new int[] { 2, 3 };
        int[] allOutputs = new int[] { 2, 3 };
        boolean allPass = true;
        for (int i = 0; i < allNs.length; i++) {
            int n = allNs[i];
            int output = allOutputs[i];
            int myOutput = climbStairs(n);
            if (myOutput != output) {
                System.out.println(String.format("Input: %s", n));
                System.out.println(String.format("Your code gave: %s", myOutput));
                System.out.println(String.format("Correct output: %s", output));
                allPass = false;
            }
        }
        if (allPass) {
            System.out.println("All Correct");
        }

    }
}
