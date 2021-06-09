package BOJ_2174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Robot {
        int y;
        int x;
        int direction;

        public Robot(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    static class Order {
        int robot;
        int repeat;
        String order;

        public Order(int robot, String order, int repeat) {
            this.robot = robot;
            this.repeat = repeat;
            this.order = order;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[B][A];
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Robot[] robots = new Robot[N + 1];
        int y, x;
        String direction;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            direction = st.nextToken();
            map[y][x] = i;
            robots[i] = new Robot(y, x, "ENWS".indexOf(direction));
        }

        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};

        boolean check = false;

        Queue<Order> queue = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            queue.add(new Order(Integer.parseInt(st.nextToken()), st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        int robot, repeat;
        String order;
        while(!queue.isEmpty()){
            Order current = queue.poll();
            robot = current.robot;
            repeat = current.repeat;
            order = current.order;

            for(int j = 0; j < repeat; j++){
                if(order.equals("R")){
                    robots[robot].direction = (robots[robot].direction + 3) % 4;
                }else if(order.equals("L")){
                    robots[robot].direction = (robots[robot].direction + 1) % 4;
                }else {
                    int ny = robots[robot].y + dy[robots[robot].direction];
                    int nx = robots[robot].x + dx[robots[robot].direction];

                    //벽, 로봇 충돌 체크
                    if(ny < 0 || nx < 0 || ny >= B || nx >= A){
                        check = true;
                        System.out.println("Robot " + robot + " crashes into the wall");
                        break;
                    }
                    if(map[ny][nx] != 0){
                        check = true;
                        System.out.println("Robot " + robot + " crashes into robot " + map[ny][nx]);
                        break;
                    }
                    // 이동
                    map[robots[robot].y][robots[robot].x] = 0;
                    map[ny][nx] = robot;
                    robots[robot].y = ny;
                    robots[robot].x = nx;
                }
            }
            if(check) break;
        }

        if(!check) {
            System.out.println("OK");
        }
    }
}
