package question;

public class Q01 {
    public int max4(int a, int b, int c, int d){
        int result = a;
        if (result < b) result = b;
        if (result < c) result = c;
        if (result < d) result = d;

        return result;
    }

    public int min3(int a, int b, int c) {
        int result = a;
        if (result > b) result = b;
        if (result > c) result = c;

        return result;
    }

    public int min4(int a, int b, int c, int d){
        int result = a;
        if (result > b) result = b;
        if (result > c) result = c;
        if (result > d) result = d;

        return result;
    }
}
