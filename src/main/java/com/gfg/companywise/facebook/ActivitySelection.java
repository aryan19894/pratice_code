package com.gfg.companywise.facebook;

import com.common.Out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
    static class Activity {
        private int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static int activitySelection(int start[], int end[], int n) {
        int result = 1;
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++)
            activities.add(new Activity(start[i], end[i]));

        Collections.sort(activities, (a, b) -> (a.end - b.end));
        int lastEnd = activities.get(0).end;
        for (int i = 1; i < n; i++) {
            if (lastEnd < activities.get(i).start) {
                result++;
                lastEnd = activities.get(i).end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int start[] = {8, 1, 1, 5, 7};
        int end[] = {10, 4, 8, 9, 10};
        int n = 5;
        Out.print(activitySelection(start, end, n));
    }
}
