import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] team = new String[n];
        int l = 0;
        int o = 0;
        int v = 0;
        int e = 0;
        int max = 0;
        String answer = "ZZZZZZZZZZZZZZZZZZZZ";

        for (int i = 0; i < n; i++) {
            team[i] = br.readLine();
        }

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'L') l++;
            if (name.charAt(i) == 'O') o++;
            if (name.charAt(i) == 'V') v++;
            if (name.charAt(i) == 'E') e++;
        }

        for (int i = 0; i < n; i++) {
            int ll = l;
            int oo = o;
            int vv = v;
            int ee = e;

            for (int j = 0; j < team[i].length(); j++) {
                if (team[i].charAt(j) == 'L') ll++;
                if (team[i].charAt(j) == 'O') oo++;
                if (team[i].charAt(j) == 'V') vv++;
                if (team[i].charAt(j) == 'E') ee++;
            }

            int percent = (ll + oo) * (ll + vv) * (ll + ee) * (oo + vv) * (oo + ee) * (vv + ee) % 100;

            if (percent > max) {
                max = percent;
                answer = team[i];
            } else if (percent == max) {
                if (answer.compareTo(team[i]) > 0) {
                    answer = team[i];
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
