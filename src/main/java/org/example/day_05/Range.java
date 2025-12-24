package org.example.day_05;

public record Range(long start, long end) {
    boolean contains(long id) {
        return id >= start && id <= end;
    }
}
