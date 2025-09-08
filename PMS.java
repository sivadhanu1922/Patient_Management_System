import java.util.*;
class Patient
{
    private int id;
    private String name;
    private int age;
    private String disease;

public Patient(int id,String name,int age,String disease)
{
    this.id=id;
    this.name=name;
    this.age=age;
    this.disease=disease;
}
//getters & setters
public int getId(){return id;}
public String getName(){return name;}
public int getAge(){ return age;}
public String getDisease(){ return disease;}

public void setName(String name){this.name=name;}
public void setAge(int age){this.age=age;}
public void setDisease(String disease){ this.disease=disease;}

@Override
public String toString()
{
    return " ---  Patient Id: "+id+"| Name :"+name+"| Age :"+age+"| Disease :"+disease;
}
}
public class PMS
{
    private static ArrayList<Patient> pat=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);


public static void main(String[]args)
{
    int choice;
    do
    {
        System.out.println("-------Patient Management System-------");
         System.out.println("1. Add Patient Details ");
          System.out.println("2. List All Patient ");
           System.out.println("3. Search Patient ");
            System.out.println("4. Update details ");
             System.out.println("5. Delete details");
              System.out.println("6. Exit ");
               System.out.println("Enter your choice ");
               choice =sc.nextInt();
     switch(choice)
     {
        case 1->addpatient();
        case 2->listpatient();
        case 3->searchpatient();
        case 4->update();
        case 5->delete();
        case 6->System.out.println("---Exiting---");
        default->System.out.println("---Invalid Choice---");
     }
    }while(choice!=6);
}

private static void addpatient()
{
    System.out.println("Enter ID");
    int id=sc.nextInt();
    sc.nextLine();
    System.out.println("Enter Name");
    String name=sc.nextLine();
    System.out.println("Enter Age");
    int age=sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the disease name ");
    String disease=sc.nextLine();
pat.add(new Patient(id,name,age,disease));
System.out.println("------ADDED SUCCESSFULLY------");
}


private static void listpatient()
{
    if(pat.isEmpty())
    {
     System.out.println("------No patient Found------ ");
    }
    else 
    {
     for(Patient p:pat)
     {
      System.out.println(p);
     }
    }
}


private static void searchpatient()
{
    System.out.println("Enter the patient ID");
    int id=sc.nextInt();
    for(Patient p:pat)
    {
        if(p.getId()==id)
        {
            System.out.println("   patient Found  "+p);
            return;
        }
    }
    System.out.println("------Not Found------");
}

private static void update()
{
    System.out.println("Enter ID ");
    int id=sc.nextInt();
    sc.nextLine();
    for(Patient p:pat)
    {
        if(p.getId()==id)
        {
            System.out.println("Enter  new Name");
            p.setName(sc.nextLine());
            System.out.println("Enter new Age");
            p.setAge(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter  new disease");
            p.setDisease(sc.nextLine());
            return;
        }
    }
System.out.println("------UPDATED SUCCESSFULLY------");
}

private static void delete()
{
    System.out.println("Enter ID");
    int id=sc.nextInt();
    for(Patient p:pat)
    {
        if(p.getId()==id)
        {
            pat.remove(p);
            System.out.println("------Deleted successfully------");
            return;
        }
    }
   System.out.println("------ID Not Found------");
}
}
