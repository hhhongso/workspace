package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage;
	private int pageBlock; 
	private int pageSize;
	private int totalArticle;
	private StringBuffer pagingHTML;
	
	public void makePagingHTML(String addr) {
		pagingHTML = new StringBuffer();
		int totalPage = (totalArticle+pageSize-1) / pageSize;
		int startPage = (currentPage-1)/pageBlock * pageBlock +1; 
		int endPage = startPage + pageBlock -1;
		if(endPage > totalPage) endPage = totalPage;
		if(startPage > pageBlock) pagingHTML.append("[ <a id='paging' href='"+addr+".do?pg="+ (startPage-1) +"'> 이전 </a> ]");
		
		for(int i = startPage; i <= endPage ; i++) {
			if(i == currentPage) pagingHTML.append("[ <a id='currPaging' href='"+addr+".do?pg="+ i +"'>"+ i +"</a> ]");
			else pagingHTML.append("[ <a id = 'paging' href='"+addr+".do?pg="+ i +"'>"+ i +"</a> ]");			
		}
		
		if(endPage < totalPage) pagingHTML.append("[ <a id='paging' href='"+addr+".do?pg="+ (endPage+1) +"'> 다음 </a> ]");
	}
}
