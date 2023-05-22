package com.PNM3.Deputy_RESTApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.PNM3.Deputy_RESTApi.controller.DeputyController;
import com.PNM3.Deputy_RESTApi.model.Deputy;
import com.PNM3.Deputy_RESTApi.service.DeputyService;

@SpringBootApplication
public class DeputyRestApiApplication { //implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	DeputyService deputyService;
	
	@Autowired
	DeputyController deputyControler;
	
	public static void main(String[] args) {
		SpringApplication.run(DeputyRestApiApplication.class, args);
	}

	/*
	@Override
    public void run(String... args) throws Exception {
		
		long id1 = 2;
		var val = deputyService.getDeputyById(id1);
		val.ifPresentOrElse
		(
	            (value)
	                -> { System.out.println(
	                         value.getFirstName() +" "+ value.getLastName() ); },
	            ()
	                -> { System.out.println("Value is empty");
	                	Deputy dep = new Deputy();
	                	dep.setFirstName("Jonho");
	                	dep.setLastName("Test");
	                	deputyControler.createDeputy(dep);
	                });	
		
		
		
        long id2 = 4;
        val = deputyService.getDeputyById(id2);

        if (val.isPresent()) {
            System.out.println(val.get().getFirstName() +" "+ val.get().getLastName());
        } else {
            System.out.printf("No city found with id %d%n", id2);
        }
     }
     */  
		/*
        String sql = "INSERT INTO deputies (first_name, last_name, int_department, id_political_party) "
        		+ " VALUES ("
                + "'Constance', 'Laloux', 74, 2)";
         
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        } 
       
        Iterable<Deputy> deputy = deputyService.getDeputies();
        List<String> result = 
				  StreamSupport.stream(deputy.spliterator(), false)
				  .map(n->n.getLastName() +" " + n.getFirstName())
				  .sorted()
				    .collect(Collectors.toList());
        result.forEach(System.out::println);
        deputy.forEach(deput -> System.out.println(deput.getFirstName() +" "+ deput.getLastName()));
        */
	
        
		
		
    
    
}
