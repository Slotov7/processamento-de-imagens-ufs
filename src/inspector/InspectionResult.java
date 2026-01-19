package inspector;

public record InspectionResult(int total, int withHoles, int withoutHoles) {
    @Override
    public String toString() {
        return "Total de objetos: " + total +
               "| Com furos: " + withHoles +
               "| Sem furos: " + withoutHoles;
    }

}
