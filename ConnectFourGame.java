public class ConnectFourGame {
    public static void main(String[] args) {
        int[][] pieces = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {1, 2, 2, 1, 0, 0, 0},
                {2, 1, 2, 1, 2, 1, 0},

        };
        drawBoard(pieces);
        if(gameOverJudge(pieces) !=0){
            String winner="";
            switch (gameOverJudge(pieces)) {
                case 1 -> winner = "red";
                case 2 -> winner = "yellow";
                default -> {
                }
            }
            System.out.println("The " +winner+" player won");
        }else {
            System.out.println("continue");
        };
    }

    /*展现棋盘的局势*/
    public static void drawBoard(int[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print("|");
            for (int j = 0; j < pieces[i].length; j++) {
                switch (pieces[i][j]) {
                    case 0:
                        System.out.print(' ');
                        break;
                    case 1:
                        System.out.print('R');
                        break;
                    case 2:
                        System.out.print('Y');
                        break;
                }
                System.out.print("|");
            }
            System.out.println();
        }
        for(int i=0; i<pieces[0].length * 2 + 1; i++){
            System.out.print("-");
        }
    }

    /*判断游戏是否结束*/
    public static int gameOverJudge(int[][] pieces){
        int[][] piecesLarge = new int[8][9];
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                piecesLarge[i][j] = pieces[i-1][j-1];
            }
        }

        int[][] dir = {
                {-1, 0}, // up
                {-1, 1}, // right up
                {0, 1}, // right
                {1, 1}, // right down

        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                /*只有当棋子落位, 也就是不等于0的时候*/
                if(piecesLarge[i][j] != 0) {
                    /*进行判断*/
                    int count = 0;
                    /*判断方向*/
                    for (int k = 0; k < 4; k++) {
                        /*如果颜色一致或不一致*/
                        int[] position = new int[]{i, j};
                        do{
                            position[0] += dir[k][0];
                            position[1] += dir[k][1];
                            if (piecesLarge[i][j] == piecesLarge[position[0]][position[1]]) {
                                count++;
                            } else {
                                count = 0;
                                break;
                            }
                        }while (count != 3);

                        if (count == 3) {
                            return piecesLarge[i][j];
                        }
                    }
                }
            }
        }

//        drawBoard(piecesLarge);
        return 0;
    }
}
