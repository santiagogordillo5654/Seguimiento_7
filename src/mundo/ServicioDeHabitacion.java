package mundo;

class ServicioDeHabitacion extends Servicio {
    public ServicioDeHabitacion(String nombre) {
        super(nombre);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de habitación: " + getNombre() + " solicitado.");
    }
}