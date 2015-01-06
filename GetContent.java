package jp.ac.keio.sfc.obpro;

import java.io.*;
import java.net.*;
import com.fasterxml.jackson.core.*;

public class GetContent {

    public static void main (String args[]) {
        try {
            URL url = new URL("http://wepia.biz/wellness/wellness_api.php");
            JsonFactory factory = new JsonFactory();
        	JsonParser parser = factory.createParser(url);
        	// 配列の処理
    		if (parser.nextToken() == JsonToken.START_ARRAY) {
    			while (parser.nextToken() != JsonToken.END_ARRAY) {
    				// 各オブジェクトの処理
    				if (parser.getCurrentToken() == JsonToken.START_OBJECT) {
    					while (parser.nextToken() != JsonToken.END_OBJECT) {
    						String name = parser.getCurrentName();
    						parser.nextToken();
    						// "id"フィールド
    						if ("id".equals(name)) {
    							System.out.println(name + ": ");
    							while (parser.nextToken() != JsonToken.END_OBJECT) {
    								if (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
    									System.out.print("    " + parser.getText() + ": ");
    								} else if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
    									System.out.println(parser.getText());
    								}
    							}
    						}
    						// "message"フィールド
    						else if ("message".equals(name)) {
    							System.out.println(name + ": " + parser.getText());
    						} 
    						else {
    							parser.skipChildren();
    						}
    					}
    				}
    				else {
    					parser.skipChildren();
    				}        
    			}
    		}
    		else {
    			parser.skipChildren();
    		}
        	
    		/*
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
            */
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
