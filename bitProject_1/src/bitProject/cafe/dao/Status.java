package bitProject.cafe.dao;

public enum Status {
	// 로그인, 로그아웃, 회원가입
	LOGIN, LOGOUT, JOIN, CHECK_MY_ID,
	
	// 예약처리에 관한 메시지
	RESERVATION, CHECK_MY_RESERVATION, GET_MY_RESERVATION, CANCEL_MY_RESERVATION,

	// 게시판 처리에 관한 메시지
	WRITE_BOARD, GET_ALL_BOARDLIST, DELETE_BOARD,

	// 실패할 경우 메시지
	FAILURE
}
