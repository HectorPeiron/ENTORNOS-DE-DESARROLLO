package Vehiculos;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Vehiculo {
        private String marca;
        private String modelo;
        private int kms = 0;
        private String anoFabricacion;
        private String numBastidor;
        private boolean alquilado;

        public Vehiculo(String marca, String modelo, int kms, String anoFabricacion, String numBastidor, boolean alquilado) {
            this.marca = marca;
            this.modelo = modelo;
            this.kms = kms;
            this.anoFabricacion = anoFabricacion;
            this.numBastidor = numBastidor;
            this.alquilado = alquilado;
        }
        public Vehiculo(){

        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public int getKms() {
            return kms;
        }

        public void setKms(int kms) {
            this.kms += kms;
        }

        public String getAnoFabricacion() {
            return anoFabricacion;
        }

        public void setAnoFabricacion(String anoFabricacion) {
            this.anoFabricacion = anoFabricacion;
        }

        public String getNumBastidor() {
            return numBastidor;
        }

        public void setNumBastidor(String numBastidor) {
            this.numBastidor = numBastidor;
        }

        public boolean isAlquilado() {
            return alquilado;
        }

        public void setAlquilado(boolean alquilado) {
            this.alquilado = alquilado;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Vehiculo)) return false;

            Vehiculo vehiculo = (Vehiculo) o;

            return new EqualsBuilder().append(getNumBastidor(), vehiculo.getNumBastidor()).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(getNumBastidor()).toHashCode();
        }

        @Override
        public String toString() {
            return "Vehículo: " +
                    "marca= " + marca +
                    ", modelo= " + modelo +
                    ", kms " + kms +
                    ", anoFabricacion= " + anoFabricacion +
                    ", numBastidor= " + numBastidor +
                    ", alquilado= " + alquilado;
        }
}

