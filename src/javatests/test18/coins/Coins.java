package javatests.test18.coins;

import javatests.PathPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        File input = new PathPackage(Coins.class.getPackageName(), "input.txt").getFile();
        File output = new PathPackage(Coins.class.getPackageName(), "output.txt").getFile();
        int quantityCoins;
        int heads = 0;
        int tails = 0;
        int thisCoin;
        try (Scanner scanner = new Scanner(input)) {
            quantityCoins = scanner.nextInt();
            for (int i = 0; i < quantityCoins; i++) {
                thisCoin = scanner.nextInt();
                if (thisCoin > 0) {
                    heads++;
                } else {
                    tails++;
                }
            }
            try (PrintWriter writer = new PrintWriter(output)) {
                writer.println(Math.min(heads, tails));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
