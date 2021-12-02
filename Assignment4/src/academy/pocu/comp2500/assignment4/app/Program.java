package academy.pocu.comp2500.assignment4.app;

import academy.pocu.comp2500.assignment4.App;
import academy.pocu.comp2500.assignment4.Canvas;
import academy.pocu.comp2500.assignment4.ClearCommand;
import academy.pocu.comp2500.assignment4.CommandHistoryManager;
import academy.pocu.comp2500.assignment4.DrawPixelCommand;
import academy.pocu.comp2500.assignment4.FillHorizontalLineCommand;
import academy.pocu.comp2500.assignment4.FillVerticalLineCommand;
import academy.pocu.comp2500.assignment4.registry.Registry;


public class Program {

    public static void main(String[] args) {
        {
            Registry registry = new Registry();
            App app = new App(registry);
            registry.validate();
        }

        {
            Canvas canvas = new Canvas(10, 10);

            canvas.drawPixel(0, 0, '*');
            canvas.drawPixel(1, 2, '$');
            canvas.drawPixel(0, 1, '&');

            System.out.println(canvas.getDrawing());
        }

        {
            // BasicUndoOrder, BasicRedoOrder 테스트 케이스 추가 by 카이지

            Canvas canvas = new Canvas(20, 10);
            CommandHistoryManager chm = new CommandHistoryManager(canvas);
            DrawPixelCommand c1 = new DrawPixelCommand(1, 2, '1');
            DrawPixelCommand c2 = new DrawPixelCommand(3, 5, '2');

            assert (chm.execute(c1));
            assert (chm.execute(c2));

            assert (chm.undo());
            assert (chm.redo());

            assert (chm.undo());

            canvas.drawPixel(1, 2, '5');

            assert (!chm.undo());
            assert (chm.redo());
        }

        {
            // 올바른 결과:
            // +-------------------------+
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |LLLLLLLLLLLLLLLLnLzLLLLLL|
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |                n z      |
            // |5555555555555555555555555|
            // |                n z      |
            // |                n z      |
            // +-------------------------+
            //
            // 1. drawPixel(12, 20, r)
            // 2. clear()
            // 3. redo
            // 4. fillHorizontalLine(8, L)
            // 5. redo
            // 6. fillVerticalLine(18, z)
            // 7. fillVerticalLine(16, n)
            // 8. fillHorizontalLine(27, 5)

            Canvas canvas = new Canvas(25, 30);
            CommandHistoryManager chm = new CommandHistoryManager(canvas);

            System.out.println(canvas.getDrawing());
            chm.execute(new DrawPixelCommand(12, 20, 'r'));
            System.out.println(canvas.getDrawing());
            chm.execute(new ClearCommand());
            System.out.println(canvas.getDrawing());
            chm.redo();
            System.out.println(canvas.getDrawing());
            chm.execute(new FillHorizontalLineCommand(8, 'L'));
            System.out.println(canvas.getDrawing());
            chm.redo();
            System.out.println(canvas.getDrawing());
            chm.execute(new FillVerticalLineCommand(18, 'z'));
            System.out.println(canvas.getDrawing());
            chm.execute(new FillVerticalLineCommand(16, 'n'));
            System.out.println(canvas.getDrawing());
            chm.execute(new FillHorizontalLineCommand(27, '5'));
            System.out.println(canvas.getDrawing());
        }
    }


}
