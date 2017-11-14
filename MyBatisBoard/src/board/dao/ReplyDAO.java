package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Reply;

public class ReplyDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	SqlSession sqlSession = null;
	
	public void insertReply(Reply r) {
		try {
			sqlSession = factory.openSession();
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			mapper.insertReply(r);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	public ArrayList<Reply> selectAllReply(int boardnum) {
		ArrayList<Reply> list = null;
		try {
			sqlSession = factory.openSession();
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			list = mapper.selectAllReply(boardnum);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
		return list;
	}
}
