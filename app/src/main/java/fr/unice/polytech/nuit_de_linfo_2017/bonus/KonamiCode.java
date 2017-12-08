package fr.unice.polytech.nuit_de_linfo_2017.bonus;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * Created by user on 08/12/2017.
 */

public class KonamiCode {

    private static final List<KSInput> code = new ArrayList<>(Arrays.asList(KSInput.UP,KSInput.UP,KSInput.DOWN,KSInput.DOWN,KSInput.LEFT,KSInput.RIGHT,KSInput.LEFT,KSInput.RIGHT,KSInput.B,KSInput.A)) ;
    public enum KSInput {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        A,
        B
    }

    private Deque<KSInput> deque;

    public KonamiCode() {
        this.deque = new ArrayDeque();
    }

    public void addInput(KSInput input) {
        if (deque.size() < 10) {
            deque.addLast(input);
        } else {
            deque.addLast(input);
            deque.pollFirst();
        }
    }

    public Boolean isComplete() {
        List<KSInput> list = new ArrayList<>(deque);
        List<KSInput> list2 = new ArrayList<>(code);
        boolean b = list.equals(list2);
        return (list.equals(code));
    }

}
