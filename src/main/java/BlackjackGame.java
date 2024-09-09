import domain.dispenser.Dispenser;
import domain.dispenser.RandomDispenser;
import domain.state.DeckStateFactory;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

public class BlackjackGame {
    private final Dispenser dispenser = new RandomDispenser();

    public void run() {
        Players players = initPlayers();
        Dealer dealer = initDealer();
        OutputView.printInitState(players, dealer);

        players.getPlayers().forEach(player -> {
            while (!player.isFinished()) {
                player = playerDraw(player);
            }
        });
        dealer = dealerDraw(dealer);
        OutputView.printResultScore(players, dealer);

        OutputView.printGameResult(players, dealer);
    }

    private Players initPlayers() {
        return new Players(
                InputView.inputNames().stream()
                        .map(name -> new Player(name, DeckStateFactory.getInstanceWhenGameStart(
                                dispenser.shuffle(), dispenser.shuffle()
                        ))).collect(Collectors.toList()));
    }

    private Dealer initDealer() {
        return new Dealer(DeckStateFactory.getInstanceWhenGameStart(dispenser.shuffle(), dispenser.shuffle()));
    }

    private Player playerDraw(final Player player) {
        if (InputView.askDraw(player.getName())) {
            final Player newPlayer = player.draw(dispenser.shuffle());
            OutputView.printPlayerDeck(newPlayer);
            return newPlayer;
        }
        return player.stay();
    }

    private Dealer dealerDraw(final Dealer dealer) {
        Dealer newDealer = dealer.draw(dispenser.shuffle());
        if (newDealer.equals(dealer)) {
            OutputView.printDealerDraw();
        }
        return newDealer;
    }
}
