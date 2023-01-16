package schoolManagementSystem;

import java.io.*;
import java.util.Scanner;

public class Students {
    String ad,nm,cs,db,fn,age,text,ad1,st1;
    int ch,cnt,p1,p2,p3,p4,p5,p,i,s,y,s1,opt1,j,p6,q,c;
    void student_submenu()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("1->add");
        System.out.println("2->edit");
        System.out.println("3->view");
        System.out.println("4->delete");
        System.out.println("5->exit");
        System.out.println("Enter Your Choice");
        opt1=sc.nextInt();
        switch(opt1)
        {
            case 1:
                add_student();
                break;
            case 2:
                edit_student();
                break;
            case 3:
                view_student();
                break;
            case 4:
                delete_student();
                break;
            case 5:
                break;
        }
    }

    void add_student()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw=new FileWriter("student.txt");
        BufferedWriter br1=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br1);
        Scanner jas=new Scanner(System.in);
        do
        {
            System.out.println("Enter Admin No.");
            ad=br.readLine();
            System.out.println("Enter Name");
            nm=br.readLine();
            System.out.println("Enter Class and Section");
            cs=br.readLine();
            System.out.println("Enter Date Of Birth");
            db=br.readLine();
            System.out.println("Enter Father Name");
            fn=br.readLine();
            System.out.println("Enter Age");
            age=br.readLine();
            pw.println(ad+","+nm+"!"+cs+"."+db+"!!"+fn+":"+age);
            System.out.println("Enter 1 to add more detail");
            int ch =Integer.parseInt(br.readLine());

        }
        while(ch==1);
        pw.close();
    }

    void edit_student()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            cnt++;
        }
        String[] ad =new String[cnt];
        String[] nm =new String[cnt];
        String[] cs =new String[cnt];
        String[] db =new String[cnt];
        String[] fn =new String[cnt];
        String[] age =new String[cnt];
        FileReader fr1=new FileReader("student.txt");
        BufferedReader br2=new BufferedReader(fr1);
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            ad[p]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[p]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            cs[p]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            db[p]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            fn[p]=text.substring(p4+1,p5);
            age[p]=text.substring(p5+1);
            p++;
        }
        System.out.println("Enter The Admission No.");
        ad1=br.readLine();
        for(i=0;i<cnt;i++)
        {
            if(ad1.equals(ad[i]))
            {
                System.out.println("Enter New Name");
                nm[i]=br.readLine();
                System.out.println("Enter new Class and Section");
                cs[i]=br.readLine();
                System.out.println("Enter New Date Of Birth");
                db[i]=br.readLine();
                System.out.println("Enter New Father Name");
                fn[i]=br.readLine();
                System.out.println("Enter New Age");
                age[i]=br.readLine();
            }
        }
        FileWriter fw=new FileWriter("student.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<cnt;i++)
        {
            pw.println(ad[i]+","+nm[i]+"!"+cs[i]+"."+db[i]+"!!"+fn[i]+":"+age[i]);
        }
        pw.close();
    }

    void view_student()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 -> Admin No.");
        System.out.println("2 -> Name");
        System.out.println("3 -> Class");
        System.out.println("4 -> View All");
        System.out.println("5 -> Exit");
        System.out.println("Enter Your Option");
        opt1=Integer.parseInt(br.readLine());
        switch(opt1)
        {
            case 1:
                admin_view();
                break;
            case 2:
                name_view();
                break;
            case 3:
                class_view();
                break;
            case 4:
                view_all();
                break;
            case 5:
                break;
        }
    }

    void admin_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Admin No. ");
        String admin=br.readLine();
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            s=text.indexOf(',');
            st1=text.substring(0,s);
            y=st1.compareTo(admin);
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
        String std1=br.readLine();
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            s=text.indexOf(',');
            s1=text.indexOf('!');
            st1=text.substring(s+1,s1);
            if(st1.equals(std1))
            {
                System.out.println(text);
            }
        }
    }

    void class_view()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the class");
        String std1=br.readLine();
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            s=text.indexOf('!');
            s1=text.indexOf('.');
            st1=text.substring(s+1,s1);
            if(st1.equals(std1))
            {
                System.out.println(text);
            }
        }
    }

    void view_all()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            System.out.println(text);
        }
    }

    void delete_student()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        FileReader fr=new FileReader("student.txt");
        BufferedReader br1=new BufferedReader(fr);
        while((text=br1.readLine())!=null)
        {
            c++;
        }
        String[] ad =new String[c];
        String[] nm =new String[c];
        String[] cs =new String[c];
        String[] db =new String[c];
        String[] fn =new String[c];
        String[] age =new String[c];
        FileReader fr1=new FileReader("student.txt");
        BufferedReader br2=new BufferedReader(fr1);
        while((text=br2.readLine())!=null)
        {
            p1=text.indexOf(",");
            ad[q]=text.substring(0,p1);
            p2=text.indexOf("!");
            nm[q]=text.substring(p1+1,p2);
            p3=text.indexOf(".");
            cs[q]=text.substring(p2+1,p3);
            p4=text.indexOf("!!");
            db[q]=text.substring(p3+1,p4);
            p5=text.indexOf(":");
            fn[q]=text.substring(p4+1,p5);
            age[q]=text.substring(p5+1);
            q++;
        }

        System.out.println("Enter The Admission No.");
        ad1=br.readLine();
        for(i=0;i<c;i++)
        {
            if(ad1.equals(ad[i]))
            {
                for(j=i;j<(c-1);j++)
                {
                    ad[j]=ad[j+1];
                    nm[j]=nm[j+1];
                    cs[j]=cs[j+1];
                    db[j]=db[j+1];
                    fn[j]=fn[j+1];
                    age[j]=age[j+1];
                }
                c--;
            }
        }

        FileWriter fw=new FileWriter("student.txt");
        BufferedWriter br3=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(br3);
        for(i=0;i<c;i++)
        {
            pw.println(ad[i]+","+nm[i]+"!"+cs[i]+"."+db[i]+"!!"+fn[i]+":"+age[i]);
        }
        pw.close();
    }
}
