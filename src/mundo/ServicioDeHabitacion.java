package mundo;
/*
 * @author Santiago Gordillo Molina,Sebastian Roman Sanchez
 * 
 * Universidad del Quindio
 * Facultad de ingenieria 
 * ingenieria de sistemas y computacion
 */
class ServicioDeHabitacion extends Servicio {
    public ServicioDeHabitacion(String nombre) {
        super(nombre);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de habitación: " + getNombre() + " solicitado.");
    }
}