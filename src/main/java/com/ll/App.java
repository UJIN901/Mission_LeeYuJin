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

            Rq rq = new Rq(cmd);

            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    registerQuote();
                    break;
                case "목록":
                    displayQuote();
                    break;
                case "삭제":
                    removeQuote(rq);
                    break;
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

    void removeQuote(Rq rq) {
        int id = rq.getParamAsInt("id", -1);
        if (id == -1) {
            System.out.println("입력 양식이 유효하지 않습니다. 다시 입력해주세요.");
            return;
        } else {
            for(int i = 0; i < quotations.size(); i++){
                Quotation temp = quotations.get(i);
                if(temp.getId() == id){
                    quotations.remove(i);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                    return;
                }
            }
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        }
    }
}
