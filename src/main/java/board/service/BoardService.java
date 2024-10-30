package board.service;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {

	public void write(String subject, String content);

	public List<BoardDTO> getList();

	public BoardDTO getDetail(int seq);
}
