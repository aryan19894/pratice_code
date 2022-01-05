package com.hackerrank.pratice.java.DataStructure;

import java.util.*;

public class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue(events.size(), Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
        List<Student> students = new ArrayList();

        Scanner in;
        for(Iterator var4 = events.iterator(); var4.hasNext(); in.close()) {
            String e = (String)var4.next();
            in = new Scanner(e);
            String event = in.next();
            if (event.equals("ENTER")) {
                String name = in.next();
                float cgpa = in.nextFloat();
                int id = in.nextInt();
                pq.add(new Student(id, name, (double)cgpa));
            } else if (event.equals("SERVED")) {
                pq.poll();
            }
        }

        Student first = (Student)pq.poll();
        if (first == null) {
            return students;
        } else {
            while(first != null) {
                students.add(first);
                first = (Student)pq.poll();
            }

            return students;
        }
    }
}
