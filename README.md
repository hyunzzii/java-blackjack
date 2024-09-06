# java-blackjack

### 게임 규칙
- [x] 카드는 숫자와 문양을 갖는다.
- [ ] 숫자는 1부터 10까지이다. 단 Ace는 1 또는 11로 계산할 수 있다. King, Queen, Jack은 각각 10으로 계산한다.
- [x] 문양은 클로버, 다이아몬드, 스페이드, 하트이다.
- [x] 게임은 하나의 덱(52장)을 사용하여 카드를 셔플한다.
- [x] 받은 카드의 총합이 21 초과이면 Bust 상태이다.
  - [x] Bust 에서 갈 수 있는 상태는 없다.
- [x] 받은 카드의 총합이 21 이면 Blackjack 상태이다.
  - [x] Blackjack -> Bust
  - [x] Blackjack -> Stay
- [x] 받은 카드의 총합이 21 미만이면 Hit 상태이다.
  - [x] Hit -> Bust
  - [x] Hit -> Blackjack
  - [x] Hit -> Hit
  - [x] Hit -> Stay
- [x] 받은 카드의 총합이 21 이하이면서 카드를 더이상 받지 않으면 Stay 상태이다.
  - [x] Stay 에서 갈 수 있는 상태는 없다.
- [x] 카드를 받을 수 있으면 Running 상태이다.
  - [x] Hit
  - [x] Blackjack
- [x] 카드를 받을 수 없으면 Finished 상태이다.
  - [x] Bust
  - [x] Stay
- [ ] 카드를 받지 않았으면 Started 상태이다.