package model;

public class Usuarios {
    private int idUsuarios;
    private String nombreUsarios;
    private String coreoUsuarios;
    private String passUsuarios;

    public Usuarios() {
    }

    public Usuarios(int idUsuarios, String nombreUsarios, String coreoUsuarios, String passUsuarios) {
        this.idUsuarios = idUsuarios;
        this.nombreUsarios = nombreUsarios;
        this.coreoUsuarios = coreoUsuarios;
        this.passUsuarios = passUsuarios;
    }

    public int getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNombreUsarios() {
        return nombreUsarios;
    }

    public void setNombreUsarios(String nombreUsarios) {
        this.nombreUsarios = nombreUsarios;
    }

    public String getCoreoUsuarios() {
        return coreoUsuarios;
    }

    public void setCoreoUsuarios(String coreoUsuarios) {
        this.coreoUsuarios = coreoUsuarios;
    }

    public String getPassUsuarios() {
        return passUsuarios;
    }

    public void setPassUsuarios(String passUsuarios) {
        this.passUsuarios = passUsuarios;
    }

    @Override
    public String toString() {
        return "Usuarios [idUsuarios=" + idUsuarios + ", nombreUsarios=" + nombreUsarios + ", coreoUsuarios="
                + coreoUsuarios + ", passUsuarios=" + passUsuarios + "]";
    }
}
