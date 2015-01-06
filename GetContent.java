package jp.ac.keio.sfc.sakai;

import java.io.*;
import java.net.*;

public class GetContent {

    public static void main (String args[]) {
        try {
            URL url = new URL("http://wepia.biz/wellness/wellness_api.php");
            Object content = url.getContent();
            if (content instanceof InputStream) {
                BufferedReader bf = new BufferedReader(new InputStreamReader( (InputStream)content) );        
                String line;
                while ((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
            }
            else {
                System.out.println(content.toString());	
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("引数にURLを指定してください");
            System.exit(-1);
        }
        catch (IOException e) {
            System.err.println(e);
            System.exit(-1);
        }
    }
}
