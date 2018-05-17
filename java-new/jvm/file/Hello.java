public class Hello{	
    public int add(int x){
       int y = 1;
       return x + y;
    }

    public int add1(int x){
       return x + 1;
    }

    public int add2(int x){
       return x ;
    }

    public void test(){

        long y = 1 << 31;
        int x = (int) y;

    }

    public long test1(long x){
    	return x++;
    }

 	public int test2(int x){
    	return x++;
    }

}


