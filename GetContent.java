package jp.ac.keio.sfc.obpro;

import java.io.*;
import java.net.*;
import com.fasterxml.jackson.core.*;

public class GetContent {
	private static int id;
	private static String message;
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
								id = Integer.parseInt(parser.getText());
								//System.out.println(name + ": " + id);
							}
							// "message"フィールド
							else if ("message".equals(name)) {
								message = parser.getText();
								//System.out.println(name + ": " + message);
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

	public int getId(){
		return id;
	}
	
	public String getMessage(){
		return message;
	}
	
}
