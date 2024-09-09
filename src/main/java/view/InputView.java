package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)\n";
    private static final String ASK_DRAW = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.printf(System.lineSeparator() + INPUT_NAMES);
        return List.of(scanner.nextLine().split(","));
    }

    public static Boolean askDraw(final String name) {
        System.out.printf(System.lineSeparator() + ASK_DRAW, name);
        return scanner.nextLine().equals("y");
    }
}
