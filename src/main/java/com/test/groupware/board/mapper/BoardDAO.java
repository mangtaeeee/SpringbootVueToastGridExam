package com.reffics.groupware.board.mapper;

import java.util.List;



import com.reffics.groupware.board.model.BoardVO;


//@Mapper 마이바티스로 매퍼 선언 해서 안써도됨
public interface BoardDAO {
	public List<BoardVO> selectEmply(BoardVO bvo);
	public int insertEmply(BoardVO bvo);

}
