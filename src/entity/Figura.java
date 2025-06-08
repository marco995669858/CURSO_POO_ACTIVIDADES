package entity;

public abstract class Figura {
	protected String tipo;

    public Figura(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public abstract double calcularArea();
}
