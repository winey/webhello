package myboard.repository;

import myboard.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: HolyEyE
 * Date: 13. 2. 27. Time: 오후 5:22
 */
public class BoardMemoryRepository implements BoardRepository {

    private static int keyStore = 0;

    private static BoardMemoryRepository instance = new BoardMemoryRepository();

    private List<Board> boards = new ArrayList<Board>();

    public static BoardMemoryRepository getInstance() {
        return instance;
    }

    private BoardMemoryRepository() {

        Board board = new Board();
        board.setId(generateId());
        board.setTitle("title");
        board.setWriter("작성자");
        board.setContent("좋은 글 입니다.");
        board.setPw("pw");

        boards.add(board);
        boards.add(new Board(generateId(), "title2","작성자2","pw","content입니다."));
    }

    @Override
    public List<Board> getBoards() {
        return boards;
    }

    @Override
    public void addBoard(Board board) {

        int newId = generateId();
        board.setId(newId);
        boards.add(board);
    }

    @Override
    public Board getBoardById(int id) {
        for (Board board : boards) {
            if (board.getId() == id) {
                return board;
            }
        }
        return null;
    }

    @Override
    public void updateBoard (Board updateBoard) {
        for (Board  board : boards) {
            if (board.getId() != updateBoard.getId()) {
                continue;
            }

            board.setTitle(updateBoard.getTitle());
            board.setWriter(updateBoard.getWriter());
            board.setPw(updateBoard.getPw());
            board.setContent(updateBoard.getContent());
        }
    }

    @Override
    public void deleteBoard(int id) {
        for (Board  board : boards) {
            if (board.getId() != id) {
                continue;
            }
            boards.remove(board);
            break;
        }
    }


    private synchronized int generateId() {
        return keyStore++;
    }

}
