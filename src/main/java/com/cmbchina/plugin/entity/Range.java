package com.cmbchina.plugin.entity;

/**
 * @description: some desc
 * @author: IT006901
 * @date: 2026/3/5
 */
public class Range {

    private int min;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
