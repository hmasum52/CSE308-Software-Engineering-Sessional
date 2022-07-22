import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Hasan Masum(1805052)
 */
class GradeCalculatorTest {

    @Test
    @DisplayName("Invalid credit test")
    void testInvalidCreditInput() {
        GradeCalculator gradeCalculator = new GradeCalculator(1);
        assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(250));
    }

    /**
     * generate a random number in a given range [min, max):
     */
    public static double getRandomNumber(int min, int max) {
        return (int)((Math.random() * (max - min)) + min);
    }

    @Nested
    @DisplayName("3 credit mark tests")
    class ThreeCreditTest{
        GradeCalculator gradeCalculator;
        @BeforeEach
        void init(){
            gradeCalculator = new GradeCalculator(3);
        }

        @Test
        @DisplayName("A grade test")
        void testAGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(240, 300);
            assertEquals('A', gradeCalculator.calculateGrade(marks));
        }


        @Test
        @DisplayName("B grade test")
        void testBGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(210, 239);
            assertEquals('B', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("C grade test")
        void testCGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(180, 209);
            assertEquals('C', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("F grade test")
        void testFGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(0, 179);
            assertEquals('F', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("A grade boundary value test")
        void testAGradeBoundaryValues(){
            assertEquals('A', gradeCalculator.calculateGrade(299.5));
            assertEquals('A', gradeCalculator.calculateGrade(240));
            assertEquals('A', gradeCalculator.calculateGrade(239.5));
        }


        @Test
        @DisplayName("B grade boundary value test")
        void testBGradeBoundaryValues(){
            assertEquals('B', gradeCalculator.calculateGrade(239.4));
            assertEquals('B', gradeCalculator.calculateGrade(210));
            assertEquals('B', gradeCalculator.calculateGrade(209.5));
        }

        @Test
        @DisplayName("C grade boundary value test")
        void testCGradeBoundaryValues(){
            assertEquals('C', gradeCalculator.calculateGrade(209.4));
            assertEquals('C', gradeCalculator.calculateGrade(180));
            assertEquals('C', gradeCalculator.calculateGrade(179.5));
        }

        @Test
        @DisplayName("F grade boundary value test")
        void testFGradeBoundaryValues(){
            assertEquals('F', gradeCalculator.calculateGrade(179.4));
            assertEquals('F', gradeCalculator.calculateGrade(0));
        }

        @Test
        @DisplayName("Negative mark test")
        void testNegativeGradeInput(){
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(-0.6));
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(-10));
        }

        @Test
        @DisplayName("Mark greater than upper bound test")
        void testOutOfUpperBoundInput(){
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(300.4));
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(350));
        }

        @Test
        @DisplayName("String number input test")
        void testNumberInputAsString(){
            assertEquals('A', gradeCalculator.calculateGrade("260"));
        }

        @Test
        @DisplayName("Non number input test")
        void testNonNumberInput(){
            assertThrows(NumberFormatException.class, ()-> gradeCalculator.calculateGrade("hello"));
        }

    }

    @Nested
    @DisplayName("4 credit mark tests")
    class FourCreditTest{
        private GradeCalculator gradeCalculator;

        @BeforeEach
        void init(){
            this.gradeCalculator = new GradeCalculator(4);
        }

        @Test
        @DisplayName("A grade test")
        void testAGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(320, 400);
            assertEquals('A', gradeCalculator.calculateGrade(marks));
        }


        @Test
        @DisplayName("B grade test")
        void testBGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(280, 319);
            assertEquals('B', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("C grade test")
        void testCGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(240, 279);
            assertEquals('C', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("F grade test")
        void testFGrade(){
            double marks = GradeCalculatorTest.getRandomNumber(0, 239);
            assertEquals('F', gradeCalculator.calculateGrade(marks));
        }

        @Test
        @DisplayName("A grade boundary value test")
        void testAGradeBoundaryValues(){
            assertEquals('A', gradeCalculator.calculateGrade(399.5));
            assertEquals('A', gradeCalculator.calculateGrade(320));
            assertEquals('A', gradeCalculator.calculateGrade(319.5));
        }


        @Test
        @DisplayName("B grade boundary value test")
        void testBGradeBoundaryValues(){
            assertEquals('B', gradeCalculator.calculateGrade(319.4));
            assertEquals('B', gradeCalculator.calculateGrade(280));
            assertEquals('B', gradeCalculator.calculateGrade(279.5));
        }

        @Test
        @DisplayName("C grade boundary value test")
        void testCGradeBoundaryValues(){
            assertEquals('C', gradeCalculator.calculateGrade(279.4));
            assertEquals('C', gradeCalculator.calculateGrade(240));
            assertEquals('C', gradeCalculator.calculateGrade(239.5));
        }

        @Test
        @DisplayName("F grade boundary value test")
        void testFGradeBoundaryValues(){
            assertEquals('F', gradeCalculator.calculateGrade(239.4));
            assertEquals('F', gradeCalculator.calculateGrade(0));
        }

        @Test
        @DisplayName("Negative mark test")
        void testNegativeGradeInput(){
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(-0.6));
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(-10));
        }

        @Test
        @DisplayName("Mark greater than upper bound test")
        void testOutOfUpperBoundInput(){
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(400.4));
            assertThrows(IllegalArgumentException.class, () -> gradeCalculator.calculateGrade(450));
        }

        @Test
        @DisplayName("String number input test")
        void testNumberInputAsString(){
            assertEquals('A', gradeCalculator.calculateGrade("340"));
        }

        @Test
        @DisplayName("Non number input test")
        void testNonNumberInput(){
            assertThrows(NumberFormatException.class, ()-> gradeCalculator.calculateGrade("hello"));
        }
    }

}