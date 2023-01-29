import com.sun.javafx.stage.FocusUngrabEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;



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
        Scanner s2 = new Scanner(System.in);
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


        System.out.print(" Enter user name => ");
        String userName = s2.nextLine();

        System.out.print(" Enter password => ");
        String password = s2.nextLine();

        if ("hasaranga".equals(userName) && "ravindu123".equals(password)) {


            do {
                System.out.println("***********************Welcome to K&D Music***********************");
                System.out.println("1.INSERT");
                System.out.println("2.DISPLAY");
                System.out.println("3.SEARCH");
                System.out.println("4.DELETE");
                System.out.println("5.UPDATE");
                System.out.println("6.SORT By Employee Salary - ascending order");
                System.out.println("7.SORT By Employee Salary - descending order");
                System.out.println("0.EXIT");
                System.out.print("Enter Your Choice : ");
                choice = s.nextInt();

                switch (choice) { // switch case statement for choices run
                    case 1: // case one use for employee attributes add
                        System.out.println("Enter How many employees you want : ");
                        int n = s.nextInt();// n variable is needs of employees
                        for (int i = 0; i < n; i++) {  // used for get employees

                            int id = ThreadLocalRandom.current().nextInt(0, 100);
                                // int id = ThreadLocalRandom.current().nextInt();
                                // System.out.println(Math.abs(Integer.MIN_VALUE));


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
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a1 = s2.nextLine();
                        break;
                    case 2:
                        if (file.isFile()) {
                            ois = new ObjectInputStream(new FileInputStream(file));
                            al = (ArrayList<Employee>) ois.readObject();
                            ois.close();
                            System.out.println("------------------------K&D Music-------------------------------");
                            li = al.listIterator();
                            while (li.hasNext())
                                System.out.println(li.next());
                            System.out.println("------------------------K&D Music-------------------------------");
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a2 = s2.nextLine();
                        break;
                    case 3:
                        if (file.isFile()) {
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
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a3 = s2.nextLine();
                        break;
                    case 4:
                        if (file.isFile()) {
                            ois = new ObjectInputStream(new FileInputStream(file));
                            al = (ArrayList<Employee>) ois.readObject();
                            ois.close();

                            boolean found = false;
                            System.out.println("Enter Employee ID to Delete :");
                            int id = s.nextInt();
                            System.out.println("------------------------K&D Music-------------------------------");
                            li = al.listIterator();
                            while (li.hasNext()) {
                                Employee e = (Employee) li.next();
                                if (e.id == id) {

                                    System.out.println("Are you sure you want to delete this Record![Type yes or no here]");
                                    String yes = s2.nextLine();
                                    if ("yes".equals(yes)) {
                                        li.remove();
                                        found = true;

                                    } else {
                                        System.out.println("record not deleted");

                                    }
                                }
                            }
                            if (found) {
                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(al);
                                oos.close();
                                System.out.println("Record Deleted Successfully...!");
                            } else {
                                System.out.println("Record Not Found or not accept to delete...!");
                            }

                            System.out.println("------------------------K&D Music-------------------------------");
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a5 = s2.nextLine();
                        break;

                    case 5:
                        if (file.isFile()) {
                            ois = new ObjectInputStream(new FileInputStream(file));
                            al = (ArrayList<Employee>) ois.readObject();
                            ois.close();

                            boolean found = false;
                            System.out.println("Enter Employee ID to Update :");
                            int id = s.nextInt();
                            System.out.println("------------------------K&D Music-------------------------------");
                            li = al.listIterator();
                            while (li.hasNext()) {
                                Employee e = (Employee) li.next();
                                if (e.id == id) {


                                    System.out.println("Enter new Employee name :");
                                    String emp_name = s1.nextLine();
                                    System.out.println("Enter new Salary :");
                                    int salary = s.nextInt();
                                    System.out.println("Enter new job_roles :");
                                    String job_roles = s1.nextLine();
                                    System.out.println("Are you sure you want to Update this Record![Type yes or no here]");
                                    String yes = s2.nextLine();
                                    if ("yes".equals(yes)) {
                                        li.set(new Employee(id, emp_name, salary, job_roles));
                                        found = true;

                                    } else {
                                        System.out.println("record not Updated");

                                    }
                                }
                            }
                            if (found) {
                                oos = new ObjectOutputStream(new FileOutputStream(file));
                                oos.writeObject(al);
                                oos.close();
                                System.out.println("Record Updated Successfully...!");
                            } else {
                                System.out.println("Record Not Found or not accept to Update...!");
                            }

                            System.out.println("------------------------K&D Music-------------------------------");
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a6 = s2.nextLine();
                        break;
                    case 6:
                        if (file.isFile()) {
                            ois = new ObjectInputStream(new FileInputStream(file));
                            al = (ArrayList<Employee>) ois.readObject();
                            ois.close();

                            Collections.sort(al, new Comparator<Employee>() {
                                public int compare(Employee e1, Employee e2) {
                                    return e1.salary - e2.salary;
                                }
                            });

                            System.out.println("------------------------K&D Music-------------------------------");
                            li = al.listIterator();
                            while (li.hasNext())
                                System.out.println(li.next());
                            System.out.println("------------------------K&D Music-------------------------------");
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a7 = s2.nextLine();
                        break;

                    case 7:
                        if (file.isFile()) {
                            ois = new ObjectInputStream(new FileInputStream(file));
                            al = (ArrayList<Employee>) ois.readObject();
                            ois.close();

                            Collections.sort(al, new Comparator<Employee>() {
                                public int compare(Employee e1, Employee e2) {
                                    return e2.salary - e1.salary;
                                }
                            });

                            System.out.println("------------------------K&D Music-------------------------------");
                            li = al.listIterator();
                            while (li.hasNext())
                                System.out.println(li.next());
                            System.out.println("------------------------K&D Music-------------------------------");
                        } else {
                            System.out.println("File not Exists...!");
                        }
                        System.out.println("Back to Menu [Press any key and Enter]");
                        String a8 = s2.nextLine();
                        break;

                }

            } while (choice != 0);
        }else {
            System.out.println("UserName OR Password Incorrect");

        }
    }
}
