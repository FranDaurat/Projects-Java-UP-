import javax.swing.*;

public class CajaVelocidades {
    private String fabricante;
    private int marcha;
    private char tipo_relacion;

    public CajaVelocidades(String fabricante, int cant_marchas, char tipo_relacion) {
        this.fabricante = fabricante;

        if (tipo_relacion != 'L' && tipo_relacion != 'M' && tipo_relacion != 'C') {
            throw new IllegalArgumentException("Tipo de relación inválido. Debe ser 'L', 'M' o 'C'.");
        }
        this.marcha = cant_marchas;
        this.tipo_relacion = tipo_relacion;
    }

    public void setMarchas(int marcha) {
        if (marcha < 1 || marcha > 5) {
            throw new IllegalArgumentException("Marcha inválida. Debe estar entre 1 y 5.");
        }
        this.marcha = marcha;
    }

    @Override
    public String toString() {
        return "CajaVelocidades{" +
                "fabricante='" + fabricante + '\'' +
                ", marcha=" + marcha;
    }
}
