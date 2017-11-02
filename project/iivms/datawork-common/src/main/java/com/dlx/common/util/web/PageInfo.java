package com.dlx.common.util.web;

public class PageInfo  {

	public final static Object[] EMPTY = new Object[0];

	private int allCount = 0;// 总记录数

	private Object[] elements = EMPTY;// 记录

	private int startIndex = -1; // 开始记录索引

	private int endIndex = -1;// 结束记录索引，最后一页记录数可能小于每页显示数

	private int count = 0;// 每页显示数

	/**
	 * 
	 * 记录总数一般大于每页显示数
	 * 
	 * @param allCount
	 *            总记录数
	 * @param keys
	 *            记录
	 * @param startIndex
	 *            开始记录索引
	 * @param endIndex
	 *            结束记录索引
	 * @param count
	 *            每页显示数
	 */
	public PageInfo(int allCount, Object[] keys, int startIndex, int endIndex,
			int count) {
		this.allCount = allCount;
		this.elements = keys;
		if (startIndex >= 0) {
			this.startIndex = startIndex;
		}
		this.endIndex = endIndex;
		this.count = count;
	}

	/**
	 * 记录总数大于每页显示数
	 * 
	 * @param allCount
	 *            总记录数
	 * @param keys
	 *            记录
	 */
	public PageInfo(int allCount, Object[] keys) {
		this.allCount = allCount;
		this.elements = keys;
		this.endIndex = keys.length;
	}

	/**
	 * 空构造函数
	 * 
	 */
	public PageInfo() {

	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	/**
	 * 重置
	 * 
	 */
	public void reset() {
		elements = EMPTY;
		startIndex = -1;
		endIndex = -1;
		count = 0;
		allCount = 0;

	}

	public int getSize() {
		return elements.length;
	}

	public Object[] getKeys() {
		return elements;
	}

	public void setKeys(Object[] keys) {
		this.elements = keys;
	}

	public int getCount() {
		return count;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
}
