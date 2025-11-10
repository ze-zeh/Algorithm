import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] d = new int[5];
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (d[0] > 0) {
                d[0]--;
            } else {
                if (d[1] > 0) {
                    d[1]--;
                } else {
                    break;
                }
            }

            if (d[4] > 0) {
                d[4]--;
            } else {
                if (d[3] > 0) {
                    d[3]--;
                } else {
                    break;
                }
            }

            if (d[2] > 0) {
                d[2]--;
            } else {
                if (d[0] + d[1] > d[3] + d[4]) {
                    if (d[1] > 0) {
                        d[1]--;
                    } else {
                        if (d[3] > 0) {
                            d[3]--;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (d[3] > 0) {
                        d[3]--;
                    } else {
                        if (d[1] > 0) {
                            d[1]--;
                        } else {
                            break;
                        }
                    }
                }
            }

            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
