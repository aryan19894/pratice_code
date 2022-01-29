package com.striver.DSAExperience.T5Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsInOneRoom_Easy {
    //[Optimal] O(nlogn), O(n) - sort on basis of end time, check each meeting 1by1.
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++)
            meetings.add(new Meeting(start[i], end[i], i + 1));

        MeetingC comp = new MeetingC();
        Collections.sort(meetings, comp);

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meetings.get(0).pos);
        int limit = meetings.get(0).end;

        for (int i = 0; i < n; i++) {
            if (meetings.get(i).start > limit) {
                limit = meetings.get(i).end;
                answer.add(meetings.get(i).pos);
            }
        }
        return answer.size();
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        int ans = maxMeetings(start, end, start.length);
        System.out.println(ans);
    }
}

class Meeting {
    int start, end, pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingC implements Comparator<Meeting> {

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if (o1.pos < o2.pos)
            return -1;
        return 1;
    }
}