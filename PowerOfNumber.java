public class PowerOfNumber{
    static int pow(int l,int p){
        if(p==0){
            return 1;
        }
        int halfPow=pow(l,p/2);
        if(p%2==0){
            return halfPow*halfPow;
        }
        else{
            return l* halfPow*halfPow;
        }

    }
    public static void main(String[] args) {
        int l=2;
        int p=5;
        System.out.println("power of 2^5 is :" +pow(l,p));
    }
    
}
