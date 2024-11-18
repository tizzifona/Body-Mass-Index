package projects.f5.massindex_java;

import projects.f5.massindex_java.controller.BmiController;
import projects.f5.massindex_java.models.BmiModel;
import projects.f5.massindex_java.models.Person;
import projects.f5.massindex_java.view.BmiView;

public final class App {
    public static void main(String[] args) {
        BmiView view = new BmiView();
        BmiModel model = new BmiModel(new Person(0, 0));
        BmiController controller = new BmiController(view, model);
        controller.run();
    }
}
