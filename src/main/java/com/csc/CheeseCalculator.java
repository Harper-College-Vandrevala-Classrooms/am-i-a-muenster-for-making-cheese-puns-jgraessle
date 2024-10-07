package com.csc;

public class CheeseCalculator {

    // variables used for the class 

    double organicHolder = 0; 
    Boolean organic = false;
    double moistPercent = 0.00;
    Boolean moisty = false;
    int moistyOrganic = 0;
    int cow = 0;
    int goat = 0;
    int ewe = 0;
    int buffalo = 0;
    int pasteurized = 0;
    int raw = 0;
    String greatestAnimal;

    //other class initialization
    private CheeseAnalyzer cheese;
    public CheeseCalculator(CheeseAnalyzer cheese) {
        this.cheese = cheese;
    }

    //method to test which animal has most cheese
    public void MilkAnimal() {
        if (cheese.wordNumber == 8) {
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Ewe")) {
              ewe = ewe + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Cow")) {
              cow = cow + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Goat")) {
              goat = goat + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Buffalo Cow")) {
              buffalo = buffalo + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Cow and Goat")) {
              cow = cow + 1;
              goat = goat + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Ewe and Cow")) {
              ewe = ewe + 1;
              cow = cow + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Ewe and Goat")) {
              ewe = ewe + 1;
              goat = goat + 1;
            }
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Cow, Goat and Ewe\"")) {
              ewe = ewe + 1;
            }
            if (cow > ewe && cow > goat && cow > buffalo) {
                greatestAnimal = "Cow";
            }
            if (ewe > cow && ewe > goat && ewe > buffalo) {
                greatestAnimal = "Ewe";
            }
            if (goat > ewe && goat > cow && goat > buffalo) {
                greatestAnimal = "Goat";
            }
            if (buffalo > ewe && buffalo > goat && buffalo > cow) {
                greatestAnimal = "Cow";
            }
        }
    }

    // method to test amount of each treatment type
    public void MilkTreatment() {
        if (cheese.wordNumber == 9) {
            if (cheese.cheeseData.get(cheese.wordNumber).equals("Pasteurized")) {
              pasteurized++;
            }
            if(cheese.cheeseData.get(cheese.wordNumber).equals("Raw Milk")) {
              raw++;
            }
        }
    }

    // method to test whether a cheese is organic and whether it is above 41% moisture
    public void MilkMoistOrganic() {
        if (cheese.wordNumber == 3) {
            try {
              moistPercent = Double.parseDouble(cheese.cheeseData.get(cheese.wordNumber));
            }
            catch (NumberFormatException e) {
            }
            if (moistPercent > 41) {
              moisty = true;
            }
        }
        else if (cheese.wordNumber > 6) {
            moisty = false;
        }
        if (cheese.wordNumber == 6) {
            try {
              organicHolder = Double.parseDouble(cheese.cheeseData.get(cheese.wordNumber));
            }
            catch (NumberFormatException e) {
            }
            if (organicHolder >= 1) {
            organic = true;
            }
        }
        else if (cheese.wordNumber > 6) {
            organic = false;
        }
        if (organic == true && moisty == true) {
            moistyOrganic = moistyOrganic + 1;
        }
    }
}
