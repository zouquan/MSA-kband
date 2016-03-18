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
public class InsideStrip {
    public InsideStrip() {
    }
    public static boolean f(int i,int j,int mn,int k){
        if(j-i>=-k&&j-i<=mn+k)
            return true;
        else
            return false;

    }
}
