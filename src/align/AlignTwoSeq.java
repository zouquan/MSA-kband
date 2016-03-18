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
public class AlignTwoSeq {
    int g=-SetParameter.g,h=-SetParameter.h,M=SetParameter.M,misM=SetParameter.misM,rate = SetParameter.rate;

    String s,t;
    static int maxk;
    boolean flag = true;

    public AlignTwoSeq(String s, String t) {
        if(s.length()<t.length()){
            this.s = s;
            this.t = t;
        }
        else{
            this.s = t;
            this.t = s;
            flag = false;
        }
    }

    public void run(){
        int mn = Math.abs(s.length()-t.length());
        int k = rate*mn+1;
        int pok,m = s.length(),n=t.length();//M为匹配积分，pok用于控制终止
        //System.out.println("-----------");
        do{
            AffineGapPenalty aff = new AffineGapPenalty(m, n, g, h, k, mn, s, t,M,misM);
             maxk = aff.Init(); //必须先行调用此方法初始化数组

            //a[m,n]>=M*(n-k-1)-2*(k+1)*(h+g)控制终止
            //最坏情况估计至少k+1对空格，且不相邻

            pok=M*(n-k-1)-2*(k+1)*(h+g);
            if(maxk<pok)
                {k=k*2;
                   // System.out.println(k);
                   // System.out.println(pok);
                }
            else break;
        }while(k<=pok);

        int ch=1;//1.2.3对应a.b.c
       if(maxk==AffineGapPenalty.a[m][n+k-m]){ch=1;}
       else if(maxk==AffineGapPenalty.b[m][n+k-m]){ch=2;}
       else {ch=3;}//(k==AffineGapPenalty.c[m][n+k-m])


       Make make=new Make(g,h,m,n,k,mn,s,t,flag);
       make.f(ch);
    }


}
