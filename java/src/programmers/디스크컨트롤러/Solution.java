package programmers.디스크컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Job[] jobArr = new Job[jobs.length];
        PriorityQueue<Job> waiting = new PriorityQueue<>(1, new JobComparator());

        for (int i = 0; i < jobs.length; i++) {
            jobArr[i] = new Job(jobs[i][0], jobs[i][1]);
        }


        Arrays.sort(jobArr, (o1, o2) -> {
            if(o1.req == o2.req) {
                return o1.taken - o2.taken;
            }

            return o1.req - o2.req;
        });


        int idx = 1;
        Job now = jobArr[0];
        int time = now.req + now.taken;
        answer += now.taken;
        while(idx < jobs.length || !waiting.isEmpty()) {
            while(idx < jobs.length && jobArr[idx].req < time) {
                waiting.add(jobArr[idx++]);
            }

            now = waiting.poll();

            if(now == null) {
                now = jobArr[idx++];
                time = now.req;
            }

            time += now.taken;
            answer += time - now.req;
        }


        return answer/jobs.length;
    }
}

class Job {
    int req;
    int taken;

    Job(int req, int taken) {
        this.req = req;
        this.taken = taken;
    }
}


class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.taken == o2.taken) {
            return o1.req - o2.req;
        }
        return o1.taken - o2.taken;
    }
}