package mx.edu.utng.orders.model;



public class Vitamin {
    private  String idVitamin;
    private String nameVitamin;
    private float priceVitamin;
    private float doseVitamin;
    private String typeVitamin;

    public Vitamin(String idVitamin,String nameVitamin,float doseVitamin,float priceVitamin,String typeVitamin) {
        this.idVitamin = idVitamin;
        this.nameVitamin = nameVitamin;
        this.doseVitamin = doseVitamin;
        this.priceVitamin = priceVitamin;
        this.typeVitamin = typeVitamin;

    }


    public Vitamin(){
        this("","",0.0F,0.0F,"");
    }

    public String getTypeVitamin() {
        return typeVitamin;
    }

    public void setTypeVitamin(String typeVitamin) {
        this.typeVitamin = typeVitamin;
    }

    public float getDoseVitamin() {
        return doseVitamin;
    }

    public void setDoseVitamin(float doseVitamin) {
        this.doseVitamin = doseVitamin;
    }

    public float getPriceVitamin() {
        return priceVitamin;
    }

    public void setPriceVitamin(float priceVitamin) {
        this.priceVitamin = priceVitamin;
    }

    public String getNameVitamin() {
        return nameVitamin;
    }

    public void setNameVitamin(String nameVitamin) {
        this.nameVitamin = nameVitamin;
    }

    public String getIdVitamin() {
        return idVitamin;
    }

    public void setIdVitamin(String idVitamin) {
        this.idVitamin = idVitamin;
    }

    @Override
    public String toString() {
        return "Vitamin{" +
                "idVitamin='" + idVitamin + '\'' +
                ", nameVitamin='" + nameVitamin + '\'' +
                ", doseVitamin=" + doseVitamin +
                ", priceVitamin=" + priceVitamin +
                ", typeVitamin='" + typeVitamin + '\'' +
                '}';
    }
}
