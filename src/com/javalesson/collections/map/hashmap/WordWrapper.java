package com.javalesson.collections.map;

import java.util.Objects;

public class WordWrapper implements Comparable<WordWrapper> {
    private final String word;
    private final  Integer count;

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    public WordWrapper(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordWrapper wordWrap) {
        if(count<wordWrap.getCount()){
            return 1;
        }
        if(count>wordWrap.getCount()){
            return -1;
        }
        return word.compareTo(wordWrap.getWord());
    }

    @Override
    public String toString() {
        return word+" > "+count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWrapper that = (WordWrapper) o;
        return Objects.equals(word, that.word) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}
