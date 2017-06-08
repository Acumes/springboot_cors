package com.htf.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Sort;

import com.htf.exception.BusinessCheckException;

public class PageRequest {

	
	private  int pageSize = 10;
    private  int pageNum = 1;

    private String searchKeyWord;
    private OrderItem orderItem;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSearchKeyWord() {
        return searchKeyWord;
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    /**
     * 加上asc或desc, 拼接成sql中使用的排序语句，如果失败则返回null
     * @param request
     * @return
     */
    public static String getOrderSql(PageRequest request){
    	if(request == null || request.getOrderItem() == null)
    		return null;
    	String orderBy = request.getOrderItem().getColumnName();
    	if(orderBy == null || orderBy.isEmpty())
    		return null;
    	if(request.getOrderItem().isAsc())
    		return orderBy.concat(" asc");
    	else
    		return orderBy.concat(" desc");
    }

//    public  Sort getJpaSort(){
//        Sort sort = null;
//        if (this.orderItem != null){
//            String orderType = this.orderItem.isAsc() ? "ASC": "DESC";
//            sort = new Sort(Sort.Direction.valueOf(orderType),this.orderItem.getColumnName());
//        }
//        return  sort;
//    }

    public  Sort getJpaSort(Class c){
        Sort sort = null;
        if (this.orderItem != null){
            this.checkOrderColumnName(this.getOrderItem().getColumnName(),c);
            String orderType = this.orderItem.isAsc() ? "ASC": "DESC";
            sort = new Sort(Sort.Direction.valueOf(orderType),this.orderItem.getColumnName());
        }
        return  sort;
    }

    public  Sort getJpaSort(String columnName){
        Sort sort = null;
        if (this.orderItem != null){
            String orderType = this.orderItem.isAsc() ? "ASC": "DESC";
            sort = new Sort(Sort.Direction.valueOf(orderType),columnName);
        }
        return  sort;
    }

    public String getQueryWord(){
        return  this.searchKeyWord == null ? "":this.searchKeyWord;
    }

    public void  checkOrderColumnName(String columnName,Class c){
        Field[] fields = c.getDeclaredFields(); 
        Map<String,String> temp  = new HashMap<String, String>();
        for (Field field : fields) {
            temp.put(field.getName(),"");
        }
        if (!temp.containsKey(columnName))
            throw  new BusinessCheckException("非法排序字段"+columnName);
    }
}
