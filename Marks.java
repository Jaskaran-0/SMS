package schoolManagementSystem;

import java.io.*;
import java.util.Scanner;

public class Marks {
    int cnt,cnt1,p1,p2,p3,p4,p5,p6,p7,p8,i,q;
    String ad,nm,cl,py,ch,dob,text,ad1,st1,mt,en,co;
    void marks_submenu()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1->add marks record");
        System.out.println("2->edit marks record");
        System.out.println("3->view marks record");
        System.out.println("4->delete record");
        System.out.println("5->exit");
        System.out.println("Enter Your Choice");
        int opt=sc.nextInt();
        switch(opt)
        {
            case 1:
                add();
                break;
            case 2:
                edit();
                break;
            case 3:
                view();
                break;
            case 4:
                delete();
                break;
            case 5:
                break;
        }
    }

    void add()throws IOException
    {
        BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw1=new FileWriter("marks.txt");
        BufferedWriter br11=new BufferedWriter(fw1);
        PrintWriter pw1=new PrintWriter(br11);
        Scanner js=new Scanner(System.in);
        int cm;
        do
        {
            System.out.println("Enter admission number");
            ad=br1.readLine();
            System.out.println("Enter Name");
            nm=br1.readLine();
            System.out.println("Enter Date of birth");
            dob=br1.readLine();
            System.out.println("Enter class-section");
            cl=br1.readLine();
            System.out.println("Enter physics marks");
            py=br1.readLine();
            System.out.println("Enter chemistry marks");
            ch=br1.readLine();
            System.out.println("Enter maths marks");
            mt=br1.readLine();
            System.out.println("Enter english marks");
            en=br1.readLine();
            System.out.println("Enter computer marks");
            co=br1.readLine();

            pw1.println(ad+","+nm+"!"+dob+"."+cl+"!!"+py+":"+ch+"@"+mt+"#"+en+"$"+co);
            System.out.println("Enter 1 for more");
            cm=js.nextInt();
        }
        while(cm==1);
        pw1.close();
    }

    void edit()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            cnt1++;
        }
        String[] ad =new String[cnt1];
        String[] nm =new String[cnt1];
        String[] db =new String[cnt1];
        String[] cs =new String[cnt1];
        String[] py =new String[cnt1];
        String[] ch =new String[cnt1];
        String[] mt =new String[cnt1];
        String[] en =new String[cnt1];
        String[] co =new String[cnt1];

        FileReader fr1=new FileReader("marks.txt");
        BufferedReader br2=new BufferedReader(fr1);int pt=0;
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            ad[pt]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[pt]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            db[pt]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            cs[pt]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            py[pt]=text.substring(p4+1,p5);
            p6=text.indexOf("@");
            ch[pt]=text.substring(p5+1,p6);
            p7=text.indexOf("#");
            mt[pt]=text.substring(p6+1,p7);
            p8=text.indexOf("$");
            en[pt]=text.substring(p7+1,p8);
            co[pt]=text.substring(p8+1);
            pt++;
        }
        System.out.println("Enter The addmision no.");
        ad1=br.readLine();
        for(i=0;i<cnt1;i++)
        {
            if(ad1.equals(ad[i]))
            {
                System.out.println("Enter new name");
                nm[i]=br.readLine();
                System.out.println("Enter new Date of birth");
                db[i]=br.readLine();
                System.out.println("Enter new class and section");
                cs[i]=br.readLine();
                System.out.println("Enter new physics marks");
                py[i]=br.readLine();
                System.out.println("Enter new chemistry marks");
                ch[i]=br.readLine();
                System.out.println("Enter new maths marks");
                mt[i]=br.readLine();
                System.out.println("Enter new english marks");
                en[i]=br.readLine();
                System.out.println("Enter new computer marks");
                co[i]=br.readLine();
            }
        }
        FileWriter fw=new FileWriter("marks.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<cnt1;i++)
        {
            pw.println(ad+","+nm+"!"+dob+"."+cl+"!!"+py+":"+ch+"@"+mt+"#"+en+"$"+co);
        }
        pw.close();
    }

    void view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 -> Addmision number");
        System.out.println("2 -> Name");
        System.out.println("3 -> Date of birth");
        System.out.println("4 -> View All");
        System.out.println("5 -> Exit");
        System.out.println("Enter Your Option");
        int opt1=Integer.parseInt(br.readLine());
        switch(opt1)
        {
            case 1:
                ad_view();
                break;
            case 2:
                name_view();
                break;
            case 3:
                dob_view();
                break;
            case 4:
                view_all();
                break;
            case 5:
                break;
        }
    }

    void ad_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Addmission no. ");
        String ad=br.readLine();
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            int s=text.indexOf(',');
            st1=text.substring(0,s);
            int y=st1.compareTo(ad);
            if(y==0)
            {
                System.out.println(text);
            }
        }
        br1.close();
    }

    void name_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name");
        String tnm1=br.readLine();
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            int s=text.indexOf(',');
            int s1=text.indexOf('!');
            st1=text.substring(s+1,s1);
            if(st1.equals(tnm1))
            {
                System.out.println(text);
            }
        }
    }

    void dob_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Date of birth");
        String dsg1=br.readLine();
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            int s=text.indexOf('!');
            int s1=text.indexOf(".");
            st1=text.substring(s+1,s1);
            if(st1.equals(dsg1))
            {
                System.out.println(text);
            }
        }
    }

    void view_all()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            System.out.println(text);
        }
    }

    void delete()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("marks.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            cnt++;
        }
        String[] ad =new String[cnt];
        String[] nm =new String[cnt];
        String[] db =new String[cnt];
        String[] cs =new String[cnt];
        String[] py =new String[cnt];
        String[] ch =new String[cnt];
        String[] mt =new String[cnt];
        String[] en =new String[cnt];
        String[] co =new String[cnt];
        FileReader fr1=new FileReader("marks.txt");
        BufferedReader br2=new BufferedReader(fr1);
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            ad[q]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[q]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            db[q]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            cs[q]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            py[q]=text.substring(p4+1,p5);
            p6=text.indexOf("@");
            ch[q]=text.substring(p5+1,p6);
            p7=text.indexOf("#");
            mt[q]=text.substring(p6+1,p7);
            p8=text.indexOf("$");
            en[q]=text.substring(p7+1,p8);
            co[q]=text.substring(p8+1);
            q++;
        }

        System.out.println("Enter The addmission no. to delete");
        ad1=br.readLine();
        for(i=0;i<cnt;i++)
        {
            if(ad1.equals(ad[i]))
            {
                for(int j=i;j<(cnt-1);j++)
                {
                    ad[j]=ad[j+1];
                    nm[j]=nm[j+1];
                    db[j]=db[j+1];
                    cs[j]=cs[j+1];
                    py[j]=py[j+1];
                    ch[j]=ch[j+1];
                    mt[j]=mt[j+1];
                    en[j]=en[j+1];
                    co[j]=co[j+1];
                }
                cnt--;
            }
        }

        FileWriter fw=new FileWriter("marks.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<cnt ;i++)                                                                                                                                                                                                      {
            pw.println(ad+","+nm+"!"+dob+"."+cl+"!!"+py+":"+ch+"@"+mt+"#"+en+"$"+co);
        }
        pw.close();
    }
}
