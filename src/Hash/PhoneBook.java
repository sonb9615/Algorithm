package Hash;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

	public boolean solution(String[] phone_book) {
		boolean answer = true;

		for(int i = 0; i < phone_book.length; i++) {
			if(i > 0){
				String temp = phone_book[0];
				phone_book[0] = phone_book[i];
				phone_book[i] = temp;

			}
			Map<Integer,String> num = new HashMap<>();
			String str = phone_book[0];
			int len = str.length();


			for(int j = 1; j < phone_book.length; j++) {
				if(phone_book[j].length() < len){
					continue;
				}

				String word = phone_book[j].substring(0, len);
				num.put(j, word);

			}

			if(num.containsValue(str)) {

				answer = false;
				break;
			}

		}

		return answer;
	}
}

