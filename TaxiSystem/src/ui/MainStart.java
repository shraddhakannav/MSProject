
package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainStart {

	static BufferedReader br = null;

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

	public static BufferedReader getReader() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		return br;
	}

}
