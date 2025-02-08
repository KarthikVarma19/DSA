class FoodRatings {
    class foodItem{
        String food;
        String cuisine;
        int rating;
        foodItem(String f, String c, int r){
            food = f;
            cuisine = c;
            rating = r;
        }
    }
    HashMap<String, foodItem> item;
    HashMap<String, TreeSet<foodItem>> cuis;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        item = new HashMap<>();
        cuis = new HashMap<>();
        for(int i = 0; i < n; i++){
            String food = foods[i], cuisine = cuisines[i];
            int rating = ratings[i];
            foodItem f = new foodItem(food, cuisine, rating);
            item.put(food, f);
            cuis.putIfAbsent(cuisine, new TreeSet<>(
                new Comparator<foodItem>(){
                    @Override
                    public int compare(foodItem a,  foodItem b){
                        if(a.rating != b.rating){
                            return b.rating - a.rating; //highest rating fast
                        }
                        return a.food.compareTo(b.food); //lexicographical order
                    }
                }
            ));
            cuis.get(cuisine).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodItem f = item.get(food);
        String cuisine = f.cuisine;
        TreeSet<foodItem> pq = cuis.get(cuisine);
        pq.remove(f);
        f.rating = newRating;
        //item.put(food, f);
        pq.add(f);

    }
    
    public String highestRated(String cuisine) {
        return cuis.get(cuisine).first().food;
    }
}

