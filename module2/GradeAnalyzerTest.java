package module2;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 
import java.util.ArrayList; 
import java.util.Arrays; 
import module2.GradeAnalyzer;

public class GradeAnalyzerTest {
    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() { 
        ArrayList<Integer> scores = new ArrayList<>(); 
        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test
    void calculateAverage_returnsCorrectAverage_forTypicalScores() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100)); 
        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores));
    }
 
    @Test
    void calculateAverage_returnsSingleValue_whenListHasOneItem() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(60)); 
        assertEquals(60.0, GradeAnalyzer.calculateAverage(scores));
    } 
 
    @Test
    void calculateAverage_returnsDouble_notInteger() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(1, 2)); 
        assertEquals(1.5, GradeAnalyzer.calculateAverage(scores)); 
    } 
 
    @Test 
    void calculateAverage_handlesAllSameValues() { 
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(34, 34, 34)); 
        assertEquals(34.0, GradeAnalyzer.calculateAverage(scores)); 
    }
}
