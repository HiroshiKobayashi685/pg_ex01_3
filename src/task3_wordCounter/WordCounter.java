package task3_wordCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCounter {

    public static void main(String[] args) {
        try {
            CountTable table = new CountTable();
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("検索したい英文を入力してください:");
            String line = br.readLine();
            if(checkStr(line)){
                System.out.println("■出力結果: "+ line + "の出力頻度順は以下の通りです.");
                    line = line.toLowerCase();
                    line = line.replaceAll("[^a-z]", " ");
                    for (String s : line.split("\\s+")) {
                        if (! s.equals("")) {
                            table.add(s);
                        }
                    }
                for (String s : table.getKeysByCount()) {
                     int count = table.get(s);
                     System.out.println(s + ":" + count );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //全角文字入力チェック（true:半角英数字のみ false:全角文字が入力されている）
    public static boolean checkStr(String str) {
        char[] sc = str.toCharArray();
        for ( int i=0; i<sc.length ; i++ ) {
            if (String.valueOf(sc[i]).getBytes().length >= 2 ) {
                System.out.println("全角文字が入力されています. 入力は半角英数字のみとしてください.");
                return false;
            }
        }
        return true;
    }


}