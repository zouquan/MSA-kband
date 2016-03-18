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
public class Console {
    public static void illustrate(){
    System.out.println("The command should be");
    System.out.println("  java -jar MSA.jar inputfile outputfile");
    System.out.println("   (If you donot type inputfile or outputfile, the software will give the default 'input.txt' and 'output.txt' instead.)");

  }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();


        String input = "input.txt";
        String output = "output.txt";
        if(args.length==2){
            input =args[0];
            output=args[1];
        }
        else if(args.length!=0){
            illustrate();
            System.exit(0);
        }
        SetParameter sp = new SetParameter();
        sp.run();

        //-------------����˫���бȶԣ����ѱȶԽ��д����ʱ�ļ�---------------------
        ReadFastaFile rff = new ReadFastaFile(input);
        rff.run();
        //--------------�ȶ����-----------------------------------------------

        int n = ReadFastaFile.name.size();
               int Space[]=new int[ReadFastaFile.s1_len+1];//������������¼��s1�����ս��������϶�����ո�ĸ���
        //����s1��ÿ�����бȶ�ʱ���ո����ĵط�
        for(int i=2;i<=n;i++){
            int Spaceevery[] = new int[ReadFastaFile.s1_len+1];//������������¼��s1���������бȶ�ʱÿһ�θ�����϶�����ո�ĸ���

            try{
                BufferedReader br = new BufferedReader(new FileReader(String.valueOf(i)+".stringtmp"));
                String seq = br.readLine();
                int index = 0;
                for(int j=0;j<seq.length();j++){

                    if(seq.charAt(j)=='-')
                        Spaceevery[index]++;
                    else{
                        if(Spaceevery[index]>Space[index])
                            Space[index]=Spaceevery[index];
                        index++;
                    }
                }
                br.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        }
        //�������

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<Space.length;i++){
            for(int j=0;j<Space[i];j++)
                sb.append('-');
            if(i!=Space.length-1)
             sb.append(ReadFastaFile.s1.charAt(i));
        }
        String s1 = sb.toString();


        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));

            bw.write(ReadFastaFile.name.get(0).toString());
            bw.newLine();
            bw.write(s1);
            bw.newLine();
            bw.flush();
            for(int i=2;i<=n;i++){
                BufferedReader br = new BufferedReader(new FileReader(String.valueOf(i)+".stringtmp"));
                br.readLine();
                String seq = br.readLine();
                br.close();
                AlignTwoSeq ats = new AlignTwoSeq(s1,seq);
                ats.run();
                bw.write(ReadFastaFile.name.get(i-1).toString());
                bw.newLine();
                bw.write(Make.alignt);
                bw.newLine();
                bw.flush();
                br.close();
                File f = new File(String.valueOf(i)+".stringtmp");
                f.delete();

            }
            bw.close();
        }
        catch(Exception ex){
                System.out.println(ex.getMessage());
                System.exit(0);
            }







        //System.out.println(AlignTwoSeq.maxk);//����ȶԵ÷�
        System.out.print("����ʱ��");

        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
