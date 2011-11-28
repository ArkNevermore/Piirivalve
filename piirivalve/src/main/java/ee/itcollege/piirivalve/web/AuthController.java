package ee.itcollege.piirivalve.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthController {

	public static String user () {
		   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   return auth.getName();
		}
}
