package enumerated;

import java.util.*;

import static enumerated.AlarmPoints.*;
import static net.mindview.util.Print.*;

public class EnumSets {

    public static void main(String[] args) {

        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); // Empty set

        points.add(BATHROOM);
        print(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);
    }
}