import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BorrarEstudiante {
	
	public static void main(String[] args) {
		// se crea una session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Estudiante.class)
				.buildSessionFactory();
		
		// se crea la sesion
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Borrando un objeto de tipo estudiante...");
			// Comienza la transacción
			session.beginTransaction();
			
			// Se lee el estudiante a borrar
			Estudiante tempestudiante = (Estudiante) session.get(Estudiante.class, 3);
			
			// Se borra el objeto estudiante
			System.out.println("Borrando el estudiante...");
			session.delete(tempestudiante);
			
			// Se finaliza la transacción
			session.getTransaction().commit();
			System.out.println("Borrado!");
		} finally {
			factory.close();
		}
	}
}