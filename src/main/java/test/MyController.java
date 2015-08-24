package test;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class MyController {

	private final Result result;

	/**
	 * @deprecated CDI-eyes only
	 */
	protected MyController() {
		this(null);
	}
	
	@Inject
	public MyController(Result result) {
		this.result = result;
		
	}
	
	@Get("/")
	public void index() {
		
	}
	
	public void redirect() {
		result.redirectTo(this).redirected();
	}
	
	public void redirected() {
		
	}
	
}
