import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CrearEstudiante {

	public static void main(String[] args) {
		// se crea una session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class)
				.buildSessionFactory();

		// se crea la sesion
		Session session = factory.getCurrentSession();
		try {
			// Crea un objeto de tipo estudiante
			System.out.println("Creando un nuevo objeto de tipo estudiante...");
			Estudiante tempestudiante = new Estudiante("Goku", "García", "goku.garcia@namek.com");

			// Comienza la transacción
			session.beginTransaction();

			// Se graba el objeto estudiante
			System.out.println("Grabando el estudiante...");
			session.save(tempestudiante);

			// Se finaliza la transacción
			session.getTransaction().commit();
			System.out.println("Grabado!");
		} finally {
			factory.close();
		}
	}
}