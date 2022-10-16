public class Sweet{

    public Sweet(String name){
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(name));
    }

    public Sweet(String name, String ingredient) {
        this.name = name;
        this.ingredients = new ArrayList<>(Arrays.asList(ingredient));
    }

    public Sweet(String name, List<String>ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

}
