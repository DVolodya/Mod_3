import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Mod {
    public static double f1, dis;

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter quantity :");
//        int n = in.nextInt();
        int n = 1000;

        double[] myArray = new double[n];
        Random random = new Random();
        double a = 0, b = 1.7;
        double C = 1;
        double x, r1, r2, z1, z2;
        boolean f;
        for (int i = 0; i < n; i++) {
            f = true;
            do {
                r1 = random.nextDouble();
                r2 = random.nextDouble();
                z1 = a + r1 * (b - a);
                z2 = C * r2;
                if (z2 < 0.25 * z1 + 0.575) {
                    x = z1;
                    // System.out.println("x[{0}] = {1:f3}");
                    // System.out.println(i+"="+x);
                    // System.out.println(x);
                    f = false;
                    myArray[i] = x;
                }
            } while (f);
        }
        Arrays.sort(myArray);
        for (int i = 0; i < n; i++) {
            System.out.println(myArray[i]);

        }
        double[] myArray1 = new double[n];
        double sum = Arrays.stream(myArray).sum();
        f1 = sum / n;
        System.out.println("Matozh=" + f1);
//        for (int i = 1; i <= n; i++) {
//            double g = (myArray[i] - f);
//            dis = g * g;
//            myArray1[i] = dis;
//        }
        double[] myArray2 = new double[n];
        double sum4 = Arrays.stream(myArray).sum();
        double dis1 = sum4 / (n - 1);
        System.out.println("Dis=" + dis1);
        //System.out.println(sum4);
        //Критерий Пирсона============================================
        int k = 15;
        double[] kol = new double[k];
        double xi = 0;
        for (int j = 0; j < k; j++) {
            xi += (Math.pow((kol[j]) - myArray.length / k, 2) / myArray.length / k);
        }
        System.out.println("Pearson criterion=" + xi);

        //==================
        //Критерий Колмогорова=========================================
        Arrays.sort(myArray);
        double dMax = 0.0;
        for (int j = 0; j < myArray.length; j++) {
            Double dp = Math.abs((double) (j + 1) / myArray.length - myArray[j]);
            double dm = Math.abs(myArray[j] - (double) j / myArray.length);
            if (dp > dMax) dMax = dp;
            if (dm > dMax) dMax = dm;
        }
        System.out.println("Kolmogorov criterion =" + dMax * Math.sqrt((myArray.length)));
        double Len = (myArray[n - 1] - myArray[1]) / k;
        for (int i = 0; i < k; i++)//интервалы
        {
            for (int z = 0; z < myArray.length; z++)//перебор элементов массива
            {
                if ((Double.compare(i * Len, myArray[z]) <= 0) &&
                        (Double.compare((i + 1) * Len, myArray[z]) > 0)) {
                    kol[i]++;
                }
            }
        }
        //Количество в каждом из интервалов
        double[] inter = new double[k];
        for (int i = 0; i < k; i++) {
            //inter[i]=kol[i]/n;
            System.out.println(kol[i]);
            //System.out.println(inter[i]);
        }
        for (int i = 0; i < k; i++) {
            inter[i] = kol[i] / n;          //поделили количество значений в интервале на количество значений
            //System.out.println(kol[i]);
            System.out.println("inter=" + inter[i]);
        }
        double[] inter1 = new double[n];
        for (int i = 0; i < k; i++) {
//            while (i < k) {
                inter1[i] = kol[i] + kol[i + 1];
                //System.out.println(kol[i]);
                System.out.println("inter1=" + inter[i]);
 //           }

        }
    }
}


