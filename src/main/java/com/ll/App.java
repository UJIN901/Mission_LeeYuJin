package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<Quotation> quotations = new ArrayList<>();
    int quoteId = 0;

    void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                registerQuote();
            } else if (cmd.equals("목록")) {
                displayQuote();
            } else if (cmd.contains("삭제")) {
                removeQuote(cmd);
            }
        }
    }

    void registerQuote() {
        System.out.print("명언 : ");
        String cmdText = scanner.nextLine();
        System.out.print("작가 : ");
        String cmdAuthor = scanner.nextLine();

        quoteId++;
        Quotation quotation = new Quotation(quoteId, cmdText, cmdAuthor);
        quotations.add(quotation);

        System.out.printf("%d번 명언이 등록되었습니다.\n", quoteId);
    }

    void displayQuote() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        if (quotations.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (int i = quotations.size() - 1; i >= 0; i--) {
                Quotation quoteBit = quotations.get(i);
                System.out.printf("%d / %s / %s\n", quoteBit.id, quoteBit.author, quoteBit.text);
            }
        }
    }

    void removeQuote(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);
        if(cmdBits.length != 2 || cmdBits[1].isEmpty()){
            System.out.println("입력 양식이 유효하지 않습니다. 다시 입력해주세요.");
            return;
        }

        String command = cmdBits[0];
        String queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");
        for (String str : queryStringBits) {
            String[] queryStringBit = str.split("=", 2);
            if(queryStringBit.length !=2 || queryStringBit[0].isEmpty() || queryStringBit[1].isEmpty()){
                System.out.println("입력 양식이 유효하지 않습니다. 다시 입력해주세요.");
                return;
            }
            String queryName = queryStringBit[0];
            String queryValue = queryStringBit[1];

            if (queryName.equals("id")) {
                quotations.removeIf(obj -> obj.getId() == Integer.parseInt(queryValue));
                System.out.printf("%d번 명언이 삭제되었습니다.\n", Integer.parseInt(queryValue));
                break;
            }
        }
    }
}
