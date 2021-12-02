package academy.pocu.comp2500.assignment4;

//
// [강사] 포프  오전 10:30
// [설계 노트] 왜 커맨드가 유효성 검사를 하는가?
// (매우 긴 글입니다. :커피: 한 사발 떠온 뒤 읽으세요)
//
// 과제 4를 하다 보면 커맨드 히스토리 매니저가 아닌 각 커맨드 클래스가 redo()/undo()를 할 수 있는 유효한 상황인지 스스로 판단을 하게 됩니다.
// (undo/redo가 boolean을 반환하는 이유) '히스토리 매니저가 이걸 하는 게 맞지 않나?'라는 생각을 하셨을 분들을 위해 이런 설계가 나온 이유를 설명드리겠습니다.
//
// 사실 이 유효성 검증은 히스토리 매니저가 하는 방향으로도, 커맨드가 하는 방향으로도, 아니면 아예 안 하는 방향으로도 설계할 수 있습니다.
//
// 하지만 히스토리 매니저가 이걸 관리하게 설계한다면 여러 가지 전제조건이 필요합니다.
// 그중 가장 중요한 것은 캔버스의 모든 변경사항은 반드시 히스토리 매니저를 통해서 실행되어야 한다는 것입니다.
// 그렇지 않다면 히스토리 매니저는 자신을 거치지 않고 실행된 커맨드나 캔버스 함수 실행 때문에 제대로 된 검증을 하지 못합니다.
//
// 이런 상황이 발생할 수 있는 이유는 다음과 같습니다.
// 커맨드 시스템을 구현하기 이전부터 캔버스가 존재했음
// 후에 커맨드 시스템과 히스토리 매니저를 추가했지만 이전 방법도 여전히 사용 가능
// 이 시스템을 사용하는 프로그래머들이 반드시 새로운 방법을 따른다는 보장이 없음
//
// 즉, 클래스 설계 상 다른 프로그래머들이 새로운 방법(히스토리 매니저)을 잘 이해하지 못해서 예전 방법을 사용하는 일을 방지할 수단이 없으며,
// 이로 인해 발생하는 버그는 쉽게 발견 안 될 수도, 발견돼도 디버깅이 어려울 수도 있습니다.
//
// 클래스 설계 상 이걸 방지하고 싶다면 굳이 따로 커맨드 클래스를 만들지 않고 히스토리 매니저 안에 모든 필요한 함수를 넣어주면 됩니다. 하지만 결합도가 증가하겠죠?
//
// 그러면 커맨드 클래스가 따로 있고 기존의 캔버스도 손대지 않는다는 가정 하에 그나마 유효성 검사를 하려면 그 로직은 각 커맨드 클래스에 들어갈 수밖에 없습니다.
// 이렇게 하는 순간 커맨드 클래스의 의미가 약간 확장됩니다. 단순히 '명령을 내려 수행한다'라는 의미에서 '조건이 이럴 때 이 명령을 수행/취소/재실행한다'로요.
//
// 제가 위에서 '그나마' 유효성 검사를 한다고 표현한 이유는 모든 걸 다 검사할 수 없기 때문입니다.
// 커맨드 개체 자신이 바꾼 데이터가 뭔지 기억하는 정도만이 각 커맨드가 할 수 있는 유효성 검사의 전부니까요.
// (즉, '쉽게 확인할 수 있는 정도만 검증하자. 아예 없는 것보단 낫다')
//
// 그리고 이건 매우 중요한 주제인데요.
// 이 모든 문제는 캔버스를 히스토리 매니저의 생성자 매개변수로 전달해주는 대신
// 생성자 안에서 직접 캔버스 개체를 만들어서 사용하면 해결되는 문제이기도 합니다.
//
// 하지만 그러면 결국 결합도가 높아지죠.
// 결합도를 낮추고 유연성을 높이는 순간,
// 실수를 빨리 감지하기 위해 검증 로직 추가를 고려할 수도 있다는 것도 보여주는 과제랍니다.
// (단순한 디자인 패턴 연습이 아님. 그럴 거면 실습이었겠지...)
//
// 참고로 보통 실무에서는 유효성 검증을 아예 안 하고
// 커맨드와 히스토리 매니저를 사용하는('작성하는'이 아님) 프로그래머가 올바르게 코드를 작성할 것이라고 가정하는 일이 더 흔할 겁니다.
//
// 이렇듯 '유효한 연산을 책임지는 주체가 누구인가?'
// (예: 히스토리 매니저 vs 각 커맨드 vs 이걸 사용하는 프로그래머)라는 주제는 언제나 정답이 없고 여러 가지 측면을 고려한 뒤, 팀 내 합의를 통해 진행하는 게 옳습니다.


public abstract class CommandBase implements ICommand {
    private boolean canUndoTry;
    private Canvas canvas;

    protected CommandBase() {
    }

    // ---

    @Override
    public final boolean execute(final Canvas canvas) {
        if (this.canvas != null) {
            return false;
        }

        this.canvas = canvas;
        canUndoTry = doOperation(this.canvas);

        setLastWorkedBackup(this.canvas);
        return canUndoTry;
    }

    @Override
    public final boolean undo() {
        if (this.canvas == null) {
            return false;
        }

        if (!canUndoTry) {
            return false;
        }

        if (checkCanUpdate(this.canvas)) {
            undoOperation(this.canvas);
            canUndoTry = false;

            setLastWorkedBackup(this.canvas);
            return true;
        }

        return false;
    }

    @Override
    public final boolean redo() {
        if (this.canvas == null) {
            return false;
        }

        if (canUndoTry) {
            return false;
        }

        if (checkCanUpdate(this.canvas)) {
            canUndoTry = doOperation(this.canvas);

            setLastWorkedBackup(this.canvas);
            return canUndoTry;
        }

        return false;
    }

    // ---

    protected abstract boolean doOperation(final Canvas canvas);

    protected abstract void undoOperation(final Canvas canvas);

    protected abstract boolean checkCanUpdate(final Canvas canvas);

    protected abstract void setLastWorkedBackup(final Canvas canvas);

}
