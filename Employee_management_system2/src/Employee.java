import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;

//Create variable to get Attributes of employees **********************************
class Employee implements Serializable {
    int id;// add variables
    String emp_name;//  add variables
    int salary;//  add variables
    String job_roles; // add variables

    Employee(int id, String emp_name, int salary, String job_roles){
        this.id = id;
        this.emp_name = emp_name;
        this.salary = salary;
        this.job_roles = job_roles;
    }
    public String toString(){
        return "id is :"+id+"/ Name is :"+emp_name+"/ Salary is :"+salary+"/ Job Role is :"+job_roles; // return my Employee attributes
    }

}


class EmployeeManagement{
    public static void main(String[] args)throws Exception {
        int choice = -1;
        Scanner s = new Scanner(System.in); // this for integer data
        Scanner s1 = new Scanner(System.in);// this for String data
        File file = new File("employee.txt");
        ArrayList<Employee> al = new ArrayList<Employee>(); // ArrayList object make
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li = null;

        if(file.isFile()){
            ois = new ObjectInputStream(new FileInputStream(file));
            al = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }

        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("0.EXIT");
            System.out.print("Enter Your Choice : ");
            choice = s.nextInt();

            switch (choice){ // switch case statement for choices run
                case 1: // case one use for employee attributes add
                    System.out.println("Enter How many employees you want : ");
                    int n = s.nextInt();// n variable is needs of employees
                    for (int i=0;i<n;i++) {  // used for get employees

                        System.out.println("Enter Employee id : ");
                        int id = s.nextInt();

                        System.out.println("Enter Employee Employee Name  : ");
                        String emp_name = s1.nextLine();

                        System.out.println("Enter Employee salary : ");
                        int salary = s.nextInt();

                        System.out.println("Enter Employee job_roles  : ");
                        String job_roles = s1.nextLine();

                        al.add(new Employee(id, emp_name, salary, job_roles)); // use for add Employees attributes


                    }
                    try {
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(al);
                        oos.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();
                        System.out.println("------------------------K&D Music-------------------------------");
                        li = al.listIterator();
                        while (li.hasNext())
                            System.out.println(li.next());
                        System.out.println("------------------------K&D Music-------------------------------");
                    }else {
                        System.out.println("File not Exists...!");
                    }
                    break;
                case 3:
                    if(file.isFile()) {
                        ois = new ObjectInputStream(new FileInputStream(file));
                        al = (ArrayList<Employee>) ois.readObject();
                        ois.close();

                        boolean found = false;
                        System.out.println("Enter Employee ID to Search :");
                        int id = s.nextInt();
                        System.out.println("------------------------K&D Music-------------------------------");
                        li = al.listIterator();
                        while (li.hasNext()) {
                            Employee e = (Employee) li.next();
                            if (e.id == id) {
                                System.out.println(e);
                                found = true;
                            }
                        }
                        if (!found)
                            System.out.println("Record Not Found...!");

                        System.out.println("------------------------K&D Music-------------------------------");
                    }else {
                        System.out.println("File not Exists...!");
                    }
                    break;

            }

        }while (choice!=0);
    }
}
