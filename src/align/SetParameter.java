package align;
import java.io.*;
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
public class SetParameter {
    static int M,misM,g,h,rate;
    public SetParameter() {

    }
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("parameter.txt"));

            int[] para = new int[5];
            int k=0;
            while(br.ready()){
                String line = br.readLine().trim();
                //System.out.println(line);
                if(line.length()==0)
                    continue;
                para[k] = Integer.parseInt(line.substring(line.indexOf('=')+1));
                k++;
                if(k==5)
                    break;

            }
            br.close();
            M = para[0];
            misM = para[1];
            g = para[2];
            h = para[3];
            rate = para[4];


        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }

    }
}
