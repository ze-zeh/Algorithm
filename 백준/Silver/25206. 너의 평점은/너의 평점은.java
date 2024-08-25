import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static public void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double creditSum = 0;
        double gradeSum = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            creditSum += credit;

            switch (grade) {
                case "A+": {
                    gradeSum += credit * 4.5f;
                    break;
                }
                case "A0": {
                    gradeSum += credit * 4.0f;
                    break;
                }
                case "B+": {
                    gradeSum += credit * 3.5f;
                    break;
                }
                case "B0": {
                    gradeSum += credit * 3.0f;
                    break;
                }
                case "C+": {
                    gradeSum += credit * 2.5f;
                    break;
                }
                case "C0": {
                    gradeSum += credit * 2.0f;
                    break;
                }
                case "D+": {
                    gradeSum += credit * 1.5f;
                    break;
                }
                case "D0": {
                    gradeSum += credit * 1.0f;
                    break;
                }
                case "F": {
                    gradeSum += credit * 0.0f;
                    break;
                }
                case "P": {
                    creditSum -= credit;
                    break;
                }
            }
        }

        System.out.println(gradeSum / creditSum);
        br.close();
    }
}