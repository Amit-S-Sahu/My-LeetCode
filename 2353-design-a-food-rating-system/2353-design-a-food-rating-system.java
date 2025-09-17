class FoodRatings {
    Map<String, List<String>> cuisineMap;
    Map<String, Integer> rating;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        cuisineMap = new HashMap<>(n);
        rating = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            if (!cuisineMap.containsKey(cuisines[i])) {
                cuisineMap.put(cuisines[i], new ArrayList<>());
            }
            cuisineMap.get(cuisines[i]).add(foods[i]);
            rating.put(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        if (!rating.containsKey(food)) return;
        rating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        List<String> list = cuisineMap.get(cuisine);
        String max = "";
        int maxRating = -1;
        for (String food : list) {
            int curr = rating.get(food);
            if (curr > maxRating) {
                maxRating = curr;
                max = food;
            }
            else if (curr == maxRating) {
                if (max.compareTo(food) > 0) max = food;
            }
        }
        return max;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */