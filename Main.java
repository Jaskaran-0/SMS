package schoolManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Students st=new Students();
        Staff st1= new Staff();
        Attendence st2=new Attendence();
        Marks st3=new Marks();
        int opt;
        do
        {
            System.out.println("1-> Student's Detail,2-> Teachers details, 3-> Attendence details,4-> Marks Details,7-> Exit");
            System.out.println("Enter The Option");
            opt=Integer.parseInt(br.readLine());
            switch(opt)
            {
                case 1:
                    st.student_submenu();
                    break;
                case 2:
                    st1.teacher_submenu();
                    break;
                case 3:
                    st2.attendence_submenu();
                    break;
                case 4:
                    st3.marks_submenu();
                    break;
            }
        }while(opt!=7);
    }
}
