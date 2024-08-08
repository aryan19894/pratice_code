package companyOA.Interview.techmojo;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<Employee, Employee> map = new HashMap<Employee, Employee>();

        Employee e1 = new Employee(1, "raj", 40000);
        Employee e2 = new Employee(2, "raj", 40000);
        Employee e3 = new Employee(1, "aryan", 40000);
        Employee e4 = new Employee(1, "raj", 60000);
        Employee e5 = new Employee(1, "raj", 40000);

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e3.hashCode());
        System.out.println(e4.hashCode());
        System.out.println(e5.hashCode());


        map.put(e1, e1);
        map.put(e2, e2);
        map.put(e3, e3);
        map.put(e4, e4);
        map.put(e5, e5);


        System.out.println(map.size());
    }

}
