package pl.szczesnaj.tasks.generics;

class JacketItem extends ClothingItem{
    @Override
    int getPrice() {
        return 25;
    }

    @Override
    String getName() {
        return "Jacket";
    }
}
