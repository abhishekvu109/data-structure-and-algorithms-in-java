package com.greenprogrammer.algorithms.util;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@ToString
@EqualsAndHashCode
public class Pair<K, V> {
    private K key;
    private V value;
}
