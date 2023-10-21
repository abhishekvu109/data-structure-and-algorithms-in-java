package com.greenprogrammer.algorithms.greedy;

import com.greenprogrammer.algorithms.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
class Job {
    int id, profit, deadline;
}

public class JobSequencingProblem {

    public int[] JobScheduling(Job arr[], int n) {
        int total_profit = 0, total_jobs = 0;
        List<Pair<Integer, Integer>> list = new LinkedList<>();
        Comparator<Integer> integerComparator = Comparator.reverseOrder();
        Arrays.stream(arr).forEach(job -> {
            list.add(new Pair<>(job.profit, job.deadline));
        });
        Collections.sort(list, (p1, p2) -> {
            return -p1.getKey().compareTo(p2.getKey());
        });
        int num = 1;
        for (Pair<Integer, Integer> pair : list) {
            if (pair.getValue() >= num) {
                total_jobs += 1;
                total_profit += pair.getKey();
            }
            num += 1;
        }
        int[] output = new int[2];
        output[0] = total_jobs;
        output[1] = total_profit;
        return output;
    }

    public static void main(String args[]) {
        Job[] jobs = new Job[4];
        jobs[0] = new Job(1, 20, 4);
        jobs[1] = new Job(2, 10, 1);
        jobs[2] = new Job(3, 40, 1);
        jobs[3] = new Job(4, 30, 1);

//        Job[] jobs = new Job[5];
//        jobs[0] = new Job(1, 100, 2);
//        jobs[1] = new Job(2, 19, 1);
//        jobs[2] = new Job(3, 27, 2);
//        jobs[3] = new Job(4, 25, 1);
//        jobs[4] = new Job(5, 15, 1);
        JobSequencingProblem problem = new JobSequencingProblem();
        System.out.println(Arrays.toString(problem.JobScheduling(jobs, 4)));
    }
}
