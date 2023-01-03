package stack;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;

import stack.CardStack;
import stack.CardGeneratorEmptyException;

import game.CardType;
import game.Card;

public class CardGenerator {
    private List<CardType> cardsTypes;
    private int index;

    public CardGenerator() {
        this.cardsTypes = new ArrayList<>();
        this.index = 0;
        this.resetCardsTypes();
    }

    public void generate(CardStack stack, int numOfCards) throws CardGeneratorEmptyException {
        if (numOfCards > cardsTypes.size() - this.index)
            throw new CardGeneratorEmptyException("Error generating cards: the cards are over.");

        while (numOfCards > 0) {
            stack.add(new Card(this.cardsTypes.get(index)));
            this.index++;
            numOfCards--;
        }
    }

    public void rest(CardStack stack) {
        while (this.index < this.cardsTypes.size()) {
            stack.add(new Card(this.cardsTypes.get(this.index)));
            this.index++;
        }
    }

    private void resetCardsTypes() {
        this.cardsTypes.add(CardType.HRA);
        this.cardsTypes.add(CardType.HR2);
        this.cardsTypes.add(CardType.HR3);
        this.cardsTypes.add(CardType.HR4);
        this.cardsTypes.add(CardType.HR5);
        this.cardsTypes.add(CardType.HR6);
        this.cardsTypes.add(CardType.HR7);
        this.cardsTypes.add(CardType.HR8);
        this.cardsTypes.add(CardType.HR9);
        this.cardsTypes.add(CardType.HR10);
        this.cardsTypes.add(CardType.HRJ);
        this.cardsTypes.add(CardType.HRQ);
        this.cardsTypes.add(CardType.HRK);

        this.cardsTypes.add(CardType.DRA);
        this.cardsTypes.add(CardType.DR2);
        this.cardsTypes.add(CardType.DR3);
        this.cardsTypes.add(CardType.DR4);
        this.cardsTypes.add(CardType.DR5);
        this.cardsTypes.add(CardType.DR6);
        this.cardsTypes.add(CardType.DR7);
        this.cardsTypes.add(CardType.DR8);
        this.cardsTypes.add(CardType.DR9);
        this.cardsTypes.add(CardType.DR10);
        this.cardsTypes.add(CardType.DRJ);
        this.cardsTypes.add(CardType.DRQ);
        this.cardsTypes.add(CardType.DRK);

        this.cardsTypes.add(CardType.CBA);
        this.cardsTypes.add(CardType.CB2);
        this.cardsTypes.add(CardType.CB3);
        this.cardsTypes.add(CardType.CB4);
        this.cardsTypes.add(CardType.CB5);
        this.cardsTypes.add(CardType.CB6);
        this.cardsTypes.add(CardType.CB7);
        this.cardsTypes.add(CardType.CB8);
        this.cardsTypes.add(CardType.CB9);
        this.cardsTypes.add(CardType.CB10);
        this.cardsTypes.add(CardType.CBJ);
        this.cardsTypes.add(CardType.CBQ);
        this.cardsTypes.add(CardType.CBK);

        this.cardsTypes.add(CardType.SBA);
        this.cardsTypes.add(CardType.SB2);
        this.cardsTypes.add(CardType.SB3);
        this.cardsTypes.add(CardType.SB4);
        this.cardsTypes.add(CardType.SB5);
        this.cardsTypes.add(CardType.SB6);
        this.cardsTypes.add(CardType.SB7);
        this.cardsTypes.add(CardType.SB8);
        this.cardsTypes.add(CardType.SB9);
        this.cardsTypes.add(CardType.SB10);
        this.cardsTypes.add(CardType.SBJ);
        this.cardsTypes.add(CardType.SBQ);
        this.cardsTypes.add(CardType.SBK);

        Collections.shuffle(this.cardsTypes);
    }

}