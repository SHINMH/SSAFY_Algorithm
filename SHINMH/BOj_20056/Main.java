package BOj_20056;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Fire {
        int direction;
        int speed;
        int mass;

        public Fire(int mass, int speed, int direction) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }

    static int N;
    static int M;
    static int K;
    static List<Fire>[][] board;

    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new LinkedList<>();
            }
        }
        //입력 row, col, m(질량), s(속도), d(방향)
        int r, c, m, d, s;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            board[r][c].add(new Fire(m, s, d));
        }

        dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        solution();
    }

    public static void solution() {
        for (int i = 1; i <= K; i++) {
            move();
        }
        System.out.println(calMass());
    }

    public static void move() {
        List<Fire>[][] newBoard = new List[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[i][j] = new LinkedList<>();
            }
        }
        // 모든 불 이동.
        int x, y;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fire fire : board[i][j]) {
                    y = i;
                    x = j;

                    for (int k = 1; k <= fire.speed; k++) {
                        y = y + dy[fire.direction];
                        x = x + dx[fire.direction];
                        if(y == -1){ y = N - 1; } // 0 -> -1 -> N - 1
                        if(x == -1){ x = N - 1; }
                        if(y == N){ y = 0; } // N -1 -> N -> 0
                        if(x == N){ x = 0; }
                    }
                    newBoard[y][x].add(new Fire(fire.mass, fire.speed, fire.direction));
                }
            }
        }
        // 이동했던 불들 정리

        int sumMass, sumSpeed, count, oddEvenCount;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j].clear();
                sumMass = 0;
                sumSpeed = 0;
                count = newBoard[i][j].size();
                oddEvenCount = 0;
                for (Fire fire : newBoard[i][j]) {
                    sumMass += fire.mass;
                    sumSpeed += fire.speed;
                    if(fire.direction % 2 == 0) oddEvenCount++; // 2, 2 4 -> 2 1 -1 // 0
                    else oddEvenCount--;
                }
                // 없거나, 하나있는 경우
                if(count == 0) continue;
                if(count == 1){
                    board[i][j].add(newBoard[i][j].get(0));
                    continue;
                }

                // 질량이 0이면 더이상 진행하지 않음
                if (sumMass / 5 == 0) continue;

                if (Math.abs(oddEvenCount) == count) {
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 0));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 2));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 4));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 6));
                } else {
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 1));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 3));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 5));
                    board[i][j].add(new Fire(sumMass / 5, sumSpeed / count, 7));
                }
            }
        }
    }

    public static int calMass(){
        int sumMass = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j].isEmpty()) continue;

                for (Fire fire : board[i][j]) {
                    sumMass += fire.mass;
                }
            }
        }
        return sumMass;
    }
}
