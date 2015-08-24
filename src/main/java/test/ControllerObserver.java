package test;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.ControllerFound;

public class ControllerObserver {

	private final Result result;

	/**
	 * @deprecated CDI-eyes only
	 */
	protected ControllerObserver() {
		this(null);
	}
	
	@Inject
	public ControllerObserver(Result result) {
		this.result = result;
	}
	
	public void includer(@Observes ControllerFound controllerFound) {
		result
			.include("controller", controllerFound.getController())
			.include("action", controllerFound.getMethod().getMethod().getName());
	}
	
}
