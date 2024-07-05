package storeApp.product.dto;

public class Pagination {

	private int currentPage;
	private int totalPage;
	
	public Pagination(int currentPage, int totalPage) {
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}

	public Pagination() {
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
