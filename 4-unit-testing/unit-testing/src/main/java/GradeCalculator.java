public class GradeCalculator {
    private final int credit;

    public GradeCalculator(int credit) {
        this.credit = credit;
    }

    public char calculateGrade(String marks){
        return calculateGrade(Double.parseDouble(marks));
    }

    public char calculateGrade(double marks){
        switch(credit){
            case 3: return calculateGradeForThreeCredit(marks);
            case 4: return calculateGradeForFourCredit(marks);
            default: throw new IllegalArgumentException("Invalid credit hours");
        }
    }

    private char calculateGradeForThreeCredit(double marks){
        if(marks<0) throw new IllegalArgumentException("Invalid marks. Marks can't be negative");
        int roundedMarks = (int) Math.round(marks);
        if(roundedMarks<180) return 'F';
        if(roundedMarks<210) return 'C';
        if(roundedMarks<240) return 'B';
        if(marks<=300) return 'A';
        throw new IllegalArgumentException("Invalid marks. Marks can't be greater than 300");
    }
    
    private char calculateGradeForFourCredit(double marks){
        if (marks < 0) throw new IllegalArgumentException("Invalid marks. Marks can't be negative");
        int roundedMarks = (int)Math.round(marks);
        if (roundedMarks < 240) return 'F';
        if (roundedMarks < 280) return 'C';
        if (roundedMarks < 320) return 'B';
        if (marks <= 400) return 'A';
        throw new IllegalArgumentException("Invalid marks. Marks can't be greater than 400");
    }
}
