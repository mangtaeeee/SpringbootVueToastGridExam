package com.groupware.board.service;

import java.util.List;

import com.reffics.groupware.board.model.BoardVO;

public interface BoardService {
	public List<BoardVO> selectEmply(BoardVO bvo);
	public int insertEmply(BoardVO bvo);
}
        
