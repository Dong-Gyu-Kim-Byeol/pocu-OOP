package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.*;
import academy.pocu.comp2500.assignment3.registry.Registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        {
            Registry registry = new Registry();
            App app = new App(registry);
            registry.validate();
        }

//        {
//            SimulationManager simulationManager = SimulationManager.getInstance();
//
//            Unit u0 = new Mine(new IntVector2D(12, 1), 2);
//            Unit u1 = new Marine(new IntVector2D(0, 5));
//            Unit u2 = new Turret(new IntVector2D(5, 6));
//            Unit u3 = new Tank(new IntVector2D(2, 4));
//            Unit u4 = new Marine(new IntVector2D(2, 4));
//            Unit u5 = new Wraith(new IntVector2D(2, 7));
//
//            ArrayList<Unit> units = new ArrayList<>();
//
//            units.add(u0);
//            units.add(u1);
//            units.add(u2);
//            units.add(u3);
//            units.add(u4);
//            units.add(u5);
//
//            for (Unit unit : units) {
//                simulationManager.spawn(unit);
//            }
//
//            int frame = 10;
//            SimulationVisualizer visualizer = new SimulationVisualizer(units);
//            for (int i = 0; i < frame; ++i) {
//                clearConsole();
//                visualizer.visualize(i, simulationManager.getUnits());
//                simulationManager.update();
////                continueOnEnter();
//            }
//        }

        {
            SimulationManager simulationManager = SimulationManager.getInstance();
            simulationManager.clear();

            ArrayList<Unit> units = new ArrayList<>();

            units.add(new Marine(new IntVector2D(12, 6))); // 0
            units.add(new Turret(new IntVector2D(7, 4))); // 1
            units.add(new SmartMine(new IntVector2D(2, 5), 2, 2)); // 2
            units.add(new Mine(new IntVector2D(7, 3), 2)); // 3

            units.add(new Mine(new IntVector2D(7, 7), 4)); // 4
            units.add(new Turret(new IntVector2D(1, 6))); // 5
            units.add(new Mine(new IntVector2D(11, 0), 4)); // 6
            units.add(new SmartMine(new IntVector2D(3, 0), 2, 1)); // 7

            units.add(new Turret(new IntVector2D(10, 0))); // 8
            units.add(new Turret(new IntVector2D(13, 3))); // 9
            units.add(new Turret(new IntVector2D(14, 2))); // A
            units.add(new Tank(new IntVector2D(14, 6))); // B

            units.add(new SmartMine(new IntVector2D(10, 0), 1, 3)); // C
            units.add(new Marine(new IntVector2D(12, 6))); // D
            units.add(new Wraith(new IntVector2D(8, 7))); // E
//            units.add(new Wraith(new IntVector2D(15, 7))); // F

            units.add(new Destroyer(new IntVector2D(1, 7)));

            for (Unit unit : units) {
                simulationManager.spawn(unit);
            }

            int frame = 3;
            SimulationVisualizer visualizer = new SimulationVisualizer(units);
            for (int i = 0; i < frame; ++i) {
                clearConsole();
                visualizer.visualize(i, simulationManager.getUnits());
                simulationManager.update();
//                continueOnEnter();
            }
        }

        {
//            MapParser.parser();
        }
    }

    public static void continueOnEnter() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Press enter to continue");
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}