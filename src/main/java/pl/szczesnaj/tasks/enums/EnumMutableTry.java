package pl.szczesnaj.tasks.enums;

class EnumMutableTry {
    public static void main(String[] args) {
        Food.BONE.description = "pork";
        Food.BONE.description = "strawberry";

        System.out.println(Food.BONE.description);

    }
}


enum Food {
    BONE(""),
    MEAT(""),
    NOTHING("");
    String description; // mutowalne trzeba dodać final

    Food(String foodName) {
        this.description = foodName;
    }

    String getDescription() {
        return this.description;
    }
}