package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页的Bean
 * 
 * @author 陈捷
 * 
 */
public class pageBean {
	@SuppressWarnings("rawtypes")
	private List list;// 存储记录列表
	private String action;// 用来转发action的

	private int totalResult;// 总记录数
	private int totalPage;// 总页数
	private int currentPage;// 当前页
	private int pageSize;// 每页记录数

	@SuppressWarnings("unused")
	private boolean isFirstPage;// 是否为第一页
	@SuppressWarnings("unused")
	private boolean isLastPage;// 是否为最后一页
	@SuppressWarnings("unused")
	private boolean hasPreviousPage;// 是否有上一页
	@SuppressWarnings("unused")
	private boolean hasNextPage;// 是否有下一页

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isFirstPage() {
		return currentPage == 1;// 如果当前页是第一页，则返回true
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return currentPage == totalPage;// 如果当前页等于总页数，则返回true
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return currentPage != 1;// 如果当前页不是第一页，则返回true
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return currentPage != totalPage;// 如果当前页不等于总页数，则返回true
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	/**
	 * 初始化分页信息
	 */
	public void init() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}

	/**
	 * 获取总页数
	 * 
	 * @param pageSize
	 *            分页大小
	 * @param totalResult
	 *            总记录数
	 * @return 总页数
	 */
	public static int getTotalPage(int pageSize, int totalResult) {
		int totalPage = totalResult % pageSize == 0 ? totalResult / pageSize
				: totalResult / pageSize + 1;
		return totalPage;
	}

	/**
	 * 获取当前页的开始记录
	 * 
	 * @param pageSize
	 *            分页大小
	 * @param currentPage
	 *            当前第几页
	 * @return 当前页的开始记录
	 */
	public static int getOffset(int currentPage, int pageSize) {
		int offset = pageSize * (currentPage - 1);
		return offset;
	}

	/**
	 * 计算当前页，如果为0或没有参数，则返回1
	 * 
	 * @param page
	 *            传入的参数(可能为空，即0，则返回1)
	 * @return 当前页
	 */
	public static int getCurrentPage(int page) {
		int currentPage = (page == 0 ? 1 : page);
		return currentPage;
	}

	/**
	 * 获取部分的记录
	 * @param list
	 *            原始记录
	 * @return 部分记录
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAnyResult(List list) {
		if (list == null) {
			return null;
		}
		List arraylist = new ArrayList();
		int offset = getOffset(currentPage, pageSize);
//		System.out.println("当前页:" + currentPage + "  分页大小:" + pageSize
//				+ "  当前记录:" + offset + "  是否有下页:" + hasNextPage + "  是否有上页:"
//				+ hasPreviousPage + "  记录总数" + totalResult + "   总页数:"
//				+ totalPage + "  是否为第一页:" + this.isFirstPage + "  是否为最后一页:"
//				+ this.isLastPage);
		for (int i = offset, j = 0; j < pageSize && i < totalResult; j++, i++) {
			Object obj = list.get(i);
			arraylist.add(obj);
		}

		return arraylist;
	}
}
