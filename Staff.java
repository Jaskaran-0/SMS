package schoolManagementSystem;

import java.io.*;
import java.util.Scanner;

public class Staff {
    String id,nm,dob,dg,dp,em,mno;
    String text,ad1,st1;
    int cnt,cnt1,p1,p2,p3,p4,p5,p,i,q;
    void teacher_submenu()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1->add");
        System.out.println("2->edit");
        System.out.println("3->view");
        System.out.println("4->delete");
        System.out.println("5->exit");
        System.out.println("Enter Your Choice");
        int opt=sc.nextInt();
        switch(opt)
        {
            case 1:
                add_teacher();
                break;
            case 2:
                edit_teacher();
                break;
            case 3:
                view_teacher();
                break;
            case 4:
                delete_teacher();
                break;
            case 5:
                break;
        }
    }

    void add_teacher()throws IOException
    {
        BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw1=new FileWriter("teacher.txt");
        BufferedWriter br11=new BufferedWriter(fw1);
        PrintWriter pw1=new PrintWriter(br11);
        Scanner js=new Scanner(System.in);
        int ch;
        do
        {
            System.out.println("Enter id");
            id=br1.readLine();
            System.out.println("Enter Name");
            nm=br1.readLine();
            System.out.println("Enter Date of birth");
            dob=br1.readLine();
            System.out.println("Enter Designation");
            dg=br1.readLine();
            System.out.println("Enter department");
            dp=br1.readLine();
            System.out.println("Enter emali-id");
            em=br1.readLine();
            pw1.println(id+","+nm+"!"+dob+"."+dg+"!!"+dp+":"+em);
            System.out.println("Enter 1 for more");
            ch=js.nextInt();
        }
        while(ch==1);
        pw1.close();
    }

    void edit_teacher()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("teacher.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            cnt1++;
        }
        String[] id =new String[cnt1];
        String[] nm =new String[cnt1];
        String[] db =new String[cnt1];
        String[] ds =new String[cnt1];
        String[] dp =new String[cnt1];
        String[] eid =new String[cnt1];
        FileReader fr1=new FileReader("teacher.txt");
        BufferedReader br2=new BufferedReader(fr1);
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            id[p]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[p]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            db[p]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            ds[p]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            dp[p]=text.substring(p4+1,p5);
            eid[p]=text.substring(p5+1);
            p++;
        }
        System.out.println("Enter The Teacher id");
        ad1=br.readLine();
        for(i=0;i<cnt1;i++)
        {
            if(ad1.equals(id[i]))
            {
                System.out.println("Enter new name");
                nm[i]=br.readLine();
                System.out.println("Enter new Date of birth");
                db[i]=br.readLine();
                System.out.println("Enter new Designation");
                ds[i]=br.readLine();
                System.out.println("Enter new department");
                dp[i]=br.readLine();
                System.out.println("Enter new email id");
                eid[i]=br.readLine();
            }
        }
        FileWriter fw=new FileWriter("teacher.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<cnt1;i++)
        {
            pw.println(id[i]+","+nm[i]+"!"+db[i]+"."+ds[i]+"!!"+dp[i]+":"+eid[i]);
        }
        pw.close();
    }

    void view_teacher()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 -> Teacher id");
        System.out.println("2 -> Name");
        System.out.println("3 -> Designation");
        System.out.println("4 -> View All");
        System.out.println("5 -> Exit");
        System.out.println("Enter Your Option");
        int opt1=Integer.parseInt(br.readLine());
        switch(opt1)
        {
            case 1:
                id_view();
                break;
            case 2:
                name_view();
                break;
            case 3:
                designation_view();
                break;
            case 4:
                view_all();
                break;
            case 5:
                break;
        }
    }

    void id_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Teacher id ");
        String id=br.readLine();
        FileReader fr=new FileReader("teacher.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            int s=text.indexOf(',');
            st1=text.substring(0,s);
            int y=st1.compareTo(id);
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
        FileReader fr=new FileReader("teacher.txt");
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

    void designation_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the designation");
        String dsg1=br.readLine();
        FileReader fr=new FileReader("teacher.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            int s=text.indexOf('.');
            int s1=text.indexOf("!!");
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
        FileReader fr=new FileReader("teacher.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            System.out.println(text);
        }
    }

    void delete_teacher()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("teacher.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            cnt++;
        }
        String[] id =new String[cnt];
        String[] nm =new String[cnt];
        String[] db =new String[cnt];
        String[] ds =new String[cnt];
        String[] dp =new String[cnt];
        String[] eid =new String[cnt];
        FileReader fr1=new FileReader("teacher.txt");
        BufferedReader br2=new BufferedReader(fr1);
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            id[q]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[q]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            db[q]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            ds[q]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            dp[q]=text.substring(p4+1,p5);
            eid[q]=text.substring(p5+1);
            q++;
        }

        System.out.println("Enter The teacher id to delete");
        ad1=br.readLine();
        for(i=0;i<cnt;i++)
        {
            if(ad1.equals(id[i]))
            {
                for(int j=i;j<(cnt-1);j++)
                {
                    id[j]=id[j+1];
                    nm[j]=nm[j+1];
                    db[j]=db[j+1];
                    ds[j]=ds[j+1];
                    dp[j]=dp[j+1];
                    eid[j]=eid[j+1];
                }
                cnt--;
            }
        }

        FileWriter fw=new FileWriter("teacher.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<cnt                                                                                                                                                                                                  ;i++)
        {
            pw.println(id[i]+","+nm[i]+"!"+db[i]+"."+ds[i]+"!!"+dp[i]+":"+eid[i]);
        }
        pw.close();
    }

}
