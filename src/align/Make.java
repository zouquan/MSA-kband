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
public class Make {
    int len,h,g,m,n,mn,k;
    int [][] a,b,c,p;
    Case ca;
    static char [] aligns,alignt,alignsQ,aligntQ;
    String s,t;
    boolean flag;
    public Make(int g,int h,int m,int n,int k,int mn,String S,String T,boolean flag) {
        a=AffineGapPenalty.a;
        b=AffineGapPenalty.b;
        c=AffineGapPenalty.c;
        p=AffineGapPenalty.p;
        this.g=g;
        this.h=h;
        this.m=m;
        this.n=n;
        this.mn=mn;
        this.k=k;
        this.flag = flag;
        s=S;
        t=T;
        int ff=Math.max(m,n)+2+2*(k+1);
        alignsQ=new char[ff];//max(m.n)+2+2(k+1);m+n+2
        aligntQ=new char[ff];
        for(int i=0;i<alignsQ.length;i++){
            alignsQ[i]='W';
            aligntQ[i]='W';
        }
        ca=new Case(g,h);//�б�������ڵ���

    }
    public void f(int ch){
        int i=m,j=n;
        len=0;
        boolean tem=true;
        do{
                if(ch==1){
                    ch=ca.caseA(i,j);
                    alignsQ[len]=s.charAt(i-1);
                    aligntQ[len]=t.charAt(j-1);
                    len=len+1;
                    i--;
                    j--;
                }
                else if(ch==2){
                    ch=ca.caseB(i,j);
                    alignsQ[len]='-';
                    aligntQ[len]=t.charAt(j-1);
                    len=len+1;
                    j--;
                }
                else if(ch==3){
                    ch=ca.caseC(i,j);
                    alignsQ[len]= s.charAt(i-1) ;
                    aligntQ[len]= '-';
                    len=len+1;
                    i--;
                }
                else{System.out.println("error");System.exit(0);}
                if(i==0&&j==0)tem=false;
        }while(tem);

//��������ַ���ת�ú��Ƴ�����
        int p1,p2;
        String str1=new String(alignsQ);

        String str2=new String(aligntQ);

        StringBuffer stb1=new StringBuffer(str1);
        StringBuffer stb2=new StringBuffer(str2);
        stb1.reverse();
        stb2.reverse();

        for(p1=0;p1<stb1.length();p1++){
            if(stb1.charAt(p1)=='W');
            else break;
        }
        for(p2=0;p2<stb2.length();p2++){
            if(stb2.charAt(p2)=='W');
            else break;
        }
        stb1.delete(0,p1);
        stb2.delete(0,p2);

        String st1=new String(stb1);
        String st2=new String(stb2);
        if(flag){
            aligns = st1.toCharArray();
            alignt = st2.toCharArray();
        }
        else{
            alignt = st1.toCharArray();
            aligns = st2.toCharArray();
        }

    }
}
