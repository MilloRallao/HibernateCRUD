import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ModificarEstudiante {

	private static Scanner scanner;

	public static void main(String[] args) {
		// se crea una session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class)
				.buildSessionFactory();

		// se crea la sesion
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Modificando un objeto de tipo estudiante...");
			// Comienza la transacción
			session.beginTransaction();

			// Se lee el estudiante
			Estudiante tempestudiante = (Estudiante) session.get(Estudiante.class, 4);

			// Se modifica el estudiante
			System.out.println("Modificando al estudiante...");

			scanner = new Scanner(System.in);
			System.out.print("Nombre nuevo: ");
			String nombre = scanner.nextLine();
			System.out.println("Modificando el nombre del estudiante: " + tempestudiante.getNombre() + " por " + nombre);
			tempestudiante.setNombre(nombre);

			System.out.print("Apellido nuevo: ");
			String apellido = scanner.nextLine();
			System.out.println("Modificando el apellido del estudiante: " + tempestudiante.getApellido() + " por " + apellido);
			tempestudiante.setApellido(apellido);

			System.out.print("Correo nuevo: ");
			String correo = scanner.nextLine();
			System.out.println("Modificando el correo del estudiante: " + tempestudiante.getCorreo() + " por " + correo);
			tempestudiante.setCorreo(correo);

			session.update(tempestudiante);

			// Se finaliza la transacción
			session.getTransaction().commit();
			System.out.println("Modificado!");
		} finally {
			factory.close();
		}
	}
}