package com.greenprogrammer.algorithms.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
public class Pair<K, V> {
    private K key;
    private V value;
}
