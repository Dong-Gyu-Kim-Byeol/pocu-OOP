package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber() {
        this(0, 0);
    }

    public ComplexNumber(double real) {
        this(real, 0);
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        if (imaginary == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImaginary() {
        if (real == 0) {
            return true;
        } else {
            return false;
        }
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(real, -imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double newReal;
        double newImaginary;

        //(a + bi)(c + di) = ac + adi + bci + bdi^2   // i^2 = -1 임
        //                 = (ac - bd) + (ad + bc)i
        newReal = this.real * num.real - this.imaginary * num.imaginary;
        newImaginary = this.real * num.imaginary + this.imaginary * num.real;

        return new ComplexNumber(newReal, newImaginary);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double newReal;
        double newImaginary;

        // (a + bi) / (c + di) = [(a + bi) / (c + di)] * [(c - di) / (c - di)]
        //                    = (a + bi)(c - di) / (c^2 + d^2)
        double denominator = num.real * num.real + num.imaginary * num.imaginary;
        return this.multiply(num.getConjugate()).divide(denominator);
    }

    public ComplexNumber divide(double num) {
        return new ComplexNumber(this.real / num, this.imaginary / num);
    }
}
