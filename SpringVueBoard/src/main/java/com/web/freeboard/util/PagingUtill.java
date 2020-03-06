package com.web.freeboard.util;

public class PagingUtill {
	private int nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	// 현제 페이지, 시작페이지, 끝페이지, 게시글 총갯수, 페이지당 글갯수, 마지막 페이지
	
	private int cntPage = 5;
	
	public PagingUtill() {
	}
	
	public PagingUtill(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
//		마지막 페이지 계산 = 총게시글 / 페이지당 글갯수
		calLastPage(getTotal(),getCntPerPage());
//		시작 페이지 , 끝페이지 계산
		calStartEndPage(getNowPage(),cntPage);
//		쿼리에 적용 값
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	public void calLastPage(int total,int CntPerPage) {
		setLastPage((int) Math.ceil((double)total/CntPerPage));
	}
	
	public void calStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage/(double)cntPage))*cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCntPerPage() {
		return cntPerPage;
	}
	public void setCntPerPage(int cntPerPage) {
		this.cntPerPage = cntPerPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCntPage() {
		return cntPage;
	}
	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}
	
	
	@Override
	public String toString() {
		return "PagingUtill [nowPage=" + nowPage + ", startPage=" + startPage + ", endPage=" + endPage + ", total="
				+ total + ", cntPerPage=" + cntPerPage + ", lastPage=" + lastPage + ", start=" + start + ", end=" + end
				+ ", cntPage=" + cntPage + "]";
	}
	
	
}
