package com.htf.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageInfoResult<T> implements Serializable{

	private static final long serialVersionUID = -6070762997841115190L;
	
	private List<T> content;
	
	private  int size = 10;
    private  int number = 1;  //  page number
    private long totalElements;  // 总记录数
    private long totalPages; // 总页数
	
    private  long numberOfElements;

    private  boolean last = false;
    private  boolean first = false;
    
    public PageInfoResult(){}

    public PageInfoResult(long total){
        this.caclutePageData(total,this.size,this.number);
    }


    public PageInfoResult(long total, int pageSize, int pageNum){
        this.caclutePageData(total,pageSize,pageNum);
    }


    private  void  caclutePageData(long total,int pageSize,int pageNum){
        this.totalElements = total;
        this.size =   pageSize < 0 ? 10 : pageSize;
        this.number = pageNum < 0 ? 1: pageNum;
        this.totalPages = (long)Math.ceil((double) total/pageSize);
        if (pageNum == 1 ) this.first = true;
        if (pageNum == totalPages)  this.last = true;
    }


    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.numberOfElements = content.size();
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    /**
     * 复制 spring data 的分页属性
     * @param page
     */
    public void transFromToPageInfoResult(Page page){
        if (page == null)
            throw  new RuntimeException("page is null when transFromToPageInfoReslut");
        this.setTotalPages(page.getTotalPages());
        this.setTotalElements(page.getTotalElements());
        this.setSize(page.getSize());
        this.setNumber(page.getNumber());
        this.setFirst(page.isFirst());
        this.setLast(page.isLast());
        this.setNumberOfElements(page.getNumberOfElements());
    }
}
