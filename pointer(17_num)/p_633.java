public class p_633 {

    public boolean judgeSquareSum(int c) {
//        for ( long i = 0; i <=c; i++){
//            double b = Math.sqrt( c - i*i);
//            if (b == (int)b)
//                return true;
//        }
//        return false;

        long i = 0;
        long b = (long) Math.sqrt(c);

        while ( i <= b){
            if ( i*i + b*b == c)
                return true;
            else if (i*i + b*b < c)
                i++;
            else
                b--;
        }


        return false;
}
}
