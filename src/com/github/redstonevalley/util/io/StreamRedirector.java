package com.github.redstonevalley.util.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StreamRedirector extends Thread {

  public StreamRedirector(final InputStream src, final PrintStream dest) {
    super(new Runnable() {
        public void run() {
            Scanner sc = new Scanner(src);
            while (sc.hasNextLine()) {
                dest.println(sc.nextLine());
            }
            sc.close();
        }
    });
    start();
  }
}
