
package Main;

import java.util.Objects;

public class Fuvar {
    private String rendszam;
    private int ido;
    private int osszeg;
    private String fizetesiMod;
    
    
    public Fuvar(String rendszam, int ido, int osszeg, String fizetesiMod) {
        this.rendszam = rendszam;
        this.ido = ido;
        this.osszeg = osszeg;   
        this.fizetesiMod = fizetesiMod;
    }

    public String getRendszam() {
        return rendszam;
    }

    public int getIdo() {
        return ido;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public String getFizetesiMod() {
        return fizetesiMod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.rendszam);
        hash = 29 * hash + this.ido;
        hash = 29 * hash + this.osszeg;
        hash = 29 * hash + Objects.hashCode(this.fizetesiMod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fuvar other = (Fuvar) obj;
        if (this.ido != other.ido) {
            return false;
        }
        if (this.osszeg != other.osszeg) {
            return false;
        }
        if (!Objects.equals(this.rendszam, other.rendszam)) {
            return false;
        }
        return Objects.equals(this.fizetesiMod, other.fizetesiMod);
    }

    @Override
    public String toString() {
        return "Osztaly{" + "rendszam=" + rendszam + ", ido=" + ido + ", osszeg=" + osszeg + ", fizetesiMod=" + fizetesiMod + '}';
    }
    
    
}
