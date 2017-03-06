package id.co.aribanilia.gdserver;

import id.co.aribanilia.gdserver.dao.*;
import id.co.aribanilia.gdserver.entity.*;
import id.co.aribanilia.gdserver.util.GDConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GdServerApplicationTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PermissionDao permissionDao;
	@Autowired
	private ClientDao clientDao;

	@Test
	public void addClient() {
		Client client = new Client(
				GDConstants.CLIENT.ADMIN,
				"Administrator",
				"admin123",
				3600);
		clientDao.save(client);
		client = new Client(
				GDConstants.CLIENT.USER,
				"User",
				"user123",
				180);
		clientDao.save(client);
	}

	@Test
	public void addUser() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "123";
		String passwordDecrypt = encoder.encode(password);
		User user = new User();
		user.setUsername("cihuy");
		user.setFullname("Lailatul Fitriana");
		user.setPassword(passwordDecrypt);
		user.setEmail("lyla.cihuy@gmail.com");
		user.setNoHandphone("08123456789");
		userDao.save(user);

		UserRole userRole = new UserRole("cihuy", "R00001");
		userRoleDao.save(userRole);
	}

	@Test
	public void addUserRole() {
		UserRole userRole = new UserRole("evan", "R00001");
		userRoleDao.save(userRole);
	}

	@Test
	public void addEntity() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = "qwd";
		String passwordDecrypt = encoder.encode(password);
		User user = new User();
		user.setUsername("ivan");
		user.setFullname("Ivan Aribanilia");
		user.setPassword(passwordDecrypt);
		user.setEmail("ivan.aribanilia@pegadaian.co.id");
		user.setNoHandphone("085775152222");
		userDao.save(user);
		user = new User();
		user.setUsername("angko");
		user.setFullname("Angko Aribanilia");
		passwordDecrypt = encoder.encode(password);
		user.setPassword(passwordDecrypt);
		user.setEmail("angko.j4u@gmail.com");
		user.setNoHandphone("085254106777");
		userDao.save(user);

		Role role = new Role("R00001", "Admin", "Administrator");
		roleDao.save(role);
		role = new Role("R00002", "User", "User");
		roleDao.save(role);

		Permission permission = new Permission("P00001", GDConstants.PERMISSION.USER_EDIT, "Add/Remove");
		permissionDao.save(permission);
		permission = new Permission("P00002", GDConstants.PERMISSION.USER_VIEW, "View");
		permissionDao.save(permission);

		RolePermission rolePermission = new RolePermission("R00001", "P00001");
		rolePermissionDao.save(rolePermission);
		rolePermission = new RolePermission("R00001", "P00002");
		rolePermissionDao.save(rolePermission);
		rolePermission = new RolePermission("R00002", "P00002");
		rolePermissionDao.save(rolePermission);

		UserRole userRole = new UserRole("ivan", "R00001");
		userRoleDao.save(userRole);
		userRole = new UserRole("angko", "R00002");
		userRoleDao.save(userRole);
	}

}
