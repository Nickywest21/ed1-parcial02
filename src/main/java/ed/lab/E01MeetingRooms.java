package ed.lab;

import java.util.*;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals.isEmpty()) {
            return 0;
        }

        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        Queue<Integer> minHeap = new PriorityQueue<>();

        for (MeetingInterval meeting : meetingIntervals) {
            if (!minHeap.isEmpty() && meeting.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(meeting.endTime());
        }

        return minHeap.size();
    }
}


