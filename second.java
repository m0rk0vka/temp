import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;


public class second {
    public static void main(String args[]) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a path Python executable: ");
        String str = in.nextLine();

        System.out.printf("Path: %s\n", str);

        try {
            Process proc = Runtime.getRuntime().exec(str + " -m timeit -r 10");
            
            long start = System.currentTimeMillis();
            boolean x = true;
            while(x)
            {   
                TimeUnit.SECONDS.sleep(1);
                System.out.println((System.currentTimeMillis() - start) / 1000);
                try
                {
                    Integer result = proc.exitValue();
                    /* if result != 0
                    if (result == 0)
                    {
                        //System.out.println((System.currentTimeMillis() - start) / 1000);
                        break;
                    }*/
                    break;
                } catch (IllegalThreadStateException e) {
                    //do nothing
                }
            
            }

            BufferedReader reader = new BufferedReader(new 
                InputStreamReader(proc.getInputStream()));

            String line = "";
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));

            while ((line = reader.readLine()) != null) {
                System.out.print(line + "\n");
            }
            
            reader.close();
            
        } catch (IOException e) {
            System.out.println("exception thrown: " + e.getMessage());
        }
        
        in.close();
    }
}