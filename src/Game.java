public class Game {
    public static final int DIRECTION_NOME = 0, DIRECTION_RIGHT = 1,
            DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION = -2;
    private Snake snake;
    private Board board;
    private int direction;
    private boolean gameOver;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getDirection() {
        return direction;
    }

    public void update() {
        System.out.println("Going to update the game");
        if (!gameOver) {
            if (direction != DIRECTION_NOME) {
                Cell nextCell = getNextCell(snake.gethead());
                if (snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NOME);
                    gameOver = true;
                } else {
                    snake.move(nextCell);
                    if (nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }

    private void setDirection(int directionNome) {
    }

    private Cell getNextCell(Cell gethead) {
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        System.out.println("Going to start game");

        Cell initPos = new Cell(0, 0);
        Snake initSnake = new Snake(initPos);
        Board board = new Board(10, 10);
        Game newGame = new Game(initSnake, board);
        newGame.direction = DIRECTION_RIGHT;
        for (int i = 0; i < 5; i++) 
        {
            if (i == 2) 
            {
                newGame.board.generateFood();
            }
            if (i == 3) 
            {
                newGame.direction = DIRECTION_RIGHT;
                if (newGame.gameOver == true) 
                {
                    break;
                }
            }
        }
    }
}
