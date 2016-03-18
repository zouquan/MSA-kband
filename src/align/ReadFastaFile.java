package align;
import java.io.*;
import java.util.*;
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
public class ReadFastaFile {
    String inputfile;
    static Vector name = new Vector();
    static int s1_len;
    static String s1;
    String[] seq = new String[2];
    public ReadFastaFile(String inputfile) {
        this.inputfile = inputfile;
    }
    public void run(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(inputfile));
            String line = br.readLine();

            int k=0;
            while (br.ready()) {
                if (line.length() != 0 && line.charAt(0) == '>') {
                    name.add(line);
                    StringBuffer sb = new StringBuffer();
                    line = br.readLine();
                    while(br.ready()&&line.length()==0)
                        line = br.readLine();
                    while (line.length() != 0 && line.charAt(0) != '>') {
                        sb.append(line);
                        if (br.ready()) {
                            line = br.readLine();
                        } else {
                            break;
                        }
                    }
                    seq[k] = sb.toString();
                    k++;
                    if(k==2){
                        AlignTwoSeq ats = new AlignTwoSeq(seq[0],seq[1]);
                        ats.run();
                        k=1;

                        String outtmp = String.valueOf(name.size())+".stringtmp";
                        BufferedWriter bw = new BufferedWriter(new FileWriter(outtmp));
                        bw.write(Make.aligns);
                        bw.newLine();
                        bw.flush();
                        bw.write(Make.alignt);

                        bw.close();

                    }
                    s1_len=seq[0].length();
                    s1 = seq[0];
                } else {
                    line = br.readLine();
                }
            }

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
