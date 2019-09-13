package cn.ibase.beta.common.dto;

/**
 * 数据对象
 * @param <T>
 */
public class FormResult<T> extends Result {

	private T data;
	private T otherData;
	private Integer resultCount;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public T getOtherData() {
		return otherData;
	}

	public void setOtherData(T otherData) {
		this.otherData = otherData;
	}

	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

}
