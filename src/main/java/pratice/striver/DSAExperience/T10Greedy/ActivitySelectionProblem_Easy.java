package pratice.striver.DSAExperience.T10Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ActivitySelectionProblem_Easy {
    //[Optimal] O(nlogn), O(n) - sort on basis of finish time, check each activity via comparing
    // with previous activity finish time and current start time  1by1.
    public static void printMaxActivities(int s[], int f[], int n) {
        ArrayList<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++)
            activities.add(new Activity(s[i], f[i]));

        Collections.sort(activities, (a, b) -> (a.finish - b.finish));

        System.out.println(activities.get(0));
        int lastFinish = activities.get(0).finish;
        for (int i = 1; i < n; i++) {
            if (lastFinish <= activities.get(i).start) {
                System.out.println(activities.get(i));
                lastFinish = activities.get(i).finish;
            }
        }

    }

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 8, 5};
        int f[] = {2, 5, 6, 7, 9, 9};
        int n = s.length;

        printMaxActivities(s, f, n);
    }

}

class Activity {
    int start, finish;

    // Constructor
    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}