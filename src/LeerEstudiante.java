import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LeerEstudiante {
	
	public static void main(String[] args) {
		// se crea una session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class)
				.buildSessionFactory();

		// se crea la sesion
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Leyendo un objeto de tipo estudiante...");
			// Comienza la transacción
			session.beginTransaction();

			// Se lee el estudiante
			Estudiante tempestudiante = (Estudiante) session.get(Estudiante.class, 4);

			// Imprimir por pantalla los datos del objeto estudiante
			System.out.println("Mostrando al estudiante...");
			int id = tempestudiante.getId();
			String nombre = tempestudiante.getNombre();
			String apellido = tempestudiante.getApellido();
			String correo = tempestudiante.getCorreo();
			System.out.println("ID: " + id + "\n" + "Nombre: " + nombre + "\n" + "Apellido: " + apellido + "\n"
					+ "Correo: " + correo);

			// Se finaliza la transacción
			session.getTransaction().commit();
			System.out.println("Leido!");
		} finally {
			factory.close();
		}
	}
}