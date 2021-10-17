package com.spark3.olbank;

import com.spark3.olbank.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OlbankApplication {

	@Autowired
	private UserRepository repository;

/*
	@PostConstruct
	public void initUsers() throws ParseException {
		Long a = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		String password = "admin123";

		BCryptPasswordEncoder bCryptPasswordEncoder = new  BCryptPasswordEncoder() ;
		//List <Authority> authorities = registerRequest.getAuthorities();
		password = bCryptPasswordEncoder.encode(password);
		List<Role> role = null; //new ArrayList<>();

		// Stream.of( new Role(RoleName.ROLE_USER)).collect(Collectors.toList());
		List<Userx> users = Stream.of(
				new Userx(a,"lotfi","Sali","lotfi.sali@esprit.tn","cité ghazel",1000,"lotfi",password,"23358899","tunisie","sfax","2080",true,null,role)
		).collect(Collectors.toList());
		repository.saveAll(users);
	} */
//
	public static void main(String[] args) {
		SpringApplication.run(OlbankApplication.class, args);
	}

}
