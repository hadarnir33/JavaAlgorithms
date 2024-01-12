package Ex13;

/**
 * Write a description of class Ex14StudentTester20454 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex13StudentTester20454
{
    public static void main(String[] args) {

        System.out.println("----------------------------------------");
        System.out.println("***         Q1  - minimalSt          ***");
        System.out.println("----------------------------------------");
        System.out.println("Testing : st1=\"B\" st2=\"A\"");
        String st1 = "B";
        String st2 = "A";
        String result3=Ex13.minimalSt(st1, st2);
        if (result3.equals("AB") || result3.equals("BA"))
            System.out.println("Passed, result is " + result3);
        else
            System.out.println("Failed,  expected: \"AB\" or \"BA\"   student's result: "+result3);
        System.out.println("Testing : st1=\"AA\" st2=\"A\"");
        st1 = "AA";
        st2 = "A";
        result3=Ex13.minimalSt(st1, st2);
        if (result3.equals("AA"))
            System.out.println("Passed, result is " + result3);
        else
            System.out.println("Failed,  expected: \"AA\"  student's result: "+result3);
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("***         Q2  - maxSnake           ***");
        System.out.println("----------------------------------------");
        System.out.println("testing with matrix:");
        System.out.println("4 5 2 3 1");
        System.out.println("3 4 1 4 4");
        System.out.println("1 5 6 7 8");
        System.out.println("3 4 5 8 9");
        System.out.println("3 2 2 7 6");
        int[][]mat = {  {4,5,2,3,1},
                        {3,4,1,4,4},
                        {1,5,6,7,8},
                        {3,4,5,8,9},
                        {3,2,2,7,6}};
        int result4=Ex13.maxSnake(mat);
        if (result4==13)
            System.out.println("Passed, result is " + result4);
        else
            System.out.println("Failed,  expected: 13   student's result: "+result4);

        System.out.println();
    }
}
