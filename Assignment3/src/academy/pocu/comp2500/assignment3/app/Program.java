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

            units.add(new Mine(new IntVector2D(14, 4), 1)); // 0
            units.add(new Marine(new IntVector2D(9, 7))); // 1
            units.add(new SmartMine(new IntVector2D(5, 2), 4, 2)); // 2
            units.add(new Marine(new IntVector2D(1, 5))); // 3

            units.add(new SmartMine(new IntVector2D(9, 3), 1, 1)); // 4
            units.add(new SmartMine(new IntVector2D(11, 6), 3, 1)); // 5
            units.add(new Turret(new IntVector2D(7, 7))); // 6
            units.add(new SmartMine(new IntVector2D(12, 0), 3, 3)); // 7

            units.add(new Wraith(new IntVector2D(12, 6))); // 8
            units.add(new SmartMine(new IntVector2D(13, 6), 1, 3)); // 9
            units.add(new Wraith(new IntVector2D(5, 7))); // A
            units.add(new Turret(new IntVector2D(11, 3))); // B

            units.add(new SmartMine(new IntVector2D(0, 3), 2, 1)); // C
            units.add(new Turret(new IntVector2D(9, 4))); // D
            units.add(new Mine(new IntVector2D(7, 0), 1)); // E
            units.add(new Tank(new IntVector2D(13, 7))); // F

//            units.add(new Destroyer(new IntVector2D(1, 7)));

            for (Unit unit : units) {
                simulationManager.spawn(unit);
            }

            int frame = 13;
            SimulationVisualizer visualizer = new SimulationVisualizer(units);
            for (int i = 0; i <= frame; ++i) {
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