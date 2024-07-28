package eSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * コンソールから入力された値を取得する
 * @author    作成者
 * @version   バージョン
 */
public class ConsoleInput {
    /**
     * 引数の値をコンソールに出力し、コンソールから
     * 入力された値を戻り値として返却する
     */
    public String getConsole(String outputConsole) throws IOException {

        System.out.println(outputConsole);

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(isr);

        //BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String inputValue = buf.readLine();

        return inputValue;
    }
}
