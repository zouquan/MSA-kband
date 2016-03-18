package align;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Max {//三值最大
    public Max() {
    }
    public static int f(int a,int b,int c){
        int k=Math.max(a,b);
        return Math.max(k,c);
    }
}
