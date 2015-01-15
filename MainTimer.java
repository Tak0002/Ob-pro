package jp.ac.keio.sfc.obpro;

public class MainTimer {
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		GetContent content = new GetContent();
		int id;
		int pre_id = 0;
		for(;;){
			try {
				Thread.sleep(3000);
				id = content.GetId();
				
				//System.out.println(id);
				if(id != pre_id){
					String message = content.getMessage();
					System.out.println(message);
				}
				pre_id = id;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
