package view;

import domain.card.Card;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DEALER_CARD_FORMAT = "딜러: %s";
    private static final String PLAYER_CARD_FORMAT = "%s: %s";
    private static final String RESULT_SCORE_FORMAT = " - 결과: %d";
    private static final String GAME_RESULT = "## 최종 승패";
    private static final String PLAYER_GAME_RESULT_FORMAT = "%s: %s";
    private static final String DEALER_GAME_RESULT_FORMAT = "딜러: %d무 %d승 %d패";
    private static final String DEALER_DRAW_STRING = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";


    public static void printInitState(final Players players, final Dealer dealer) {
        printDispenseState(players, dealer);
        printDealerFirstCard(dealer);
        printPlayersDeck(players);
    }

    public static void printDispenseState(final Players players, final Dealer dealer) {
        final String dispenseMessageFormat = "딜러와 %s에게 2장을 나누었습니다.";
        System.out.printf(System.lineSeparator() + dispenseMessageFormat,
                players.getPlayers().stream().map(Player::getName).collect(Collectors.joining(", ")));
    }

    public static void printDealerFirstCard(final Dealer dealer) {
        final int FIRST_CARD_INDEX = 0;
        System.out.printf(System.lineSeparator() + DEALER_CARD_FORMAT,
                dealer.getDeckState().getDeck().getCards().get(FIRST_CARD_INDEX));
    }

    public static void printDealerDeck(final Dealer dealer) {
        System.out.printf(System.lineSeparator() + DEALER_CARD_FORMAT,
                dealer.getDeckState().getDeck().getCards().stream().map(Card::toString)
                        .collect(Collectors.joining(", ")));
    }

    public static void printPlayersDeck(final Players players) {
        for (Player player : players.getPlayers()) {
            printPlayerDeck(player);
        }
    }

    public static void printPlayerDeck(final Player player) {
        System.out.printf(System.lineSeparator() + PLAYER_CARD_FORMAT,
                player.getName(),
                player.getDeckState().getDeck().getCards().stream().map(Card::toString)
                        .collect(Collectors.joining(", ")));
    }

    public static void printDealerDraw() {
        System.out.println(System.lineSeparator() + DEALER_DRAW_STRING);
    }

    public static void printResultScore(final Players players, final Dealer dealer) {
        printDealerDeck(dealer);
        System.out.printf(RESULT_SCORE_FORMAT, dealer.getScore().getValue());

        for (Player player : players.getPlayers()) {
            printPlayerDeck(player);
            System.out.printf(RESULT_SCORE_FORMAT, player.getScore().getValue());
        }
        System.out.println();
    }

    public static void printGameResult(final Players players, final Dealer dealer) {
        Map<String, String> winOrLose = getPlayerGameResult(players, dealer);
        Map<String, Integer> dealerWinOrLose = new HashMap<>();
        dealerWinOrLose.put(WIN, 0);
        dealerWinOrLose.put(LOSE, 0);
        dealerWinOrLose.put(DRAW, 0);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : winOrLose.entrySet()) {
            result.append(String.format(System.lineSeparator() + PLAYER_GAME_RESULT_FORMAT, entry.getKey(),
                    entry.getValue()));
            dealerWinOrLose.put(entry.getValue(), dealerWinOrLose.get(entry.getValue()) + 1);
        }
        result.insert(
                0, String.format(System.lineSeparator() + DEALER_GAME_RESULT_FORMAT,
                        dealerWinOrLose.get(DRAW), dealerWinOrLose.get(LOSE), dealerWinOrLose.get(WIN)));
        result.insert(0, String.format(System.lineSeparator() + GAME_RESULT));
        System.out.println(result);
    }

    private static Map<String, String> getPlayerGameResult(final Players players, final Dealer dealer) {
        Map<String, String> winOrLose = new HashMap<>();
        for (Player player : players.getPlayers()) {
            if (player.getScore().isDraw(dealer.getScore())) {
                winOrLose.put(player.getName(), DRAW);
                continue;
            }
            if (player.getScore().isWin(dealer.getScore())) {
                winOrLose.put(player.getName(), WIN);
                continue;
            }
            winOrLose.put(player.getName(), LOSE);
        }
        return winOrLose;
    }
}
