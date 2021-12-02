package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.ClearCommand;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DecreasePixelCommand;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.FillHorizontalLineCommand;
import academy.pocu.comp2500.assignment4.FillVerticalLineCommand;
import academy.pocu.comp2500.assignment4.ICommand;
import academy.pocu.comp2500.assignment4.IncreasePixelCommand;
import academy.pocu.comp2500.assignment4.OverdrawAnalyzer;
import academy.pocu.comp2500.assignment4.ToLowerCommand;
import academy.pocu.comp2500.assignment4.ToUpperCommand;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        {
            Canvas canvas = new Canvas(10, 10);

            canvas.drawPixel(0, 0, '*');
            canvas.drawPixel(1, 2, '$');
            canvas.drawPixel(0, 1, '&');

            System.out.println(canvas.getDrawing());
        }

        // 추가 테스트 1
        {
            OverdrawAnalyzer analyzer = new OverdrawAnalyzer(6, 6);
            CommandHistoryManager manager = new CommandHistoryManager((Canvas) analyzer);

            ArrayList<ICommand> commands = new ArrayList<>();
            commands.add(new ClearCommand());
            commands.add(new FillVerticalLineCommand(1, '.'));
            commands.add(new IncreasePixelCommand(0, 3));
            commands.add(new ToUpperCommand(1, 0));
            commands.add(new FillHorizontalLineCommand(4, 'X'));
            commands.add(new FillHorizontalLineCommand(4, 'V'));
            commands.add(new FillVerticalLineCommand(4, 't'));
            commands.add(new IncreasePixelCommand(4, 2));
            commands.add(new ToLowerCommand(2, 3));
            commands.add(new IncreasePixelCommand(0, 0));
            commands.add(new FillVerticalLineCommand(2, 'm'));
            commands.add(new ToLowerCommand(0, 4));
            commands.add(new ToLowerCommand(1, 0));
            commands.add(new DrawPixelCommand(3, 1, 'o'));
            commands.add(new FillVerticalLineCommand(2, 'y'));
            commands.add(new FillHorizontalLineCommand(1, 'A'));


            for (int i = 0; i < 8; i++) {
                manager.execute(commands.get(i));
            }

            manager.redo();

            for (int i = 8; i < 10; i++) {
                manager.execute(commands.get(i));
            }

            manager.redo();

            manager.execute(commands.get(10));

            manager.undo();

            for (int i = 11; i < 14; i++) {
                manager.execute(commands.get(i));
            }

            manager.undo();

            for (int i = 14; i < 16; i++) {
                manager.execute(commands.get(i));
            }


            System.out.print(analyzer.getDrawing());
            System.out.println(analyzer.getPixelHistory(0, 1)); // 오류 생기는 부분 직접 입력
        }
    }


}
