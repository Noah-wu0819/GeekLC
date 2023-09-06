public class c371 {

    public int getSum(int a, int b) {
        while(b != 0){
            System.out.println("----------");
            int jinwei = (a&b)<<1;
            System.out.println("a = "+ a);
            System.out.println("b = "+ b);
            a = a ^ b;
            System.out.println("a=a^b,a="+a);
            b= jinwei;
            System.out.println("b="+b);
        }
        return a;
    }

    public static void main(String[] args) {
        c371 c = new c371();
        c.getSum(9,11);
    }
}
