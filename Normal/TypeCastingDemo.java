public class TypeCastingDemo {
    public static void main(String[] args) {

        int i = 34;
        char c = 'a';
        boolean b = true;
        float f = 4.4f;
        double d = 454.243232323;
        long l = 432222222222L;
        String s = "123";

        double di = i;
        int id = (int) d;

        int ci = c;
        char ic = (char) 66;

        String si = String.valueOf(i);
        int is = Integer.parseInt(s);


        Integer obj = i;
        int oi = obj;
    }
}
