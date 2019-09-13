package cn.ibase.beta.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @param <T>
 */
public class DataPage<T> extends Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer rows;

	private Integer total;

	private Integer page;

	private String orderStr;

	private String sort;

	private String order;

	private Object queryObj;

	private List<T> data;

	private Object sumInfo; // 统计信息

	@JsonIgnore
	public String getOrderStr() {
		orderStr = "";
		if (!org.springframework.util.StringUtils.isEmpty(order)) {
			String[] orders = order.split(",");
			String[] sorts = sort.split(",");
			for (Integer i = 0; i < sorts.length; i++) {
				orderStr += sorts[i] + " " + orders[i] + ", ";
			}
			orderStr = orderStr.endsWith(", ") ? orderStr.substring(0, orderStr.length() - 2) : orderStr;
		}
		return orderStr;
	}

	@JsonIgnore
	public Integer getPageSize() {
		return rows;
	}

	public List<T> getRows() {
		return data;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@JsonIgnore
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@JsonIgnore
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@JsonIgnore
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@JsonIgnore
	public Object getQueryObj() {
		return queryObj;
	}

	public void setQueryObj(Object queryObj) {
		this.queryObj = queryObj;
	}

	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Object getSumInfo() {
		return sumInfo;
	}

	public void setSumInfo(Object sumInfo) {
		this.sumInfo = sumInfo;
	}

	@Override
	public String toString() {
		return "DataPage [rows=" + rows + ", total=" + total + ", page=" + page + ", orderStr=" + orderStr + ", sort="
				+ sort + ", order=" + order + ", queryObj=" + queryObj + ", data=" + data + "]";
	}
}
