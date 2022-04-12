/** 生命游戏 */
public class Leet289 {
    public void gameOfLive(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // 便于对当前处理的细胞的坐标进行加减，来定位其邻居坐标 当前细胞(i,j)，（i+(-1),j)为当前细胞左边的细胞
        int[] neighbors = { -1, 0, 1 };
        int[][] copyboard = new int[m][n]; // 复制数组

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copyboard[i][j] = board[i][j];
            }
        }

        // 遍历面板每一个格子里的细胞
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 用于统计8个邻居中存活细胞的数量
                int liveNeighbors = 0;

                // 划分出九宫格区域做处理
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        // 遍历邻居
                        if (!(neighbors[row] == 0 && neighbors[column] == 0)) {
                            // 定位邻居坐标
                            int r = (i + neighbors[row]);
                            int c = (j + neighbors[column]);

                            // 查看邻居细胞是否是活细胞
                            if ((r >= 0 && r < m) && (c >= 0 && c < n) && (copyboard[r][c] == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                // 题中活细胞的规则1和规则3
                if ((copyboard[i][j] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }
                if (copyboard[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
