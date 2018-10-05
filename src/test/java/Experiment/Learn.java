package Experiment;

public class Learn {

    public static String checkOverloading(String abc, String xyz)
    {
        System.out.println(abc);
        System.out.println(xyz);
        return abc;
    }

    public static int checkOverloading(String abc, String xyz,int abcd)
    {
        System.out.println(abc);
        System.out.println(xyz);
        abcd = 10;
        return abcd;
    }
    public static void main(String[] args) {

        System.out.println(checkOverloading("hello","bro"));


    }
}
