package com.greenprogrammer.algorithms.greedy;

import com.greenprogrammer.algorithms.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Data
class Item {
    private int value, weight;
}

public class FractionalKnapsack {
    public double fractionalKnapsack(int W, Item arr[], int n) {
        List<Pair<Double, Item>> list = new LinkedList<>();
        double totalValue = 0;
        double weight = 0;
        double remain = W - weight;
        for (Item item : arr) {
            list.add(new Pair<Double, Item>((double) item.getValue() / item.getWeight(), item));
        }
        Collections.sort(list, (o1, o2) -> -o1.getKey().compareTo(o2.getKey()));
        for (Pair<Double, Item> pair : list) {
            if (pair.getValue().getWeight() <= remain) {
                totalValue += pair.getValue().getValue();
                remain -= pair.getValue().getWeight();
            } else {
                totalValue += pair.getKey() * remain;
                remain -= remain;
            }
        }
        return totalValue;

    }

    public static void main(String args[]) {
        FractionalKnapsack knapsack = new FractionalKnapsack();
//        int W = 50;
//        Item[] arr = new Item[3];
//        arr[0] = new Item(60, 10);
//        arr[1] = new Item(100, 20);
//        arr[2] = new Item(120, 30);
        int W = 50;
        Item[] arr = new Item[2];
        arr[0] = new Item(60, 10);
        arr[1] = new Item(100, 20);
        double totalValue = knapsack.fractionalKnapsack(W, arr, arr.length);
        System.out.print(totalValue);

    }
}
