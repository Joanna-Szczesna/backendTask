package pl.szczesnaj.tasks.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Generics {
    public static void main(String[] args) {
        ShirtItem shirtItemOne = new ShirtItem();
        ShirtItem shirtItemTwo = new ShirtItem();

        List<ShirtItem> shirtItems = new ArrayList<>();
        shirtItems.add(shirtItemOne);
        shirtItems.add(shirtItemTwo);

        checkoutAllItems(shirtItems);
    }

    // wildcards
    static void checkoutAllItems(List<? extends ClothingItem> clothingItems) {
        for (ClothingItem clothingItem : clothingItems) {
            checkoutItem(clothingItem);
        }
    }
    static void checkoutItem(ClothingItem item) {
        System.out.println("Item purchased: " + item.getName() + ", price: " + item.getPrice());
    }

    void exampleGenerics() {
        String[] words = {"apple", "banana", "pear"};
        Integer[] numbers = {1, 5, 7};
        List<String> wordsList = convertArrayToList(words);
        List<Integer> numbersList = convertArrayToList(numbers);
    }

    private static <T> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    //bounded generics
    private static <T extends Number> List<T> convertArrayNumbersToList(T[] array) {
        return Arrays.asList(array);
    }

}
