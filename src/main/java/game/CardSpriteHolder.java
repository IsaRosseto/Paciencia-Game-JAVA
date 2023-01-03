package game;

import game.CardType;
import util.Rectangle;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.HashMap;

public final class CardSpriteHolder {

    private static final String backImageFilename = "./sprites/playingCardBacks.png";
    private static final String cardsImageFilename = "./sprites/playingCards.png";

    private static Image imageCards;
    private static Image imageBack;

    public static Image getBackImage() {
        if (imageBack == null) {
            try {
                FileInputStream stream = new FileInputStream(backImageFilename);
                imageBack = new Image(stream);
            } catch (FileNotFoundException fnfe) {
                System.out.println("Error opening image file: " + fnfe.getMessage());
            }
        }

        return imageBack;
    }

    public static Image getCardsImage() {
        if (imageCards == null) {
            try {
                FileInputStream stream = new FileInputStream(cardsImageFilename);
                imageCards = new Image(stream);
            } catch (FileNotFoundException fnfe) {
                System.out.println("Error opening image file: " + fnfe.getMessage());
            }
        }

        return imageCards;
    }

    public static Rectangle getBackBound() {
        return backBound;
    }

    public static Rectangle getCardBound(CardType type) {
        return cardsBounds.get(type);
    }

    private static final Rectangle backBound = new Rectangle(140 * 2, 0, 140, 190);

    private static final HashMap<CardType, Rectangle> cardsBounds = new HashMap<>() {
        {
            put(CardType.HRA, new Rectangle(140, 190 * 7, 140, 190));
            put(CardType.HR2, new Rectangle(140 * 5, 190 * 2, 140, 190));
            put(CardType.HR3, new Rectangle(140 * 2, 190 * 5, 140, 190));
            put(CardType.HR4, new Rectangle(140 * 2, 190 * 4, 140, 190));
            put(CardType.HR5, new Rectangle(140 * 2, 190 * 3, 140, 190));
            put(CardType.HR6, new Rectangle(140 * 2, 190 * 2, 140, 190));
            put(CardType.HR7, new Rectangle(140 * 2, 190 * 1, 140, 190));
            put(CardType.HR8, new Rectangle(140 * 2, 0, 140, 190));
            put(CardType.HR9, new Rectangle(140 * 1, 190 * 9, 140, 190));
            put(CardType.HR10, new Rectangle(140 * 1, 190 * 8, 140, 190));
            put(CardType.HRJ, new Rectangle(140 * 1, 190 * 6, 140, 190));
            put(CardType.HRQ, new Rectangle(140 * 1, 190 * 4, 140, 190));
            put(CardType.HRK, new Rectangle(140 * 1, 190 * 5, 140, 190));

            put(CardType.DRA, new Rectangle(140 * 3, 0, 140, 190));
            put(CardType.DR2, new Rectangle(140 * 3, 190 * 9, 140, 190));
            put(CardType.DR3, new Rectangle(140 * 3, 190 * 8, 140, 190));
            put(CardType.DR4, new Rectangle(140 * 3, 190 * 7, 140, 190));
            put(CardType.DR5, new Rectangle(140 * 3, 190 * 6, 140, 190));
            put(CardType.DR6, new Rectangle(140 * 3, 190 * 5, 140, 190));
            put(CardType.DR7, new Rectangle(140 * 3, 190 * 4, 140, 190));
            put(CardType.DR8, new Rectangle(140 * 3, 190 * 3, 140, 190));
            put(CardType.DR9, new Rectangle(140 * 3, 190 * 2, 140, 190));
            put(CardType.DR10, new Rectangle(140 * 3, 190 * 1, 140, 190));
            put(CardType.DRJ, new Rectangle(140 * 2, 190 * 9, 140, 190));
            put(CardType.DRQ, new Rectangle(140 * 2, 190 * 7, 140, 190));
            put(CardType.DRK, new Rectangle(140 * 2, 190 * 8, 140, 190));

            put(CardType.CBA, new Rectangle(140 * 4, 190 * 3, 140, 190));
            put(CardType.CB2, new Rectangle(140 * 2, 190 * 6, 140, 190));
            put(CardType.CB3, new Rectangle(140 * 5, 190 * 1, 140, 190));
            put(CardType.CB4, new Rectangle(140 * 5, 0, 140, 190));
            put(CardType.CB5, new Rectangle(140 * 4, 190 * 9, 140, 190));
            put(CardType.CB6, new Rectangle(140 * 4, 190 * 8, 140, 190));
            put(CardType.CB7, new Rectangle(140 * 4, 190 * 7, 140, 190));
            put(CardType.CB8, new Rectangle(140 * 4, 190 * 6, 140, 190));
            put(CardType.CB9, new Rectangle(140 * 4, 190 * 5, 140, 190));
            put(CardType.CB10, new Rectangle(140 * 4, 190 * 4, 140, 190));
            put(CardType.CBJ, new Rectangle(140 * 4, 190 * 2, 140, 190));
            put(CardType.CBQ, new Rectangle(140 * 4, 0, 140, 190));
            put(CardType.CBK, new Rectangle(140 * 4, 190 * 1, 140, 190));

            put(CardType.SBA, new Rectangle(0, 190 * 3, 140, 190));
            put(CardType.SB2, new Rectangle(140, 190 * 2, 140, 190));
            put(CardType.SB3, new Rectangle(140, 190 * 1, 140, 190));
            put(CardType.SB4, new Rectangle(140, 0, 140, 190));
            put(CardType.SB5, new Rectangle(0, 190 * 9, 140, 190));
            put(CardType.SB6, new Rectangle(0, 190 * 8, 140, 190));
            put(CardType.SB7, new Rectangle(0, 190 * 7, 140, 190));
            put(CardType.SB8, new Rectangle(0, 190 * 6, 140, 190));
            put(CardType.SB9, new Rectangle(0, 190 * 5, 140, 190));
            put(CardType.SB10, new Rectangle(0, 190 * 4, 140, 190));
            put(CardType.SBJ, new Rectangle(0, 190 * 2, 140, 190));
            put(CardType.SBQ, new Rectangle(0, 0, 140, 190));
            put(CardType.SBK, new Rectangle(0, 190, 140, 190));
        }
    };

}
