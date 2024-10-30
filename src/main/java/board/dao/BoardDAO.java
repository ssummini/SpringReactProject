package board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.bean.BoardDTO;

@Mapper
public interface BoardDAO {

	public int write(Map<String, String> map);

	public void refUpdate();
	
	public List<BoardDTO> getList();

	public BoardDTO getDetail(int seq);

}
