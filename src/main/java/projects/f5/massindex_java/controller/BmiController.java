package projects.f5.massindex_java.controller;

import projects.f5.massindex_java.models.BmiModel;
import projects.f5.massindex_java.models.Person;
import projects.f5.massindex_java.view.BmiView;

public class BmiController {

    private BmiView view;
    private BmiModel model;

    public BmiController(BmiView view, BmiModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        double weight = view.askWeight();
        double height = view.askHeight();

        Person person = new Person(weight, height);
        model = new BmiModel(person);

        double bmi = model.calculateBMI();

        String classification = model.giveResultsBMI(bmi);

        view.showResults(bmi, classification);
    }
}
