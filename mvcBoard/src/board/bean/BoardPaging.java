package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage;
	private int pageBlock; // pageBlock = 3 {[1][2][3]} 
	private int pageSize; //1페이지 당 5개씩 
	private int totalArticle;
	private StringBuffer pagingHTML;
	//String: 한 번 만들어진 문자열은 편집 불가.
	//==>  StringBuffer.append() or StringBuilder 사용 !
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		int totalPage = (totalArticle+pageSize-1) / pageSize;
		int startPage = (currentPage-1)/pageBlock * pageBlock +1; 
		int endPage = startPage + pageBlock -1;
		if(endPage > totalPage) endPage = totalPage;
		if(startPage > pageBlock) pagingHTML.append("[ <a id='paging' href='boardList.do?pg="+ (startPage-1) +"'> 이전 </a> ]");
		
		for(int i = startPage; i <= endPage ; i++) {
			if(i == currentPage) pagingHTML.append("[ <a id='currPaging' href='boardList.do?pg="+ i +"'>"+ i +"</a> ]");
			else pagingHTML.append("[ <a id = 'paging' href='boardList.do?pg="+ i +"'>"+ i +"</a> ]");			
		}
		
		if(endPage < totalPage) pagingHTML.append("[ <a id='paging' href='boardList.do?pg="+ (endPage+1) +"'> 다음 </a> ]");
	}
}
