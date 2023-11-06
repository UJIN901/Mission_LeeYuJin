package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Quotation> quotations = new ArrayList<>();
    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                registerQuote();
            }
        }
    }

    void registerQuote() {
        System.out.print("명언 : ");
        String cmdText = scanner.nextLine();
        System.out.print("작가 : ");
        String cmdAuthor = scanner.nextLine();

        Quotation quotation = new Quotation(cmdText, cmdAuthor);
        quotations.add(quotation);
    }
}
