class Complex {

    double real;
    double image;

    // write methods here
    public void add(Complex num) {
        this.real = this.real + num.real;
        this.image = this.image + num.image;
    }

    public void subtract(Complex num) {
        this.real = this.real - num.real;
        this.image = this.image - num.image;
    }
}