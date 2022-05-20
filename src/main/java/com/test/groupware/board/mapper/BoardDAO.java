package com.groupware.board.mapper;

import java.util.List;



import com.reffics.groupware.board.model.BoardVO;



public interface BoardDAO {
	public List<BoardVO> selectEmply(BoardVO bvo);
	public int insertEmply(BoardVO bvo);

}
