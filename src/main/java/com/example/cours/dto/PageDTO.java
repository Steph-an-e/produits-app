package com.example.cours.dto;

import java.util.List;

public class PageDTO<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

    public PageDTO() {}

    public PageDTO(List<T> content, int page, int size,
            long totalElements, int totalPages,
            boolean first, boolean last) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
    }

    public List<T> getContent() { return content; }
    public void setContent(List<T> c) { this.content = c; }
    public int getPage() { return page; }
    public void setPage(int p) { this.page = p; }
    public int getSize() { return size; }
    public void setSize(int s) { this.size = s; }
    public long getTotalElements() { return totalElements; }
    public void setTotalElements(long t) { this.totalElements = t; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int t) { this.totalPages = t; }
    public boolean isFirst() { return first; }
    public void setFirst(boolean f) { this.first = f; }
    public boolean isLast() { return last; }
    public void setLast(boolean l) { this.last = l; }
}
